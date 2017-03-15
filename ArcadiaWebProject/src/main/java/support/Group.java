package support;

import java.util.Vector;

/**
 * Created by Sublimee on 15.03.2017.
 */
public class Group {
    Vector<String> users = new Vector<String>();
    Vector<Course> courses = new Vector<Course>();

    public String getSystemName() {
        return this.systemName;
    }

    String systemName = "";
    String name = "";
    String leaderID = "";

    public Group(String systemName, String name, String leaderID)
    {
        this.systemName = systemName;
        this.name       = name;
        this.leaderID   = leaderID;
    }

    public void addUser(String user)
    {
        users.add(user);
    }
    public void addCourse(Course course)
    {
        courses.add(course);
    }



}
