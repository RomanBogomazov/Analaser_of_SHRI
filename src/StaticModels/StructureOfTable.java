package StaticModels;

/**
 * Created by User on 10.10.2017.
 */
public abstract class StructureOfTable {
    protected String nameOfTable;
    protected String[] textOfLabels;
    protected String[] textOfColumns;
    protected String[] values;

    public String getNameOfTable(){
        return nameOfTable;
    }

    public String[] getTextOfLabels(){
        return textOfLabels;
    }

    public String[] getTextOfColumns(){
        return textOfColumns;
    }

    public String[] getValues(){
        return values;
    }

    public void setValues(String[] values){
        this.values = values;
    }
}