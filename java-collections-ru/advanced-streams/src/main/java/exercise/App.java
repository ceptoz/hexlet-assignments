package exercise;

import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {
    public static String getForwardedVariables(String config) {
        String beginKey = "environment=";
        String keyWordTemplate = "X_FORWARDED_";
        List<String> textParts = Arrays.stream(config.split("\n"))
                .filter(x -> x.contains(beginKey)).filter(x -> x.contains(keyWordTemplate))
                .map(x -> x.replace("\"", "")).toList();
        String onlyValues = String.join(",", textParts.stream().map(x -> x.replace(beginKey, "")).toList());
        List<String> vars = Arrays.stream(onlyValues.split(","))
                .filter(x -> x.contains(keyWordTemplate))
                .map(x -> x.replace(keyWordTemplate, "")).toList();
        return String.join(",", vars);
    }
}
//END
