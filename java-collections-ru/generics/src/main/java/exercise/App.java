package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> valuesToCompare) {
        List<Map<String, String>> resultBooks = new ArrayList<>();
        for (Map book : books) {
            if(book.entrySet().containsAll(valuesToCompare.entrySet())) {
                resultBooks.add(book);
            }
        }
        return resultBooks;
    }
}
//END
