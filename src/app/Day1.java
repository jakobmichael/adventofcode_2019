package app;

import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void needFuel(List<String> massList) {

        List<Integer> mass = new ArrayList<>();

        for (String s : massList) {
            mass.add(Integer.valueOf(s));
        }

        List<Integer> neededFuel = new ArrayList<>();

        for (Integer i : mass) {
            neededFuel.add((Math.round(i / 3) - 2));

        }

        int result = 0;
        for (Integer i : neededFuel) {

            result = result + i;
        }

        System.out.println(result);

        // Day1.2

        List<Integer> additionalFuel = new ArrayList<>();

        for (Integer i : neededFuel) {

            List<Integer> fuelModule = new ArrayList<>();

            while (Math.round(i / 3) - 2 > 0) {
                fuelModule.add((Math.round(i / 3) - 2));
                i = Math.round(i / 3) - 2;
            }

            for (Integer j : fuelModule) {

                additionalFuel.add(j);
            }
        }

        for (Integer i : additionalFuel) {

            result = result + i;

        }

        System.out.println(result);

    }

}
