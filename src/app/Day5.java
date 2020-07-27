package app;

public class Day5 {

    public static void diagnosticProgram(String[] code, int input) {
        // convert String [] to Integer []

        Integer[] intCode = new Integer[code.length];
        for (int i = 0; i < code.length; i++) {
            intCode[i] = Integer.parseInt(code[i]);
        }

        for (int i = 0; i < intCode.length; i++) {

            // create variables for checking throuhg opCode

            int instructionCode = intCode[i] % 10;
            int parameterCodeA = intCode[i] % 1000 / 100 ;
            int parameterCodeB = intCode[i] % 10000 / 1000;

            // check integers in code for instruction and parameterCode, display output
            // Bedingungsoperator: variable = Bedingung ? wert x : wert y;
            // ? = falls vorangestellte Bedingung erfüllt ist, führe aus...
            // : = falls Bedingung nicht erfüllt ist, führe aus...

            if (instructionCode == 1) {
                if (parameterCodeA == 0 && parameterCodeB == 0) {
                    intCode[intCode[i + 3]] = intCode[intCode[i + 1]] + intCode[intCode[i + 2]];
                    i += 3;

                } else if (parameterCodeA == 0 && parameterCodeB == 1) {
                    intCode[intCode[i + 3]] = intCode[intCode[i + 1]] + intCode[i + 2];
                    i += 3;

                } else if (parameterCodeA == 1 && parameterCodeB == 0) {
                    intCode[intCode[i + 3]] = intCode[i + 1] + intCode[intCode[i + 2]];
                    i += 3;

                } else if (parameterCodeA == 1 && parameterCodeB == 1) {
                    intCode[intCode[i + 3]] = intCode[i + 1] + intCode[i + 2];
                    i += 3;

                }

            } else if (instructionCode == 2) {
                if (parameterCodeA == 0 && parameterCodeB == 0) {
                    intCode[intCode[i + 3]] = intCode[intCode[i + 1]] * intCode[intCode[i + 2]];
                    i += 3;

                } else if (parameterCodeA == 0 && parameterCodeB == 1) {

                    intCode[intCode[i + 3]] = intCode[intCode[i + 1]] * intCode[i + 2];
                    i += 3;

                } else if (parameterCodeA == 1 && parameterCodeB == 0) {
                    intCode[intCode[i + 3]] = intCode[i + 1] * intCode[intCode[i + 2]];
                    i += 3;

                } else if (parameterCodeA == 1 && parameterCodeB == 1) {
                    intCode[intCode[i + 3]] = intCode[i + 1] * intCode[i + 2];
                    i += 3;

                }
            } else if (instructionCode == 3) {
                intCode[intCode[i + 1]] = input;
                i += 1;

            } else if (instructionCode == 4) {
                System.out.println(intCode[intCode[i + 1]]);
                i += 1;

            } else if (instructionCode == 99) {
                break;
            }
        }
    }
}
