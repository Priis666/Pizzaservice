package sample;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Robin on 28.06.2016.
 */
public class Util {
    /** prevents instantiation
     **/
    private Util(){

    }

    public static List<Pair<String, Integer>> getPairs(Map<String, Integer> map) {
        List<Pair<String, Integer>> pairs = new ArrayList<>();
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry entry : set) {
            pairs.add(new Pair<>((String) entry.getKey(), (Integer) entry.getValue()));
        }
        return pairs;
    }

    public static String buildAppropriateString(Pair<String, Integer> pair){
        Integer val = pair.getValue();
        StringBuilder builder = new StringBuilder();
        return builder.append("Pizza ")
                .append(pair.getKey()).append(", ")
                .append("Anzahl: ").append(String.valueOf(val)).append(", ")
                .append("Preis: ")
                .append(String.valueOf(val * 6.0)).toString();

    }
}
