package servlets.report_controllers;

import firebase_communication.Collection;
import support.Constants;
import firebase_communication.DBConnector;
import support.Support;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static support.Support.getLongTime;


@WebServlet("/report_5")
public class Report_5 extends HttpServlet implements Constants{

    private Support support = new Support();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type_report = request.getParameter("report5_switch_pdf_or_xml");
        String date5_1 = request.getParameter("report5_date_begin");
        String date5_2 = request.getParameter("report5_date_end");

        long date_5_1 = getLongTime(date5_1);
        long date_5_2 = getLongTime(date5_2);

        DBConnector.init();
        Collection collection = new Collection();
        DBConnector connector = new DBConnector();
        connector.getCourses(collection);

        synchronized (collection) {
            try {
                collection.wait();
            } catch (InterruptedException e) {
            }
        }
        String file_name = "CoursesBetweenDates_" + date5_1 + "_" + date5_2 + "_onDate_" + System.currentTimeMillis();

        support.createReportFile(response, file_name, type_report, collection);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}