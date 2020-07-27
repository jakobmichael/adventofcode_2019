package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day4 {
    public static List<Integer> numberOfPasswords = new ArrayList<>();
    public static List<Integer> numberOfPasswords1 = new ArrayList<>();

    public static void checkPassword(int min, int max) {

        List<Integer> numberOfPasswords = new ArrayList<>();

        for (int i = min; i <= max; i++) {

            String[] splitString = Integer.toString(i).split("");
            Integer[] digits = new Integer[splitString.length];
            List<Boolean> check = new ArrayList<>();

            for (int j = 0; j < digits.length; j++) {
                digits[j] = Integer.parseInt(splitString[j]);
            }

            for (int k = 1; k < digits.length; k++) {

                if (digits[k] >= digits[k - 1] && checkForDuplicates(digits) && checkConditionTwo(digits)) {

                    check.add(true);
                } else {
                    check.add(false);
                }
            }

            if (!check.contains(false)) {
                numberOfPasswords.add(i);
            }

        }

        System.out.println(numberOfPasswords.size() + " different passwords are possible!");
        
    }

    private static boolean checkForDuplicates(Integer[] input) {
        Long distinctCount = Stream.of(input).distinct().count();

        return input.length != distinctCount;
    }

    public static boolean checkConditionTwo(Integer[] input) {

        boolean valueOfReturn = false;
        List<Integer> countValues = new ArrayList<>();
        List<Boolean> verifyValues = new ArrayList<>();
        for (int k = 0; k <= 10; k++) {
            countValues.add(0);
        }

        int count = 0, currentInt = 0;
        for (int i = 0; i < input.length; i++) {
            currentInt = input[i];
            count = 0;

            for (int j = 0; j <= 9; j++) {
                if (currentInt == j) {
                    count++;
                    countValues.set(j, countValues.get(j) + count);
                    break;

                }

            }
        }
        // for (int k = 0; k < countValues.size(); k++) {
        // if (countValues.get(k) % 2 == 0 | countValues.get(k) == 1) {
        // verifyValues.add(true);
        // } else {
        // verifyValues.add(false);
        // }
        // }

        if (countValues.contains(2)) {
            verifyValues.add(true);
        } else {
            verifyValues.add(false);
        }

        if (verifyValues.contains(false)) {
            valueOfReturn = false;
        } else {
            valueOfReturn = true;
        }
        return valueOfReturn;
    }

}
