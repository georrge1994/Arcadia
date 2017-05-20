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
        String group = request.getParameter("report3_select_rating");
        String count = request.getParameter("report3_number");

        switch (group){
            case "top rated": group = "hi";
            break;
            case "low rated": group = "low";
            break;
            default: group = "hi";
        }
        int rate;

        try
        {   rate = Integer.parseInt(count); }
        catch (NumberFormatException e)
        {
            rate = 0;
        }

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

        String file_name = "UsersRating_onDate_" + System.currentTimeMillis();
        String object = "student";
        support.createReportFile(response, file_name, type_report, collection, object);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}