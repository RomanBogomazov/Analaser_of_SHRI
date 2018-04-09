package StaticModels;

/**
 * Created by User on 10.10.2017.
 */
public final class Result extends StructureOfTable {
    private static Result instance = new Result();

    private Result() {
        nameOfTable = "Result";
        textOfLabels = new String[]{"Result: ", "Description: "};
        textOfColumns = new String[]{"SHRI", "Description"};
    }

    public static Result get() {
        return instance;
    }
}