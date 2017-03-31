package support.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import support.User;
import support.pdf.tableCreator.easytable.*;

import java.awt.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import static support.pdf.tableCreator.easytable.Cell.HorizontalAlignment.CENTER;
import static support.pdf.tableCreator.easytable.Cell.HorizontalAlignment.RIGHT;


public class PdfCreator {

    private  final  String  FILE_data;
    private String date1, date2;
    private Data data;

    public PdfCreator(String file_name, Data data, Timestamp date1, Timestamp date2){

        // output file name
        FILE_data = file_name + ".pdf";
        this.date1 = new SimpleDateFormat("MM.dd.yyyy").format(date1);
        this.date2 = new SimpleDateFormat("MM.dd.yyyy").format(date2);
        this.data = data;
    }

    public void createPDF_1() throws IOException {

        // creating empty pdf document
        PDDocument document = new PDDocument() ;

        // creating empty page and adding it to the document
        PDPage page = new PDPage() ;
        document.addPage(page);

        // preparing content stream
        PDPageContentStream contentStream = new PDPageContentStream(document, page) ;

        // writing header of report
        String header = "Users registered from " + date1 + " to " + date2;
        writeText(contentStream, header, 150, 750, 16);

        createTable(contentStream, page, data, 50 , 700, 14);

        String message = data.getUsers().size() + " users have registered for the specified period";
        writeText(contentStream, message, 65, 450, 14);

        //Closing the content stream
        contentStream.close() ;

        // saving the document
      //  document.save("src\\main\\java\\support\\pdf\\reports\\" + FILE_data) ;
        document.save("D:/" + FILE_data) ;

        //Closing the document
        document.close() ;
    }

    private void createTable(PDPageContentStream contentStream, PDPage page, Data data, int width, int height, int fontSize ) throws IOException {

        PDFont font = PDType1Font.TIMES_ROMAN;

        Map<String, String> dataForTable = data.getUsers();

        // Define the table structure first
        Table.TableBuilder tableBuilder = new Table.TableBuilder()
                .addColumnOfWidth(30)
                .addColumnOfWidth(300)
                .addColumnOfWidth(150)
                .setFontSize(fontSize)
                .setFont(font);

        // Header
        tableBuilder.addRow(new Row.RowBuilder()
                .add(Cell.withText("#")
                        .setHorizontalAlignment(CENTER)
                        .withAllBorders())
                .add(Cell.withText("User's name")
                        .setHorizontalAlignment(CENTER)
                        .withAllBorders())
                .add(Cell.withText("Date of registrarion")
                        .setHorizontalAlignment(CENTER)
                        .withAllBorders())
                .setBackgroundColor(Color.GREEN)
                .build());

        // adding 10 rows
        int i = 1;
        for ( Map.Entry entry : dataForTable.entrySet()) {
            tableBuilder.addRow(new Row.RowBuilder()
                    .add(Cell.withText(i++)
                            .withAllBorders()
                            .setHorizontalAlignment(CENTER))
                    .add(Cell.withText(entry.getKey())
                            .withAllBorders()
                            .setHorizontalAlignment(CENTER))
                    .add(Cell.withText(entry.getValue())
                            .withAllBorders()
                            .setHorizontalAlignment(CENTER))
                    .setBackgroundColor(i % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE)
                    .build());
        }

        // Define the starting point
        final float startY = page.getMediaBox().getHeight() - 50;
        final int startX = 65;

        // Draw!
        (new TableDrawer(contentStream, tableBuilder.build(), startX, startY)).draw();
    }

    private void writeText(PDPageContentStream contentStream, String s, int width, int height, int fontSize) throws IOException {

        PDFont font = PDType1Font.TIMES_ROMAN;

        // starting content stream
        contentStream.beginText();

       //Setting the position for the line
        contentStream.newLineAtOffset(width, height);

        // setting font parameters: type and size
        contentStream.setFont(font, fontSize);

        //Adding text in the form of string
        contentStream.showText(s);

        //contentStream.newLine();

        // end content stream
        contentStream.endText();

    }

    private void insertImage() {

    }

    public static void main(String[] args) throws IOException {

        Data data = new Data();

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 01);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.YEAR, 2004);
        Timestamp tstamp1 = new Timestamp(cal.getTimeInMillis());

        cal.set(Calendar.DAY_OF_MONTH, 01);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.YEAR, 2017);
        Timestamp tstamp2 = new Timestamp(cal.getTimeInMillis());

        PdfCreator pdfReport = new PdfCreator("Test1", data,tstamp1, tstamp2);

        pdfReport.createPDF_1();
    }
}
