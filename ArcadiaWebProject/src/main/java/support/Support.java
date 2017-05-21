package support;

import firebase_communication.Collection;
import pdf_creator.PdfCreator;
import xml_creator.XmlCreator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Георгий on 21.04.2017.
 */
public class Support implements Constants{

    /* Creates a file of the specified extension */
    public void createReportFile(HttpServletResponse response, String file_name, String type_report,
                                 Collection collection, String object)  throws ServletException, IOException {

        String extension, typeFile;

        // Type PDF
        if (type_report != null) {
            PdfCreator pdfCreator = new PdfCreator(file_name, collection);
            pdfCreator.createPDF();
            typeFile = "Application/x-pdf";
            extension = ".pdf";

        // Type XML
        } else {
            XmlCreator tempCreator = new XmlCreator(file_name, collection, object);
            typeFile = "Application/xml";
            extension = ".xml";
        }

        addFileToResponse( response, file_name + extension, typeFile);
    }


    private void addFileToResponse(HttpServletResponse response,
                                   String fileName, String typeFile) throws ServletException, IOException {

        File my_file = new File(ABSOLUTE_PATH + fileName);

        // Make sure to show the download dialog
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        response.setHeader("Content-Type", typeFile + ";charset=UTF-8");
        response.setHeader("Content-Length", String.valueOf(my_file.length()));

        Path p = Paths.get(ABSOLUTE_PATH + fileName);
        response.getOutputStream().write(Files.readAllBytes(p));
        my_file.delete();
    }


    /* Convert a data format ( from yyyy-mm-dd to ms) */
    public static final Long getLongTime(String string_date) {
        long milliseconds = 0L;

        SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date d = f.parse(string_date);
            milliseconds = d.getTime();
        } catch (ParseException e) {
            return 0L;
        }
        return (milliseconds);
    }
}
