package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        int resultArrLength = image.length * 2;
        if(resultArrLength == 0) {
            return new String[0][0];
        }
        int resultArrWidth = image[0].length * 2;

        String[][] resultArr = new String[resultArrLength][resultArrWidth];

        for(int i = 0; i < resultArrLength; i+=2) {
            for(int j = 0; j < resultArrWidth; j+=2) {
                resultArr[i][j] = image[i/2][j/2];
                resultArr[i][j + 1] = image[i/2][j/2];
            }
            resultArr[i + 1] = resultArr[i];
        }
        return resultArr;
    }

    public static void main(String[] args) {
        String[][] image = new String[0][0];
        System.out.println(Arrays.deepToString(image));
        String[][] enlargedImage = App.enlargeArrayImage(image);
        System.out.println(Arrays.deepToString(enlargedImage));
    }
}
// END
