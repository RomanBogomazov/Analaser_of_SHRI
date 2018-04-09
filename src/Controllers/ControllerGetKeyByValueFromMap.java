package Controllers;

import java.util.Collection;
import java.util.Map;

/**
 * Created by User on 11.10.2017.
 */
public class ControllerGetKeyByValueFromMap {
    private static ControllerGetKeyByValueFromMap instance = new ControllerGetKeyByValueFromMap();

    public static ControllerGetKeyByValueFromMap get(){
        return instance;
    }

    public String getKey(Map<String, String> map, String value){
        Collection<String> collection = map.values();
        int i=0;
        for (String element : collection){
            if (element.equals(value)){
                break;
            }
            i++;
        }
        if (i<=map.keySet().size()-1) {
            return String.valueOf(map.keySet().toArray()[i]);
        } else {
            return null;
        }
    }
}