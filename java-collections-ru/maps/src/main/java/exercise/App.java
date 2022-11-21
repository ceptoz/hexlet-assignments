package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> resultMap = new HashMap<>();
        String[] arrayOfWords = sentence.toLowerCase().split(" ");
        for (String word : arrayOfWords) {
            if (arrayOfWords.length == 1 && word.equals("")) {
                break;
            } else if (!resultMap.containsKey(word)) {
                resultMap.put(word, 1);
            } else {
                resultMap.put(word, resultMap.get(word) + 1);
            }
        }
        return resultMap;
    }

    public static String toString(Map<String, Integer> words) {
        StringBuilder sb = new StringBuilder("{\n");
        if (words.isEmpty()) {
            return "{}";
        }
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            sb.append(String.format("  %s: %d\n", word.getKey(), word.getValue()));
        }
        sb.append("}");
        return sb.toString();
    }
}
//END
