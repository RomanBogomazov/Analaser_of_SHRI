package StaticModels;

/**
 * Created by User on 10.10.2017.
 */
public final class Researcher extends StructureOfTable {
    private static Researcher instance = new Researcher();

    private Researcher() {
        nameOfTable = "Researcher";
        textOfLabels = new String[]{"Surname: ", "Name: ", "Second name: ", "Qualification: ", "Work age: ",
                "Scientist works: ", "Home address: ", "Phone number: ", "E-mail: ", "Job: ",
                "Data born: "};
        textOfColumns = new String[]{"Surname", "Name", "Second name", "Scientist qualification", "Work age",
                "Scientist works", "Home address", "Phone number", "E-mail", "Job",
                "Data born"};
    }

    public static Researcher get() {
        return instance;
    }
}