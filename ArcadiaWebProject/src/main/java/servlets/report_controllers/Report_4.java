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


@WebServlet("/report_4")
public class Report_4 extends HttpServlet implements Constants{

    private Support support = new Support();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type_report = request.getParameter("report4_switch_pdf_or_xml");
        String date4_1 = request.getParameter("report4_date_begin");
        String date4_2 = request.getParameter("report4_date_end");

        long date_4_1 = support.getLongTime(date4_1);
        long date_4_2 = support.getLongTime(date4_2);

        DBConnector.init();
        Collection collection = new Collection();
        DBConnector connector = new DBConnector();
        connector.getGroupsRating(collection);

        synchronized (collection) {
            try {
                collection.wait();
            } catch (InterruptedException e) {
            }
        }
        String file_name = "GroupsRatingBetweenDates_" + date4_1 + "_" + date4_2 + "_onDate_" + System.currentTimeMillis();

        support.createReportFile(response, file_name, type_report, collection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}