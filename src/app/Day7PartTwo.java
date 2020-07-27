package app;

import java.util.ArrayList;
import java.util.HashMap;

public class Day7PartTwo {

    static int lastOutputSignal = 0;

    static int output = 0;

    static int exitCode = 0;

    static int countAmplifierRun = 0;

    static int[] countAmplifier = new int[] { 0, 0, 0, 0, 0 };

    static int amplifierReference = 0;

    private HashMap<Integer, int[]> amplifierControllerSoftware = new HashMap<>();

    public HashMap<Integer, int[]> getAmplifierControllerSoftware() {
        return this.amplifierControllerSoftware;
    }

    public void setAmplifierControllerSoftware() {
        for (int j = 0; j < 5; j++) {

            // this.amplifierControllerSoftware.put(j, AdventOfCode.intCode);
        }

    }

    public void setListAmplifierControllerSoftware(int input, int[] list) {
        this.amplifierControllerSoftware.put(input, list);

    }

    public void amplificationCircuit() {

        ArrayList<Integer> signalToThrusters = new ArrayList<>();

        // create permutations
        int[] phaseSettings = new int[] { 5, 6, 7, 8, 9 };
        int[] usedPhaseSetting = new int[5];

        ArrayList<ArrayList<Integer>> possiblePhaseSettings = permute(phaseSettings);

        // run the programm

        for (int i = 0; i < possiblePhaseSettings.size(); i++) {

            setAmplifierControllerSoftware();

            for (int j = 0; j < 5; j++) {

                countAmplifier[j] = 0;
            }

            output = 0;
            exitCode = 0;

            countAmplifierRun = 0;

            while (exitCode != 99) {
                for (int k = 0; k < 5; k++) {

                    amplifierReference = k;

                    usedPhaseSetting[k] = possiblePhaseSettings.get(i).get(k);

                    Amplifier.diagnosticProgram(output, usedPhaseSetting[k], this);

                    countAmplifierRun++;
                }
            }
            signalToThrusters.add(lastOutputSignal);

        }

        // for (int i = 0; i < signalToThrusters.size(); i++) {
        //     System.out.println(signalToThrusters.get(i));
        // }

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