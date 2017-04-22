package servlets.report_controllers;

import firebase_communication.Collection;
import firebase_communication.DBConnector;
import support.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/report_2")
public class Report_2 extends HttpServlet implements Constants{

    private Support support = new Support();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type_report = request.getParameter("report2_switch_pdf_or_xml");
        String date2_1 = request.getParameter("report2_date_begin");
        String date2_2 = request.getParameter("report2_date_end");

        long date_2_1 = support.getLongTime(date2_1);
        long date_2_2 = support.getLongTime(date2_2);

        DBConnector.init();
        Collection collection = new Collection();
        DBConnector connector = new DBConnector();
        connector.getCoursesBetweenDates(collection, 0, 1000000000);
        //connector.getCoursesBetweenDates(collection, date_2_1, date_2_2);

        synchronized (collection) {
            try {
                collection.wait();
            } catch (InterruptedException e) {
            }
        }

        String file_name = "CoursesBetweenDates_" + date2_1 + "_" + date2_2 + "_onDate_" + System.currentTimeMillis();

        support.createReportFile(response, file_name, type_report, collection, 2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}