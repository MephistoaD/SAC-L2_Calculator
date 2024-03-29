


import calculators.Calculator;
import cli.CLIInterpreter;
import gui.GUIMode;
import valueobjects.InputValues;
import valueobjects.L2Protocol;
import valueobjects.OutputValues;

import java.util.Objects;

public class Main {
    private final CLIInterpreter CLI;
    private final Calculator ETHERNET_CALCULATOR, AAL5_CALCULATOR, AAL34_CALCULATOR;

    Main(CLIInterpreter cli, Calculator ethernet, Calculator aal5, Calculator aal34){
        this.CLI = cli;
        this.ETHERNET_CALCULATOR = ethernet;
        this.AAL5_CALCULATOR = aal5;
        this.AAL34_CALCULATOR = aal34;
    }


    public static void main(String[] args) {
        // args = new String[]{"-B", "800B", "-L2", "AAL5-ATM", "Ethernet", "-P"};
        // args = new String[]{"--gui"};
        CLIInterpreter cli = CLIInterpreter.create();
        Calculator ethernet = Calculator.createEhernetCalculator();
        Calculator aal5 = Calculator.createAAL5Calculator();
        Calculator aal34 = Calculator.createAAL34Calculator();
        Main m = new Main(cli, ethernet, aal5, aal34);
        m.run(args);


    }

    public int run(String[] args) {
        // convert the args to object of type InputValues
        InputValues inputValues = CLI.convertArguments(args);
        // if the inputValues are a null reference, the program terminates (use return, not exit!)
        if (Objects.isNull(inputValues)){
            printInvalidMessage();
            return 1;
        }
        // if the program was started in help mode print the help message and terminate
        if (inputValues.HELP){
            printHelpMessage();
            return 0;
        }
        // if the program was started in GUI mode, start the gui and don't do anything more
        if (inputValues.GUI){
            GUIMode.init();
            return 0;
        }
        // if the program was started in CLI mode, run the calculations for each element in the PROTOCOLS array
        // print the results in the required format to the CLI
        for (L2Protocol protocol : inputValues.PROTOCOLS){
            System.out.println(getOutputText(calculateValuesForProtocol(inputValues.BYTES, protocol), inputValues.PADDING));
        }
        return 0;
    }

    private void printInvalidMessage() {
        System.out.println("L2_Calculator: You must specify valid options or parameters\n" +
                "\n" +
                "Try 'L2_Calculator --help' for more information.\n" +
                "\n");
    }

    private void printHelpMessage() {
        System.out.println("Usage: L2_Calculator [options]\n" +
                "Calculate the number and summarized size of AAL3/4-ATM, ALL5-ATM and Ethernet packages.\n" +
                "\n" +
                "Mandatory arguments for command line mode:\n" +
                "  -B,  --bytes          (mandatory) option to introduce the number of Bytes that are sent.\n" +
                "  -L2, --l2-protocol    (mandatory) option to set the L2 protocols for the calculations.\n" +
                "                                    Protocols AAL5-ATM, AAL3/4-ATM and Ethernet must be separated by a space.\n" +
                "  -P,  --padding        (optional)  option to set that padding bytes must be included in the results too\n" +
                "       --gui            option to start the program in GUI mode\n" +
                "   ?,  --help           option to show the parameters that can be used to execute the program");
    }

    private OutputValues calculateValuesForProtocol(int bytes, L2Protocol protocol) {
        OutputValues outputValues = null;
        switch (protocol){
            case AAL3_4_ATM:
                outputValues = AAL34_CALCULATOR.calculate(bytes);
                break;
            case AAL5_ATM:
                outputValues = AAL5_CALCULATOR.calculate(bytes);
                break;
            case ETHERNET:
                outputValues = ETHERNET_CALCULATOR.calculate(bytes);
                break;
        }
        return outputValues;
    }

    public String getOutputText(OutputValues outputValues, boolean padding){
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