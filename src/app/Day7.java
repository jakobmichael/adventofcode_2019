package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day7 {

    static int[] phaseSettings = new int[] { 0, 1, 2, 3, 4 };

    static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    static HashMap<Integer, List<Integer>> numberOfPermutations = new HashMap<>();

    public static void amplificationCircuit(String[] amplifierControllerSoftware) {

        ArrayList<Integer> signalToThrusters = new ArrayList<>();
        int output = 0;

        // create permutations

        ArrayList<ArrayList<Integer>> possiblePhaseSettings = permute(phaseSettings);

        // run the programm

        for (int i = 0; i < possiblePhaseSettings.size(); i++) {
            output = 0;
            for (int k = 0; k < 5; k++) {

                int usedPhaseSetting = possiblePhaseSettings.get(i).get(k);

                output = Day5PartTwo.diagnosticProgram(amplifierControllerSoftware, output, usedPhaseSetting);
                if (k == 4) {
                    signalToThrusters.add(output);
                }

            }
        }

        System.out.println(getMax(signalToThrusters));
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        // start from an empty list
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            // list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);

                    // System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Integer>>(current);
        }

        return result;
    }

    public static int getMax(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

}