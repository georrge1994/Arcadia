package servlets;

import support.Collection;
import support.Constants;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@WebServlet("/controller")
public class Controller extends HttpServlet implements Constants{

    private Long getLongTime(String string_date)
    {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String file_name = "tempCreator";

        DBConnector.init();
        Collection collection = new Collection();
        DBConnector connector = new DBConnector();

        String index_report_str = request.getParameter("index_report");
        System.out.println(index_report_str);
        int index_report = Integer.parseInt(index_report_str);
        String type_report = request.getParameter("report1_switch_pdf_or_xml");
        System.out.println(type_report);
        switch(index_report){
            // REPORT TYPE 1
            case(1):
                String date1 = request.getParameter("report1_date_begin");
                String date2 = request.getParameter("report1_date_end");

                long date_1 = getLongTime(date1);
                long date_2 = getLongTime(date2);

                connector.getSignedUsersBetweenDates(collection, date_1, date_2);

                synchronized (collection)
                {
                    try {
                        collection.wait();
                    }
                    catch (InterruptedException e) {
                    }
                }

                if(type_report != null) {// pdf

                    // TODO: where my pdf???

                }else{                        // xml
                    String object = "student";
                    int users_num = collection.outer.size()-1;
                    String summary = "Number of registered students from " + date_1 + " to " + date_2 + ": " +
                            users_num + " people";

                    XmlCreator tempCreator = new XmlCreator(file_name, collection, object, summary);
                }
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

        if(type_report != null) {// pdf
            // add file ti response
            String fileName = "Test1.pdf";
            String typeFile = "Application/x-pdf"; //Application/x-pdf, text/plain, text/html, image/jpg
            addFileToResponce(request, response, fileName, typeFile);
        }else{  // xml
            // add file ti response
            String fileName = file_name;
            String typeFile = "Application/xml"; //Application/x-pdf, text/plain, text/html, image/jpg
            addFileToResponce(request, response, fileName+".xml", typeFile);
        }
    }

    private void addFileToResponce(HttpServletRequest request, HttpServletResponse response,
                                   String fileName, String typeFile) throws ServletException, IOException {

        File my_file = new File(PATH + fileName);
        // Make sure to show the download dialog
        response.setHeader("Content-disposition","attachment; filename=" + fileName );
        response.setHeader("Content-Type",typeFile + ";charset=UTF-8");
        response.setHeader("Content-Length", String.valueOf(my_file.length()));

        Path p = Paths.get(PATH + fileName);
        response.getOutputStream().write(Files.readAllBytes(p));
    }
}