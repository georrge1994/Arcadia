package pdf_creator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import firebase_communication.Collection;
import pdf_creator.tableCreator.easytable.*;

import javax.xml.soap.Text;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static pdf_creator.tableCreator.easytable.Cell.HorizontalAlignment.*;

public class PdfCreator {
    private Integer pageCounter;
    private final  String  FILE_data;
    private String date;
    Collection collection;
    private List<String> headers;

    public PdfCreator(String fileName, Collection collection){
        // output file name
        FILE_data = fileName + ".pdf";
        // current date in next format: 2014-09-10T17:11:35.847-07:00
        this.date = OffsetDateTime.now().toString();
        // text, which will be printed in pdf_creator
        this.collection = collection;
        this.pageCounter = 0;
        this.headers = new ArrayList<>();
        createHeader(fileName);
    }

    public void createPDF() throws IOException {

        TextCursor textCursor;
        PDDocument document = null;
        PDPageContentStream contentStream = null;
        PDPage page;

        try {
            // creating empty pdf_creator document
            document = new PDDocument();

            page = addNewPage(document, collection);

            textCursor = new TextCursor(page, 65, 65);

            formatDate(collection);

            // Writing name of report
            page = showReportName(textCursor, page, document);

            textCursor.setAlignment(TextCursor.Align.LEFT);
            // Writing additional information
            showAdditionalText(textCursor, page, document);

            textCursor.setAlignment(TextCursor.Align.LEFT);
            // Writing main information
            page  = createTable(document, page, collection.outer, textCursor);

            // Writing additional information
            if (headers.size() == 2)
                if (!headers.get(1).isEmpty())
                writeText(document, page, headers.get(1)+"\n", 12, textCursor) ;
        }
        finally {
            if (document != null) {
                // Saving the document
                String savePAth = System.getProperty("user.dir");
                document.save( savePAth + "\\" + FILE_data) ;
                //Closing the document
                document.close() ;
            }
        }
    }

    private void formatDate (Collection collection) {
        for (int i = 0; i < collection.outer.get(0).size(); i++) {
            if (collection.outer.get(0).get(i).contains("Date"))
                for (int j = 1; j < collection.outer.size(); j++) {
                    Date date = new Date();
                    date.setTime(Long.parseLong(collection.outer.get(j).get(i)));
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String registerDate = formatter.format(date);
                    collection.outer.get(j).remove(i);
                    collection.outer.get(j).add(i,registerDate);
                }
        }
    }

    private void createHeader (String fileName) {
        String header = "";
        String[] words = fileName.split("_");
        String[] camelCaseWords = words[0].split("(?=[A-Z])");
        for (String s: camelCaseWords) {
            header = header + s.toLowerCase() + " ";
        }
        if (header.contains("between dates"))
            header += words[1] +" and " + words[2];
        header = header.substring(0, 1).toUpperCase() + header.substring(1);
        headers.add(header);
    }

    public PDPage addNewPage(PDDocument document, Collection collection) throws IOException {

        PDPage page;

        if(collection.outer.get(0).size() > 5)
            // landscape
            page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
        else
            // portrait
            page = new PDPage(new PDRectangle(PDRectangle.A4.getWidth(),PDRectangle.A4.getHeight()));

        document.addPage(page);

        pageCounter++;

        return page;
    }

    public PDPage showReportName (TextCursor textCursor, PDPage page, PDDocument document) throws IOException {
        // Writing name of Report and date of creation
        textCursor.setAlignment(TextCursor.Align.CENTER);
        page = writeText( document, page, headers.get(0), 14, textCursor);
        page = writeText( document, page, date, 12, textCursor);
        return page;
    }

    public void showAdditionalText(TextCursor textCursor, PDPage page, PDDocument document) throws IOException {

        // Insert logo
        this.getClass().getClassLoader().getResourceAsStream("logo.png");
        insertImage(document, page, System.getProperty("user.dir") + "\\logo.png", textCursor);

        writePageNumber( document, page, pageCounter.toString(), 12);
    }

