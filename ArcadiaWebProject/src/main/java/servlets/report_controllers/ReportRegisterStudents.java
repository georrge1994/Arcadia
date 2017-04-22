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

/* Servlet for reports "Users" */
@WebServlet("/report_1")
public class ReportRegisterStudents extends HttpServlet implements Constants{

    private Support support = new Support();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type_report = request.getParameter("report1_switch_pdf_or_xml");
        String date1 = request.getParameter("report1_date_begin");
        String date2 = request.getParameter("report1_date_end");

        long date_1 = support.getLongTime(date1);
        long date_2 = support.getLongTime(date2);

        DBConnector.init();
        Collection collection = new Collection();
        DBConnector connector = new DBConnector();
        connector.getSignedUsersBetweenDates(collection, date_1, date_2);

        synchronized (collection) {
            try {

                collection.wait();

            } catch (InterruptedException e) {
                // TODO: add Exception Handling
            }
        }

        String file_name = "SignedUsersBetweenDates_" + date1 + "_" + date2 + "_onDate_" + System.currentTimeMillis();

        support.createReportFile(response, file_name, type_report, collection, 1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}