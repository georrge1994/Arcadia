package servlets;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Vector;

import support.*;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    Vector<User> users = new  Vector<User>();
    Vector<Group> groups = new  Vector<Group>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int index_report = Integer.parseInt(request.getParameter("type_report"));
        switch(index_report){
            case(1):
                String date1 = request.getParameter("date1");
                String date2 = request.getParameter("date2");

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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /*   DBConnector.init();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("/");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot userSnapshot: dataSnapshot.child("users").getChildren())
                {
                    users.add(new User(userSnapshot.getKey(), (String) userSnapshot.child("email").getValue(),(String) userSnapshot.child("name").getValue(),(String) userSnapshot.child("role").getValue()

                    ));
                }
                for (DataSnapshot groupSnapshot: dataSnapshot.child("groups").getChildren()) {
                    Group newGroup = new Group(
                            groupSnapshot.getKey(),
                            (String) groupSnapshot.child("name").getValue(),
                            (String) groupSnapshot.child("role").getValue());
                    for (DataSnapshot userSnapshot: groupSnapshot.child("users").getChildren()) {
                        newGroup.addUser(userSnapshot.getKey());

                    }
                    groups.add(newGroup);
                }
                for (DataSnapshot groupSnapshot: dataSnapshot.child("groupCourses").getChildren()) {
                    for (Group g: groups)
                    {

                        if (g.getSystemName().equals(groupSnapshot.getKey()))
                        {
                            for (DataSnapshot courseSnapshot: groupSnapshot.child("courses").getChildren()) {

                                Long x = (Long)courseSnapshot.child("dateEnd").getValue();
                                Course course = new Course(
                                        (Long) courseSnapshot.child("dateEnd").getValue(),
                                        (Long) courseSnapshot.child("dateStart").getValue(),
                                        (String) courseSnapshot.child("name").getValue(),
                                        (Long) courseSnapshot.child("progress").getValue(),
                                        (Long) courseSnapshot.child("rating").getValue(),
                                        (String) courseSnapshot.child("status").getValue());
                                for (DataSnapshot testsSnapshot: courseSnapshot.child("tests").getChildren())
                                {
                                    course.addTest(new Test(
                                            (Long) testsSnapshot.child("questionsCount").getValue(),
                                            (Long) testsSnapshot.child("dateEnd").getValue(),
                                            (Long) testsSnapshot.child("dateStart").getValue(),
                                            (String) testsSnapshot.child("name").getValue(),
                                            (String) testsSnapshot.child("difficulty").getValue(),
                                            (String) testsSnapshot.child("status").getValue()
                                    ));
                                }
                                g.addCourse(course);
                            }
                            break;
                        }
                    }
                }
                //+

            }

            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });*/
    }
}
