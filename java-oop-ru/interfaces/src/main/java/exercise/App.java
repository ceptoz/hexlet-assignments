package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildAppartmentsList(List<Home> estateItems, int elementsToTake) {
        if (estateItems.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> resultList = new ArrayList<>();
        List<Home> estateSorted = estateItems.stream().sorted(Comparator.comparing(Home::getArea)).toList();
        for (int i = 0; i < elementsToTake; i++) {
            resultList.add(estateSorted.get(i).toString());
        }
        return resultList;
    }
}
// END
