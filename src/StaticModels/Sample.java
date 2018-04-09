package StaticModels;

/**
 * Created by User on 10.10.2017.
 */
public final class Sample extends StructureOfTable {
    private static Sample instance = new Sample();

    private Sample() {
        nameOfTable = "Sample";
        textOfLabels = new String[]{"Sample: ", "Structure: ", "Description: ", "Created data: "};
        textOfColumns = new String[]{"Sample", "Structure", "Description", "Created data"};
    }



    public static Sample get() {
        return instance;
    }
}