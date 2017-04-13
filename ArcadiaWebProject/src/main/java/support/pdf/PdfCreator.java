package support.pdf;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.TextPosition;
import support.Collection;
import support.pdf.tableCreator.easytable.*;

import javax.swing.text.Position;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static support.pdf.tableCreator.easytable.Cell.HorizontalAlignment.*;

public class PdfCreator {
    private Integer pageCounter;
    private final  String  FILE_data;
    private String date;
    Collection collection;
    private List<String> headers;
    private int reportType;

    public PdfCreator(String fileName, Collection collection, int reportType){
        // output file name
        FILE_data = fileName + ".pdf";
        // current date in next format: 2014-09-10T17:11:35.847-07:00
        this.date = OffsetDateTime.now().toString();
        // text, which will be printed in pdf
        this.collection = collection;
        this.pageCounter = 0;
        this.reportType = reportType;
        this.headers = new ArrayList<>();
        createHeaders(fileName, collection);
    }

    public void createPDF() throws IOException {

        TextCursor textCursor;
        PDDocument document = null;
        PDPageContentStream contentStream = null;
        PDPage page;

        try {
            // creating empty pdf document
            document = new PDDocument();
            page = addNewPage(document);
            textCursor = new TextCursor(page, 65, 65);

            // Writing name of Report

            // Insert logo
            insertImage(document, page, System.getProperty("user.dir") + "\\images\\logo.png", textCursor);

            textCursor.setAlignment(TextCursor.Align.CENTER);
            writeText( document, page, headers.get(0), 14, textCursor);
            writeText( document, page, date, 12, textCursor);
            //writePageNumber( document, page, pageCounter.toString(), 10, textCursor);

            textCursor.setCursorToLeft();
            // Writing main information
            createTable(document, page, collection.outer, textCursor);

            textCursor.setAlignment(TextCursor.Align.LEFT);

            // Writing additional information
            if (headers.size() == 2)
                if (!headers.get(1).isEmpty())
                writeText(document, page, headers.get(1)+"\n", 12, textCursor) ;
        }
        finally {
            if (document != null) {
                // Saving the document
                //  document.save("src\\main\\java\\support\\pdf\\reports\\" + FILE_data) ;
                String savePAth = System.getProperty("user.dir");
                document.save( savePAth + "\\" + FILE_data) ;
                //Closing the document
                document.close() ;
            }
        }
    }

    private void createHeaders (String fileName, Collection collection) {

        String[] header = fileName.split("_");
        switch (reportType) {
            case(1):
                headers.add("Signed users between dates " + header[1] + " and " +  header[2]);
                headers.add("Number of registered students: " +
                (collection.outer.size() - 1) + " people");
                break;
            case(2):
                headers.add("Courses between dates " + header[1] + " and " +  header[2]);
                break;
            case(3):
                headers.add("Users rating" );
                break;
            case(4):
                headers.add("Groups rating");
                break;
            case(5):
                headers.add("Courses");
                break;
            case(6):
                break;
            case(7):
                break;
            default: break;
        }
    }

    public PDPage addNewPage(PDDocument document) throws IOException {
        PDPage page = new PDPage();
        document.addPage(page);
        pageCounter++;
        return page;
    }

    private void createTable(PDDocument document, PDPage page, List<ArrayList<String>> data, TextCursor textCursor) throws IOException {

        PDFont font = PDType1Font.TIMES_ROMAN;
        int fontSize = 12;
        int i = 0;
        List<String> firstRow = data.get(0);
        Row.RowBuilder rowBuilder;
        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false);

