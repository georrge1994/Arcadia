package servlets;

import com.google.firebase.database.*;
import support.DBConnector;
import support.Group;
import support.User;
import support.XmlCreator;
import support.pdf.Data;
import support.pdf.PdfCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

import support.*;
import support.pdf.Data;
import support.pdf.PdfCreator;
import support.User;
>>>>>>> edf83eef2a2241235b24f77fbb7d87ac17593b90
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

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
<<<<<<< HEAD
=======
                System.out.println("date1 " + date1 + " date2 " + date2);
>>>>>>> edf83eef2a2241235b24f77fbb7d87ac17593b90
                final Vector<User> users = new Vector<User>();
                DBConnector.init();
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("/");
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        users.clear();

                        for (DataSnapshot userSnapshot: dataSnapshot.child("users").getChildren())
                        {
                            users.add(new User(userSnapshot.getKey(), (String) userSnapshot.child("email").getValue(),(String) userSnapshot.child("name").getValue(),(String) userSnapshot.child("role").getValue()

                            ));
                        }
                        XmlCreator tempCreator = new XmlCreator("tempCreator", users, "1489795200", "1589795200");

                    }

                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });
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
