
package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventOfCode {

    // static String[] opCode = readFile(7).get(0).split("[2\\0\\1]" );
    // static int[] intCode = new int[AdventOfCode.opCode.length];

    public static void main(String[] args) {

        // Day7PartTwo tryDay7 = new Day7PartTwo();

        // input Day1

        //
        // Day1.needFuel(readFile(1));
        //
        // String[] intCode = readFile(2).get(0).split(",");
        //
        // Day2.gravitiyAssistProgramm(intCode);
        //

        // // input Day2

        //
        // String[] opCode = readFile(2).get(0).split(",");
        //
        // Day2.specialOutput(opCode);
        //

        // input Day3

        // Day4.checkPassword(382345, 843167);

        // input Day 5

        // for (int i = 0; i < opCode.length; i++) {
        // intCode[i] = Integer.parseInt(opCode[i]);
        // }

        // tryDay7.amplificationCircuit();

        // input Day 6

        // List<String> orbitList = readFile(6);

        // Day6.checkOrbitList(orbitList);

        // String[][] testArray = new String[orbitList.size()][orbitList.size()];
        // for (int i = 0; i < orbitList.size(); i++) {
        // for (int k = 0; k < orbitList.size(); k++) {

        // i = orbitList.get(i).split(")"));
        // k = orbitList.get(i).split(")"));

        // testArray[i] [k] = orbitList.get(i).split(")"));

        // }
        // }

        // input Day 8

        List<String> input = readFile(8);

        

        String[] sentData = input.get(0).split("(?!^)");

        int[] encodedPassword = new int[sentData.length];

        for (int i = 0; i < sentData.length; i++) {
        encodedPassword[i] = Integer.parseInt(sentData[i]);
        }

        Day8.decodePassword(encodedPassword);

    }

    public static List<String> readFile(int day) {

        String csvFile = "C:\\devel\\Spielwiese\\adventOfCode\\day" + day + ".txt";
        BufferedReader br = null;
        String line = "";

        List<String> input = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                input.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return input;
    }
}
