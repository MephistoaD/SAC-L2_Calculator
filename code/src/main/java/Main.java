import calculators.Calculator;
import cli.CLIInterpreter;
import gui.GUIMode;
import valueobjects.InputValues;
import valueobjects.L2Protocol;
import valueobjects.OutputValues;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        run(args);
    }

    static int run(String[] args) {
        // convert the args to object of type InputValues
        InputValues inputValues = CLIInterpreter.readArgs(args);
        // if the inputValues are a null reference, the program terminates (use return, not exit!)
        if (Objects.isNull(inputValues)){
            return 1;
        }
        // if the program was started in GUI mode, start the gui and don't do anything more
        if (inputValues.GUI){
            GUIMode.init();
            return 0;
        }
        // if the program was started in CLI mode, run the calculations for each element in the PROTOCOLS array
        // print the results in the required format to the CLI
        for (L2Protocol protocol : inputValues.PROTOCOLS){
            System.out.println(printOutputValues(calculateValuesForProtocol(inputValues.BYTES, protocol), inputValues.PADDING));
        }
        return 0;
    }

    private static OutputValues calculateValuesForProtocol(int bytes, L2Protocol protocol) {
        OutputValues outputValues = null;
        switch (protocol){
            case AAL3_4_ATM:
                outputValues = Calculator.calculateALL34ATM(bytes);
                break;
            case AAL5_ATM:
                outputValues = Calculator.calculateALL5ATM(bytes);
                break;
            case ETHERNET:
                outputValues = Calculator.calculateEthernet(bytes);
                break;
        }
        return outputValues;
    }

    public static String printOutputValues(OutputValues outputValues, boolean padding){
        StringBuilder stringBuilder = new StringBuilder();
        String protocol;
        String packets;
        switch (outputValues.PROTOCOL){
            case AAL3_4_ATM:
                protocol = "AAL3/4-ATM";
                packets = "cells";
                break;
            case AAL5_ATM:
                protocol = "AAL5-ATM";
                packets = "cells";
                break;
            default:
                protocol = "Ethernet";
                packets = "frames";
        }
        stringBuilder.append(protocol).append("\n");                                            // Ethernet
        stringBuilder.append(outputValues.TOTAL_BYTES).append(" Bytes\n");                      // 86 Bytes
        stringBuilder.append(outputValues.NR_PACKETS).append(" ").append(packets).append("\n"); // 17 cells
        if (padding){
            stringBuilder.append(outputValues.BYTES_OF_PADDING).append(" bytes of padding\n");   // 8 Bytes of padding
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();                                                        // empty line below
    }

}
