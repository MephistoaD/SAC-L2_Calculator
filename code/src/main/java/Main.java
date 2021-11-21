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
        System.out.println("Hello Layer 2");
        // convert the args to object of type InputValues
        InputValues inputValues = CLIInterpreter.readArgs(args);
        // if the inputValues are a null reference, the program terminates (use return, not exit!)
        if (Objects.isNull(inputValues)){
            return 1;
        }
        // if the program was started in GUI mode, start the gui and don't do anything more
        // if the program was started in CLI mode, run the calculations for each element in the PROTOCOLS array
        // print the results in the required format to the CLI
        return 0;
    }

}
