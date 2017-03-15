package support;

/**
 * Created by Sublimee on 15.03.2017.
 */
public class Test {


    Long questionsCount = 0L;
    Long dateEnd        = 0L;
    Long dateStart      = 0L;
    String name         = "";
    String difficulty   = "";
    String status       = "";

    public Test(Long questionsCount, long dateEnd, long dateStart, String name, String difficulty, String status) {
        this.questionsCount = questionsCount;
        this.dateEnd = dateEnd;
        this.dateStart = dateStart;
        this.name = name;
        this.difficulty = difficulty;
        this.status = status;
    }
}
