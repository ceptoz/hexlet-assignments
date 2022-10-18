package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        String[] lettersArr = letters.toLowerCase().split("");
        String[] wordArr = word.toLowerCase().split("");
        int equivalenceCounter = 0;

        List<String> lettersList = new ArrayList<>(Arrays.asList(lettersArr));

        for (String s : wordArr) {
            if (lettersList.contains(s)) {
                equivalenceCounter++;
                lettersList.remove(s);
            }
        }

        return equivalenceCounter == wordArr.length;
    }
}
//END
