package support;

import java.util.Vector;

/**
 * Created by Sublimee on 15.03.2017.
 */
public class Course {

    Vector<Test> tests = new Vector<Test>();

    Long dateEnd = 0L;
    Long dateStart = 0L;
    String name = "";
    Long progress = 0L;
    Long rating = 0L;
    String status ="";

    public Course(Long dateEnd, Long dateStart, String name, Long progress, Long rating, String status) {
        this.dateEnd = dateEnd;
        this.dateStart = dateStart;
        this.name = name;
        this.progress = progress;
        this.rating = rating;
        this.status = status;
    }

    public void addTest(Test test)
    {
        tests.add(test);
    }

}
