package app;

import java.util.ArrayList;
import java.util.List;

public class Day8 {

    public static void decodePassword(int[] encodedPassword) {

        int count = -150;
        int countMax = 0;

        List<List<Integer>> listOfLayers = new ArrayList<>();

        for (int i = 0; i < encodedPassword.length / 150; i++) {
            List<Integer> layer = new ArrayList<>();

            count += 150;
            countMax += 150;

            for (int k = count; k < countMax; k++) {

                layer.add(encodedPassword[k]);

            }

            listOfLayers.add(layer);

        }

        List<int[]> checkLayers = new ArrayList<>();

        int countZeros = 0;
        int countOnes = 0;
        int countTwos = 0;

        for (int i = 0; i < listOfLayers.size(); i++) {

            countZeros = 0;
            countOnes = 0;
            countTwos = 0;
            int[] countDigits = new int[3];

            for (int k = 0; k < 150; k++) {
                switch (listOfLayers.get(i).get(k)) {

                    case 0:

                        countZeros++;
                        countDigits[0] = countZeros;
                        break;

                    case 1:

                        countOnes++;
                        countDigits[1] = countOnes;
                        break;

                    case 2:

                        countTwos++;
                        countDigits[2] = countTwos;
                        break;

                }

            }
            countDigits[0] = countZeros;
            countDigits[1] = countOnes;
            countDigits[2] = countTwos;

            checkLayers.add(countDigits);

        }

        int layerWithMinZeros = getMax(checkLayers);

        int onesMultipliedWithTwos = checkLayers.get(layerWithMinZeros)[1] * checkLayers.get(layerWithMinZeros)[2];
        System.out.println(onesMultipliedWithTwos);
    }

    public static int getMax(List<int[]> checkLayers) {

        int countZeros = 150;
        int neededLayer = 0;
        for (int i = 0; i < checkLayers.size(); i++) {

            if (checkLayers.get(i)[0] < countZeros) {

                countZeros = checkLayers.get(i)[0];
                neededLayer = i;
            }

        }
        return neededLayer;
    }

}
