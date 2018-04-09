package StaticModels;

/**
 * Created by User on 10.10.2017.
 */
public final class System extends StructureOfTable {
    private static System instance = new System();

    private System() {
        nameOfTable = "System";
        textOfLabels = new String[]{"System name: "};
        textOfColumns = new String[]{"System name"};
    }

    public static System get() {
        return instance;
    }
}