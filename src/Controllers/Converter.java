package Controllers;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by User on 09.10.2017.
 */
public class Converter {
    private static Converter instance;

    private Converter(){}

    public static Converter get() {
        if (instance==null){
            instance = new Converter();
        }

        return instance;
    }

    public String[] convertListOnArray(ArrayList<String> list) {
        String[] array = new String[list.size()];
        for (int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }

        return array;
    }

    public String[] getValuesFromMap(Map<String, String> map) {
        String[] array = new String[map.size()];
        int i=0;
        for(Map.Entry<String, String> element : map.entrySet()){
            array[i] = element.getValue();
            i++;
        }

        return array;
    }
}