package app;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void gravitiyAssistProgramm(String[] input) {

        Integer[] intCode = new Integer[input.length];

        for (int i = 0; i < input.length; i +=4) {
            intCode[i] = Integer.parseInt(input[i]);
        }

        intCode[1] = 12;
        intCode[2] = 2;

        for (int i = 0; i < intCode.length; i += 4) {

            if (intCode[i] == 1) {

                intCode[intCode[i + 3]] = intCode[intCode[i + 1]] + intCode[intCode[i + 2]];

            } else if (intCode[i] == 2) {

                intCode[intCode[i + 3]] = intCode[intCode[i + 1]] * intCode[intCode[i + 2]];

            }

            if (intCode[i] == 99) {
                break;
            }

        }

        System.out.println(intCode[0]);

    }

    public static void specialOutput(String[] input) {
        Integer[] opCode = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            opCode[i] = Integer.parseInt(input[i]);
        }


        List <Integer> newCode = new ArrayList<> ();
        for (int i : opCode) {
            newCode.add(i);
        }

        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++) {

                // reset memory before each round

                List <Integer> intCode = new ArrayList<> ();
                intCode.addAll(newCode);

                intCode.set(1, noun);
                intCode.set(2, verb);

                for (int i = 0; i < intCode.size() ; i += 4) {

                    /*if (intCode.get(i) == 1) {

                        intCode.set(intCode.get(i + 3), intCode.get(i + 1) + intCode.get(i + 2));

                    } else if (intCode.get(i) == 2) {

                        intCode.set(intCode.get(i + 3), intCode.get(i + 1) * intCode.get(i + 2));

                    } else if (intCode.get(i) == 99) {
                        break;

                    }*/

                    // Bedingungsoperator: variable = Bedingung ? wert x : wert y;
                    // ? = falls vorangestellte Bedingung erfüllt ist, führe aus... 
                    // : = falls Bedingung nicht erfüllt ist, führe aus...


                    intCode.set(intCode.get(i+3), intCode.get(i) == 1 ? intCode.get(intCode.get(i+1)) + intCode.get(intCode.get(i+2)) 
                    : intCode.get(i) == 2 ? intCode.get(intCode.get(i+1)) * intCode.get(intCode.get(i+2)) 
                    : intCode.get(i+3));

                    if (intCode.get(i) == 99) {
                        break;
                    }

                    if (intCode.get(0) == 19690720) {
                        System.out.println(noun);
                        System.out.println(verb);
                        System.out.println(100* noun + verb);

                    }

                }

            }
        }
    }


}