        try {
            // Define the table structure
            Table.TableBuilder tableBuilder = new Table.TableBuilder();

            // column's size
            int length = ((int)textCursor.getWidth()) / firstRow.size() ;

            for (String header : firstRow) {
                tableBuilder.addColumnOfWidth(length + header.length());
            }

            tableBuilder.setFontSize(fontSize).setFont(font);

            data.size();

            // adding rows to the table
            for (List<String> row : data) {
                rowBuilder = new Row.RowBuilder();
                for (String col : row) {
                    rowBuilder.add(Cell.withText(col)
                            .setHorizontalAlignment(LEFT)
                            .withHorizontalBorders());
                }
                tableBuilder.addRow(rowBuilder.setBackgroundColor(i++ % 2 == 0 ? new Color(215, 238, 245) : Color.WHITE).build());
            }

            // Draw! --------------------------------------------
            float ty = (new TableDrawer(contentStream, tableBuilder.build(), textCursor.getCurentX(), textCursor.getCurentY())).draw();
            textCursor.setCurentY(ty-20);
        } finally {
            //Closing the content stream
            if (contentStream != null)
                contentStream.close() ;
        }
    }

    private void writePageNumber(PDDocument document, PDPage page, String text, int fontSize, TextCursor textCursor) throws IOException {

        textCursor.setCurentY(textCursor.getStartY() - 750); // 42
        writeText(document, page, text, 12, textCursor);
    }

    private void writeText(PDDocument document, PDPage page, String text, int fontSize, TextCursor textCursor) throws IOException {

        float leading = 1.5f * fontSize;
        PDFont font = PDType1Font.TIMES_ROMAN;
        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false);

        int i = 0;

        // Split original text to short strings
        List<String> lines = splitToStrings(text, fontSize, font, textCursor.getWidth());

        try {
            // starting content stream
            contentStream.beginText();

            contentStream.newLineAtOffset(textCursor.getCurentX(),textCursor.getCurentY());

            //Writing text in the form of string
            for (String line : lines) {

                if ((textCursor.getCurentY()) < 42) {
                    contentStream.endText();
                    addNewPage(document);
                    // starting content stream
                    contentStream.beginText();
                    contentStream.newLineAtOffset(textCursor.getCurentX(),textCursor.getCurentY());
                }

                // setting font parameters: type and size
                contentStream.setFont(font, fontSize);
                if ( i == 0) {
                    setAlignmnet(textCursor, line, font, fontSize);
                    i++;
                }
                contentStream.newLineAtOffset(textCursor.getCurentX(),0);
                contentStream.showText(line);
                contentStream.newLineAtOffset(-textCursor.getCurentX(), -leading);
                textCursor.setCurentY(textCursor.getCurentY() - leading);
            }

            // end content stream
            contentStream.endText();
        } finally {
            //Closing the content stream
            if (contentStream != null)
                contentStream.close() ;
        }
    }

    private void setAlignmnet(TextCursor textCursor, String line, PDFont font, int fontSize) throws IOException {
        switch (textCursor.getAlignment()){
            case RIGHT:
                textCursor.setCursorToRight(line);
                break;
            case CENTER:
                textCursor.setCursorToCenter(line, font,fontSize);
                break;
            case LEFT:
                //textCursor.setCursorToLeft();
                break;
        }

    }

    private List<String> splitToStrings(String textNL, int fontSize, PDFont font, float width) throws IOException {

        List<String> lines = new ArrayList<String>();
        for (String text : textNL.split("\n")) {
            int lastSpace = -1;
            while (text.length() > 0) {
                int spaceIndex = text.indexOf(' ', lastSpace + 1);
                if (spaceIndex < 0)
                    spaceIndex = text.length();
                String subString = text.substring(0, spaceIndex);
                float size = fontSize * font.getStringWidth(subString) / 1000;
                //System.out.printf("'%s' - %f of %f\n", subString, size, width);
                if (size > width)
                {
                    if (lastSpace < 0)
                        lastSpace = spaceIndex;
                    subString = text.substring(0, lastSpace);
                    lines.add(subString);
                    text = text.substring(lastSpace).trim();
                    //System.out.printf("'%s' is line\n", subString);
                    lastSpace = -1;
                }
                else if (spaceIndex == text.length())
                {
                    lines.add(text);
                    //System.out.printf("'%s' is line\n", text);
                    text = "";
                }
                else
                {
                    lastSpace = spaceIndex;
                }
            }
        }

        return lines;
    }

    private void insertImage(PDDocument document,PDPage page, String path, TextCursor textCursor) throws IOException {

        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false);

        try {
            //Creating PDImageXObject object
            PDImageXObject pdImage = PDImageXObject.createFromFile(path, document);
            // 1:3
            pdImage.setWidth(90);
            pdImage.setHeight(30);

            //Drawing the image in the PDF document
            contentStream.drawImage(pdImage, textCursor.getCurentX() + 420 , textCursor.getCurentY() + 20);
        } finally {
            //Closing the content stream
            if (contentStream != null)
                contentStream.close() ;
        }

    }
}
