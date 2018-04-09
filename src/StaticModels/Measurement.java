package StaticModels;

import Controllers.DAO.SQLDAO;

import java.util.ArrayList;

/**
 * Created by User on 10.10.2017.
 */
public final class Measurement extends StructureOfTable {
    private static Measurement instance = new Measurement();

    private Measurement() {
        nameOfTable = "Measurement";
        textOfLabels = new String[]{"Measurement: ", "Description: "};
        textOfColumns = new String[]{"Measurement", "Description"};
    }

    public static Measurement get() {
        return instance;
    }

    public static SHRI getSHRI() {
        return SHRI.get();
    }


    public static final class SHRI extends StructureOfTable {
        private static SHRI instance = new SHRI();
        private ArrayList<String[]> values = new ArrayList<>();

        private SHRI() {
            nameOfTable = "Result";
            textOfLabels = new String[]{"SHRI: ", "Description: "};
            textOfColumns = new String[]{"SHRI", "Description"};
            setValuesOnStarting();
        }

        private void setValuesOnStarting(){
            int key = Integer.valueOf(String.valueOf(SQLDAO.get().getPrimaryValues(this).keySet().toArray()[0]));
            if (SQLDAO.get().select(this, key)!=null){
                values.add(SQLDAO.get().select(this, key));
            };
        }

        public static SHRI get() {
            return instance;
        }
    }
}