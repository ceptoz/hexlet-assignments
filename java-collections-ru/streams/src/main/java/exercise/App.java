package exercise;

import java.util.List;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        return (int) emails
                .stream()
                .filter(e -> e.contains("@gmail.com") || e.contains("@yandex.ru") || e.contains("@hotmail.com"))
                .count();
    }
}
// END
