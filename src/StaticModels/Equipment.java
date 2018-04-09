package StaticModels;

/**
 * Created by User on 10.10.2017.
 */
public final class Equipment extends StructureOfTable {
    private static Equipment instance = new Equipment();

    private Equipment() {
        nameOfTable = "Equipment";
        textOfLabels = new String[]{"Equipment: ", "Description: "};
        textOfColumns = new String[]{"Equipment", "Description"};
    }

    public static Equipment get() {
        return instance;
    }
}