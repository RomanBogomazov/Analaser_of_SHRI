package StaticModels;

/**
 * Created by User on 10.10.2017.
 */
public final class Feature extends StructureOfTable {
    private static Feature instance = new Feature();

    private Feature() {
        nameOfTable = "Feature";
        textOfLabels = new String[]{"Feature: ", "The value: "};
        textOfColumns = new String[]{"Feature", "The value"};
    }

    public static Feature get() {
        return instance;
    }
}