    private PDPage createTable(PDDocument document, PDPage page, List<ArrayList<String>> data, TextCursor textCursor) throws IOException {

        PDFont font = PDType1Font.TIMES_ROMAN;
        int fontSize = 12;
        float fontHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
        float ty = 0;
        int flag = 0;
        int countRows = 0;
        int k = 0;
        int startVal = 1;
        List<String> firstRow = data.get(0);
        List<Integer> columnLength = new ArrayList<>();
        Row.RowBuilder rowBuilder;
        PDPageContentStream contentStream = null;
        defineColumnsLength(collection, textCursor, columnLength);

        try {

            while (k != data.size()) {

                contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false);

                // Define the table structure
                Table.TableBuilder tableBuilder = new Table.TableBuilder();

                tableBuilder.setFontSize(fontSize).setFont(font);

                for (int j = 0; j < columnLength.size(); j++)
                    tableBuilder.addColumnOfWidth(columnLength.get(j));

                //firstRow
                rowBuilder = new Row.RowBuilder();
                rowBuilder.add(Cell.withText('N')
                        .setHorizontalAlignment(LEFT)
                        .withHorizontalBorders());
                for (int i = 0; i < firstRow.size(); i++) {
                    rowBuilder.add(Cell.withText(firstRow.get(i))
                            .setHorizontalAlignment(LEFT)
                            .withHorizontalBorders());
                }
                countRows++;
                tableBuilder.addRow(rowBuilder.setBackgroundColor(new Color(215, 238, 245)).build());

                for (k = startVal; k < data.size(); k++) {
                    countRows++;
                    if ((textCursor.getCurentY() - (fontHeight + 7) * countRows) < 60) {
                        startVal = k;
                        countRows = 0;
                        flag = 1;
                        break;
                    }
                    rowBuilder = new Row.RowBuilder();

                    rowBuilder.add(Cell.withText(k)
                            .setHorizontalAlignment(LEFT)
                            .withHorizontalBorders());

                    for (int i = 0; i < data.get(k).size(); i++) {
                        rowBuilder.add(Cell.withText(data.get(k).get(i))
                                .setHorizontalAlignment(LEFT)
                                .withHorizontalBorders());
                    }
                    tableBuilder.addRow(rowBuilder.setBackgroundColor((countRows-1) % 2 == 0 ? new Color(215, 238, 245) : Color.WHITE).build());
                }
                if (flag == 1) {
                    ty = (new TableDrawer(contentStream, tableBuilder.build(), textCursor.getCurentX(), textCursor.getCurentY())).draw();
                    flag = 0;
                    page = addNewPage(document, collection);
                    textCursor.setCurentY(textCursor.getStartY() - textCursor.getMarginY());
                    showReportName(textCursor, page, document);
                    showAdditionalText(textCursor, page, document);
                    contentStream.close();
                }
                else
                    ty = (new TableDrawer(contentStream, tableBuilder.build(), textCursor.getCurentX(), textCursor.getCurentY())).draw();
            }
            textCursor.setCurentY(ty - 20);
        } finally {
            //Closing the content stream
            if (contentStream != null)
                contentStream.close();
        }
        return page;
    }

    private void defineColumnsLength (Collection collection, TextCursor textCursor, List<Integer> columnLength) {

        List<String> firstRow = collection.outer.get(0);

        // column's size
        int length;
        int cnt = 0;
        int k = 0;
        int width = (int)textCursor.getWidth() ;

        int size = firstRow.size();

        for (String header: firstRow) {
            if (header.contains("Date"))
                cnt++;
            if (header.contains("Email"))
                k++;
        }

        width = width - cnt * 80 - 200 * k - 30/*for №*/;
        size = size - cnt - k;
        length = width / size;

        columnLength.add(30);
        for (String header: firstRow) {
            if (header.contains("Email"))
                columnLength.add(200);
            else if (header.contains("Date"))
                columnLength.add(80);
            else
                columnLength.add(length);
        }
    }

    private void writePageNumber(PDDocument document, PDPage page, String text, int fontSize) throws IOException {

        PDFont font = PDType1Font.TIMES_ROMAN;

        float length = ( font.getStringWidth(text) / 1000f) * fontSize;

        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false);

        contentStream.beginText();

        contentStream.setFont(font, fontSize);

        contentStream.newLineAtOffset((page.getMediaBox().getUpperRightX() - length) / 2  , page.getMediaBox().getLowerLeftY() + 40);

        contentStream.showText(text);

        contentStream.endText();

        contentStream.close() ;
    }

    private PDPage writeText(PDDocument document, PDPage page, String text, int fontSize, TextCursor textCursor) throws IOException {

        float leading = 1.5f * fontSize;
        PDFont font = PDType1Font.TIMES_ROMAN;
        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false);
        TextCursor.Align align = textCursor.getAlignment();
        int i = 0;

        // Split original text to short strings
        List<String> lines = splitToStrings(text, fontSize, font, textCursor.getWidth());

        try {
            // starting content stream
            contentStream.beginText();

            contentStream.newLineAtOffset(textCursor.getCurentX(),textCursor.getCurentY());

            //Writing text in the form of string
            for (String line : lines) {

                if ((textCursor.getCurentY()) < 50) {
                    contentStream.endText();
                    contentStream.close();
                    page = addNewPage(document, collection);
                    textCursor.setCurentY(textCursor.getStartY() - textCursor.getMarginY());
                    showReportName(textCursor, page, document);
                    showAdditionalText(textCursor, page, document);
                    contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false);
                    // starting content stream
                    contentStream.beginText();
                    contentStream.newLineAtOffset(textCursor.getCurentX(),textCursor.getCurentY());
                    i = 0;
                }

                // setting font parameters: type and size
                contentStream.setFont(font, fontSize);
                if ( i == 0) {
                    textCursor.setAlignment(align);
                    setAlignmnet(textCursor, line, font, fontSize);
                    i++;
                }
                contentStream.newLineAtOffset(textCursor.getCurentX(),0);
                contentStream.showText(line);
                contentStream.newLineAtOffset(-textCursor.getCurentX(), -leading);
                textCursor.setCurentY(textCursor.getCurentY() - leading);
            }
            textCursor.setCursorToLeft();
            contentStream.newLineAtOffset(-textCursor.getCurentX(), 0);
            // end content stream
            contentStream.endText();
        } finally {
            //Closing the content stream
            if (contentStream != null)
                contentStream.close() ;
        }
        return page;
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
                if (size > width) {
                    if (lastSpace < 0)
                        lastSpace = spaceIndex;
                    subString = text.substring(0, lastSpace);
                    lines.add(subString);
                    text = text.substring(lastSpace).trim();
                    //System.out.printf("'%s' is line\n", subString);
                    lastSpace = -1;
                }
                else if (spaceIndex == text.length()) {
                    lines.add(text);
                    //System.out.printf("'%s' is line\n", text);
                    text = "";
                }
                else {
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
            contentStream.drawImage(pdImage, page.getMediaBox().getUpperRightX() - 110 , page.getMediaBox().getUpperRightY() - 40);
        } finally {
            //Closing the content stream
            if (contentStream != null)
                contentStream.close() ;
        }

    }
}
