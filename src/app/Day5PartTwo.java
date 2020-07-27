package app;

public class Day5PartTwo {

    public static int diagnosticProgram(String[] code, int input, int phaseSetting) {
        // convert String [] to Integer []

        int output = 0;
        int count = 0;

        Integer[] intCode = new Integer[code.length];
        for (int i = 0; i < code.length; i++) {
            intCode[i] = Integer.parseInt(code[i]);
        }

        int i = 0;
        
        programLoop:

    

        while (i < intCode.length) {

            // if (count == 1) {
            //     for (int k = 1; k < intCode.length; k++) {
            //         if (intCode[k] == 3) {
            //             newInstruction = k;
            //             i = newInstruction;
            //             count ++;
            //             break;
            //         }
            //     }
            // } else {

                // create variables for checking throuhg opCode

                int instructionCode = intCode[i] % 100;
                int parameterCodeA = intCode[i] / 100 % 10;
                int parameterCodeB = intCode[i] / 1000 % 10;

                // check integers in code for instruction and parameterCode, display output
                // Bedingungsoperator: variable = Bedingung ? wert x : wert y;
                // ? = falls vorangestellte Bedingung erfüllt ist, führe aus...
                // : = falls Bedingung nicht erfüllt ist, führe aus...

                switch (instructionCode) {
                    case 1:

                        intCode[intCode[i + 3]] = (parameterCodeA == 0 ? intCode[intCode[i + 1]] : intCode[i + 1])
                                + (parameterCodeB == 0 ? intCode[intCode[i + 2]] : intCode[i + 2]);
                        i += 4;
                        break;

                    case 2:

                        intCode[intCode[i + 3]] = (parameterCodeA == 0 ? intCode[intCode[i + 1]] : intCode[i + 1])
                                * (parameterCodeB == 0 ? intCode[intCode[i + 2]] : intCode[i + 2]);
                        i += 4;
                        break;

                    case 3:

                        if (count == 0) {

                            intCode[intCode[i + 1]] = phaseSetting;
                            count++;
                        } else if (count == 1) {
                            intCode[intCode[i + 1]] = input;
                        }

                        i += 2;

                        break;

                    case 4:

                        output = (intCode[intCode[i + 1]]);
                        i += 2;
                        return output;

                    case 5:

                        if (parameterCodeA == 0 ? intCode[intCode[i + 1]] != 0 : intCode[i + 1] != 0) {
                            i = (parameterCodeB == 0 ? intCode[intCode[i + 2]] : intCode[i + 2]);
                        } else {
                            i += 3;
                        }
                        break;

                    case 6:

                        if (parameterCodeA == 0 ? intCode[intCode[i + 1]] == 0 : intCode[i + 1] == 0) {
                            i = (parameterCodeB == 0 ? intCode[intCode[i + 2]] : intCode[i + 2]);
                        } else {
                            i += 3;
                        }
                        break;

                    case 7:

                        if ((parameterCodeA == 0 ? intCode[intCode[i + 1]]
                                : intCode[i + 1]) < (parameterCodeB == 0 ? intCode[intCode[i + 2]] : intCode[i + 2])) {
                            intCode[intCode[i + 3]] = 1;
                        } else {
                            intCode[intCode[i + 3]] = 0;
                        }
                        i += 4;

                        break;

                    case 8:

                        if ((parameterCodeA == 0 ? intCode[intCode[i + 1]] : intCode[i + 1])
                                .equals((parameterCodeB == 0 ? intCode[intCode[i + 2]] : intCode[i + 2]))) {
                            intCode[intCode[i + 3]] = 1;
                        } else {
                            intCode[intCode[i + 3]] = 0;
                        }
                        i += 4;
                        break;

                    case 99:

                    

                        break programLoop;

                }

            }
        // }
        return output;
    }

}
