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


@WebServlet("/report_3")
public class Report_3 extends HttpServlet implements Constants{

    private Support support = new Support();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type_report = request.getParameter("report3_switch_pdf_or_xml");
        String date3_1 = request.getParameter("report3_date_begin");
        String date3_2 = request.getParameter("report3_date_end");
        String group = "hi";
        int rate = 15;

        long date_3_1 = support.getLongTime(date3_1);
        long date_3_2 = support.getLongTime(date3_2);

        DBConnector.init();
        Collection collection = new Collection();
        DBConnector connector = new DBConnector();
        connector.getUsersRating(collection, group, rate);

        synchronized (collection) {
            try {
                collection.wait();
            } catch (InterruptedException e) {
            }
        }

        String file_name = "UsersRatingBetweenDates_" + date3_1 + "_" + date3_2 + "_onDate_" + System.currentTimeMillis();

        support.createReportFile(response, file_name, type_report, collection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}