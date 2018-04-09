package StaticModels;

/**
 * Created by User on 10.10.2017.
 */
public final class Param extends StructureOfTable {
    private static Param instance = new Param();

    private Param() {
        nameOfTable = "Param";
        textOfLabels = new String[]{"Param: ", "The value: "};
        textOfColumns = new String[]{"Name", "Value"};
    }

    public static Param get() {
        return instance;
    }
}