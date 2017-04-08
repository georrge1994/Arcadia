package servlets;

import support.Collection;
import support.DBConnector;
import support.XmlCreator;
import support.pdf.Data;
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
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index_report = 1;
        String type_report = request.getParameter("type_report");
        switch(index_report){
            case(1):
                System.out.println("XML");
                String date1 = request.getParameter("date1");
                String date2 = request.getParameter("date2");
                System.out.println("date1 " + date1 + " date2 " + date2);

                DBConnector.init();
                Collection collection = new Collection();
                DBConnector connector = new DBConnector();

                //-------- для 1 отчета---------------------------------------------------------------------------------

                long date_1 = 0L;
                long date_2 = 1589795200L;
                connector.getSignedUsersBetweenDates(collection, date_1, date_2);

                synchronized (collection)
                {
                    try {
                        collection.wait();
                    }
                    catch (InterruptedException e) {
                    }
                }

                String object = "student";
                int users_num = collection.outer.size()-1;
                String summary = "Number of registered students from " + date_1 + " to " + date_2 + ": " +
                                    users_num + " people";

                //------------------------------------------------------------------------------------------------------

                //-------- для 2 отчета---------------------------------------------------------------------------------
                /*
                long date_1 = 0L;
                long date_2 = 1589795200L;
                connector.getCoursesBetweenDates(collection, date_1, date_2);

                synchronized (collection)
                {
                    try {
                        collection.wait();
                    }
                    catch (InterruptedException e) {
                    }
                }

                String object = "student";
                int students_num = collection.outer.size()-1;
                String summary = "Number of registered students for the course from " + date_1 + " to " +
                                    date_2 + ": " + students_num;
                */
                //------------------------------------------------------------------------------------------------------

                //-------- для 3 отчета---------------------------------------------------------------------------------
                /*
                String type = "hi";
                int nums = 15;
                connector.getUsersRating(collection, type , nums);

                synchronized (collection)
                {
                    try {
                        collection.wait();
                    }
                    catch (InterruptedException e) {
                    }
                }

                String object = "course";
                String summary = ""; //???????????????????????????????
                */
                //------------------------------------------------------------------------------------------------------
                XmlCreator tempCreator = new XmlCreator("tempCreator", collection, date1, date2, object, summary);
                break;
            case(2):

                System.out.println("PDF");
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
                break;
            case(3):

                break;
            case(4):

                break;
            case(5):

                break;
            case(6):

                break;
            case(7):

                break;
        }
        if(type_report.equals("PDF")) {
            // add file ti response
            String fileName = "Test1.pdf";
            String typeFile = "Application/x-pdf"; //Application/x-pdf, text/plain, text/html, image/jpg
            addFileToResponce(request, response, fileName, typeFile);
        }else{
            // add file ti response
            String fileName = "tempCreator.xml";
            String typeFile = "Application/xml"; //Application/x-pdf, text/plain, text/html, image/jpg
            addFileToResponce(request, response, fileName, typeFile);
        }
    }

    private void addFileToResponce(HttpServletRequest request, HttpServletResponse response,
                                   String fileName, String typeFile) throws ServletException, IOException {

        File my_file = new File("D:\\" + fileName);
        // Make sure to show the download dialog
        response.setHeader("Content-disposition","attachment; filename=" + fileName);
        response.setHeader("Content-Type",typeFile + ";charset=UTF-8");
        response.setHeader("Content-Length", String.valueOf(my_file.length()));

        Path p = Paths.get("D:\\" + fileName);
        response.getOutputStream().write(Files.readAllBytes(p));
    }
}