package app;

public class Amplifier {

    public static void diagnosticProgram(int input, int phaseSetting, Day7PartTwo tryDay7) {

        int i;
        int output;

        int count = 0;
        int[] usedCode = tryDay7.getAmplifierControllerSoftware().get(Day7PartTwo.amplifierReference).clone();

        // convert String [] to Integer []

        i = Day7PartTwo.countAmplifier[Day7PartTwo.amplifierReference];

        endLoop:

        while (i < usedCode.length) {

            int instructionCode = usedCode[i] % 100;
            int parameterCodeA = usedCode[i] / 100 % 10;
            int parameterCodeB = usedCode[i] / 1000 % 10;

            switch (instructionCode) {
                case 1:

                    usedCode[usedCode[i + 3]] = (parameterCodeA == 0 ? usedCode[usedCode[i + 1]] : usedCode[i + 1])
                            + (parameterCodeB == 0 ? usedCode[usedCode[i + 2]] : usedCode[i + 2]);
                    i += 4;
                    break;

                case 2:

                    usedCode[usedCode[i + 3]] = (parameterCodeA == 0 ? usedCode[usedCode[i + 1]] : usedCode[i + 1])
                            * (parameterCodeB == 0 ? usedCode[usedCode[i + 2]] : usedCode[i + 2]);
                    i += 4;
                    break;

                case 3:

                    if (Day7PartTwo.countAmplifierRun <= 4) {

                        if (count == 0) {

                            usedCode[usedCode[i + 1]] = phaseSetting;
                            count++;
                        } else {
                            usedCode[usedCode[i + 1]] = input;
                        }

                        i += 2;

                        break;
                    } else {
                        usedCode[usedCode[i + 1]] = input;
                        i += 2;

                        break;
                    }

                case 4:

                    output = (usedCode[usedCode[i + 1]]);
                    i += 2;
                    count++;
                    Day7PartTwo.output = output;
                    Day7PartTwo.countAmplifier[Day7PartTwo.amplifierReference] = i;
                    if (Day7PartTwo.amplifierReference == 4) {
                        Day7PartTwo.lastOutputSignal = output;
                    }
                    tryDay7.setListAmplifierControllerSoftware(Day7PartTwo.amplifierReference, usedCode);

                    break endLoop;

                case 5:

                    if (parameterCodeA == 0 ? usedCode[usedCode[i + 1]] != 0 : usedCode[i + 1] != 0) {
                        i = (parameterCodeB == 0 ? usedCode[usedCode[i + 2]] : usedCode[i + 2]);
                    } else {
                        i += 3;
                    }
                    break;

                case 6:

                    if (parameterCodeA == 0 ? usedCode[usedCode[i + 1]] == 0 : usedCode[i + 1] == 0) {
                        i = (parameterCodeB == 0 ? usedCode[usedCode[i + 2]] : usedCode[i + 2]);
                    } else {
                        i += 3;
                    }
                    break;

                case 7:

                    if ((parameterCodeA == 0 ? usedCode[usedCode[i + 1]]
                            : usedCode[i + 1]) < (parameterCodeB == 0 ? usedCode[usedCode[i + 2]] : usedCode[i + 2])) {
                        usedCode[usedCode[i + 3]] = 1;
                    } else {
                        usedCode[usedCode[i + 3]] = 0;
                    }
                    i += 4;

                    break;

                case 8:

                    if ((parameterCodeA == 0 ? usedCode[usedCode[i + 1]]
                            : usedCode[i + 1]) == ((parameterCodeB == 0 ? usedCode[usedCode[i + 2]]
                                    : usedCode[i + 2]))) {
                        usedCode[usedCode[i + 3]] = 1;
                    } else {
                        usedCode[usedCode[i + 3]] = 0;
                    }
                    i += 4;
                    break;

                case 99:
                    Day7PartTwo.exitCode = 99;

                    break endLoop;

            }

        }

        // }

    }

}
