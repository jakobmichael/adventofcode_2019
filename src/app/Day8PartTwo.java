package app;

import java.util.List;

public class Day8PartTwo {

    public static void decodeImage(List<List<Integer>> listOfLayers) {

    }

    public static int checkLayer(int countLayer, List<List<Integer>> listOfLayers, int countPixel) {
        int pixel = 0;

        switch (listOfLayers.get(countLayer).get(countPixel)) {

            case 0:

                pixel = 0;
                break;

            case 1:

                pixel = 1;
                break;

            case 2:

                checkLayer(countLayer + 1, listOfLayers, countPixel);

        }

        return pixel;
    }

}
