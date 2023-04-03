package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {

        Map<String, Integer> result = new HashMap<>();

        MaxThread maxThread = new MaxThread(numbers);
        maxThread.start();
        LOGGER.info("Thread maxThread started");
        MinThread minThread = new MinThread(numbers);
        minThread.start();
        LOGGER.info("Thread minThread started");

        try {
            maxThread.join();
            LOGGER.info("maxThread finished");
        } catch (InterruptedException e) {
            System.out.println("maxThread interrupted!");
        }

        try {
            minThread.join();
            LOGGER.info("minThread finished");
        } catch (InterruptedException e) {
            System.out.println("minThread interrupted!");
        }

        result.put("max", maxThread.getMaxNumber());
        result.put("min", minThread.getMinNumber());

        return result;
    }
    // END
}
