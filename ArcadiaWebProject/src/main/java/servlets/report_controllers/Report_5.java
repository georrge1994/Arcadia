package servlets.report_controllers;

import firebase_communication.Collection;
import firebase_communication.DBConnector;
import support.Constants;
import support.Support;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/report_5")
public class Report_5 extends HttpServlet implements Constants{

    private Support support = new Support();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type_report = request.getParameter("report5_switch_pdf_or_xml");


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
        String file_name = "Courses_onDate_" + System.currentTimeMillis();
        String object = "course";
        support.createReportFile(response, file_name, type_report, collection, object);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}