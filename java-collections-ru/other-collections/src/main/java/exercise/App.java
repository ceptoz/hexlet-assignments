package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Map<String, String> resultMap = new LinkedHashMap<>();

        Set<String> keys = Stream.concat(firstMap.keySet().stream(), secondMap.keySet().stream())
                .collect(Collectors.toCollection(TreeSet::new));

        for (String key : keys) {
            if ((firstMap.containsKey(key) && secondMap.containsKey(key)) && firstMap.get(key).equals(secondMap.get(key))) {
                resultMap.put(key, "unchanged");
            }
            if ((firstMap.containsKey(key) && secondMap.containsKey(key)) && !firstMap.get(key).equals(secondMap.get(key))) {
                resultMap.put(key, "changed");
            }
            if ((firstMap.containsKey(key) && !secondMap.containsKey(key))) {
                resultMap.put(key, "deleted");
            }
            if ((!firstMap.containsKey(key) && secondMap.containsKey(key))) {
                resultMap.put(key, "added");
            }
        }
        for(Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println(entry);
        }
        return resultMap;
    }
}
//END
