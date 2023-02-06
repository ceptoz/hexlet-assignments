package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static exercise.Car.unserialize;

// BEGIN
public class App {
    public static void save(Path filepath, Car car) {
        String text = car.serialize();
        try {
            Files.writeString(filepath, text, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path filepath) {
        String jsonText = "";
        try {
            jsonText = Files.readString(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return unserialize(jsonText);
    }
}
// END
