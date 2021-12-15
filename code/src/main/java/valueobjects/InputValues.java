package code.src.main.java.valueobjects;

/**
 * How to interpret this object?
 * 1. check for unidentified parameters, the user is going to get an alert if running with valid input and moreover invalid input
 * 2. check for the GUI value: if it's true the program should start in another mode
 * 3. if the mode is CLI, run the calculations for each element of PROTOCOLS with the given values
 *
 * You can READ the values from this class accessing the variables directly,
 * PLEASE don't even consider changing one existing objects instance variables as this is sureley causing days of headace
 */


public class InputValues {
    // determines if the application is started in GUI mode
    // GUI == true means gui mode, else it's the CLI mode
    public final boolean      GUI;

    // The parameters we are required to interprete
    public final int          BYTES;
    public final L2Protocol[] PROTOCOLS;
    public final boolean      PADDING;
    public final boolean      HELP;


    // Constructor for GUI mode
    public InputValues(boolean gui) {
        GUI = gui;
        BYTES = 0;
        PROTOCOLS = null;
        PADDING = false;
        HELP = false;
    }

    // Constructor for CLI mode
    public InputValues(int bytes, L2Protocol[] protocols, boolean padding, boolean help){
        GUI = false;
        BYTES = bytes;
        PROTOCOLS = protocols;
        PADDING = padding;
        HELP = help;
    }
}
