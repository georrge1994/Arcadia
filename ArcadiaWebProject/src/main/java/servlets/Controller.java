package servlets;

import support.Collection;
import support.Constants;
import support.DBConnector;
import support.XmlCreator;
import support.pdf.PdfCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/controller")
public class Controller extends HttpServlet implements Constants {

    private Long getLongTime(String string_date) {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String absolutePath = System.getProperty("user.dir") + "\\";
        String file_name = "";
        DBConnector.init();
        Collection collection = new Collection();
        DBConnector connector = new DBConnector();

        String index_report_str = request.getParameter("index_report");
        //System.out.println(index_report_str);
        int index_report = Integer.parseInt(index_report_str);
        //String type_report = request.getParameter("report1_switch_pdf_or_xml");
        String type_report = null;
        //System.out.println(type_report);
        switch (index_report) {
            // REPORT TYPE 1
            case (1):

                type_report = request.getParameter("report1_switch_pdf_or_xml");

                String date1 = request.getParameter("report1_date_begin");
                String date2 = request.getParameter("report1_date_end");

                long date_1 = getLongTime(date1);
                long date_2 = getLongTime(date2);

                connector.getSignedUsersBetweenDates(collection, date_1, date_2);

                synchronized (collection) {
                    try {
                        collection.wait();
                    } catch (InterruptedException e) {
                    }
                }
                file_name = "SignedUsersBetweenDates_" + date1 + "_" + date2 + "_onDate_" + System.currentTimeMillis();

                if (type_report != null) {// pdf

                    PdfCreator pdfCreator = new PdfCreator(file_name, collection, 1);
                    pdfCreator.createPDF();

                } else {                  // xml
                    XmlCreator tempCreator = new XmlCreator(file_name, collection, 1);
                }
                break;
            case (2):

                type_report = request.getParameter("report2_switch_pdf_or_xml");

                String date2_1 = request.getParameter("report2_date_begin");
                String date2_2 = request.getParameter("report2_date_end");

                long date_2_1 = getLongTime(date2_1);
                long date_2_2 = getLongTime(date2_2);

                connector.getCoursesBetweenDates(collection, date_2_1, date_2_2);

                synchronized (collection) {
                    try {
                        collection.wait();
                    } catch (InterruptedException e) {
                    }
                }
                file_name = "CoursesBetweenDates_" + date2_1 + "_" + date2_2 + "_onDate_" + System.currentTimeMillis();

                if (type_report != null) {// pdf

                    PdfCreator pdfCreator = new PdfCreator(file_name, collection, 2);
                    pdfCreator.createPDF();

                } else {                  // xml
                    XmlCreator tempCreator = new XmlCreator(file_name, collection, 2);
                }

                break;
            case (3):
                type_report = request.getParameter("report3_switch_pdf_or_xml");

                String date3_1 = request.getParameter("report3_date_begin");
                String date3_2 = request.getParameter("report3_date_end");

                long date_3_1 = getLongTime(date3_1);
                long date_3_2 = getLongTime(date3_2);

                String type = "hi";
                connector.getUsersRating(collection, type, 15);

                synchronized (collection) {
                    try {
                        collection.wait();
                    } catch (InterruptedException e) {
                    }
                }
                file_name = "UsersRating_" + date3_1 + "_" + date3_2 + "_onDate_" + System.currentTimeMillis();

                if (type_report != null) {// pdf

                    PdfCreator pdfCreator = new PdfCreator(file_name, collection, 3);
                    pdfCreator.createPDF();

                } else {                  // xml
                    XmlCreator tempCreator = new XmlCreator(file_name, collection, 3);
                }

                break;
            case (4):
                type_report = request.getParameter("report4_switch_pdf_or_xml");

                String date4_1 = request.getParameter("report4_date_begin");
                String date4_2 = request.getParameter("report4_date_end");

                long date_4_1 = getLongTime(date4_1);
                long date_4_2 = getLongTime(date4_2);

                connector.getGroupsRating(collection);

                synchronized (collection) {
                    try {
                        collection.wait();
                    } catch (InterruptedException e) {
                    }
                }
                file_name = "GroupsRating" + date4_1 + "_" + date4_2 + "_onDate_" + System.currentTimeMillis();

                if (type_report != null) {// pdf

                    PdfCreator pdfCreator = new PdfCreator(file_name, collection, 4);
                    pdfCreator.createPDF();

                } else {                  // xml
                    XmlCreator tempCreator = new XmlCreator(file_name, collection, 4);
                }
                break;
            case (5):

                type_report = request.getParameter("report5_switch_pdf_or_xml");
                //String date5_1 = request.getParameter("report5_date_begin");
                //String date5_2 = request.getParameter("report5_date_end");

                //tmp
                String date5_1 = "report5_date_begin";
                String date5_2 = "report5_date_end";

                //long date_5_1 = getLongTime(date5_1);
                //long date_5_2 = getLongTime(date5_2);

                connector.getCourses(collection);

                synchronized (collection) {
                    try {
                        collection.wait();
                    } catch (InterruptedException e) {
                    }
                }
                file_name = "Courses" + date5_1 + "_" + date5_2 + "_onDate_" + System.currentTimeMillis();

                if (type_report != null) {// pdf

                    PdfCreator pdfCreator = new PdfCreator(file_name, collection, 5);
                    pdfCreator.createPDF();

                } else {                  // xml
                    XmlCreator tempCreator = new XmlCreator(file_name, collection, 5);
                }
                break;
            case (6):

                break;
            case (7):

                break;
        }

        sendResponse(request, response, absolutePath, file_name, type_report);

    }

    private void sendResponse(
            HttpServletRequest request,
            HttpServletResponse response,
            String absolutePath,
            String file_name,
            String type_report) throws ServletException, IOException {
        String extension;
        String typeFile;
        if (type_report != null) {  // pdf
            typeFile = "Application/x-pdf"; //Application/x-pdf, text/plain, text/html, image/jpg
            extension = ".pdf";
        } else {                    // xml
            typeFile = "Application/xml"; //Application/x-pdf, text/plain, text/html, image/jpg
            extension = ".xml";
        }
        addFileToResponse(request, response, absolutePath, file_name + extension, typeFile);
    }

    private void addFileToResponse(HttpServletRequest request, HttpServletResponse response, String absolutePath,
                                   String fileName, String typeFile) throws ServletException, IOException {

        File my_file = new File(absolutePath + fileName);
        // Make sure to show the download dialog
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        response.setHeader("Content-Type", typeFile + ";charset=UTF-8");
        response.setHeader("Content-Length", String.valueOf(my_file.length()));

        Path p = Paths.get(absolutePath + fileName);
        response.getOutputStream().write(Files.readAllBytes(p));
    }
}