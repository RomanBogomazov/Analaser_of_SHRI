package StaticModels;

import java.sql.Time;
import java.sql.Date;

/**
 * Created by User on 10.10.2017.
 */
public final class Session extends StructureOfTable {
    private static Session instance = new Session();
    private int researcherKey;
    private int sampleKey;
    private int systemKey;
    private int paramsKey;
    private Date date;
    private Time time;

    public static Session get() {
        return instance;
    }
}