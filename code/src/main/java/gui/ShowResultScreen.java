package gui;

import valueobjects.L2Protocol;
import valueobjects.OutputValues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ShowResultScreen extends JFrame{
    // global settings
    private final int GLOBAL_PADDING = 50;
    private final Font TEXT_FONT = new Font("Sans Serif", Font.PLAIN, 17);
    private final Font HEADLINE_FONT = new Font("Sans Serif", Font.PLAIN, 18);
    private final int HEIGHT = 40;

    // frame settings
    private final int FRAME_WIDTH = 300;
    private final String WINDOW_NAME = "Results - L2_Calculator";

    private JFrame mainScreen;
    private JLabel[][] results;

    public ShowResultScreen(ArrayList<OutputValues> outputValues, boolean padding, MainScreen mainScreen) {
        super();
        // set instance vars
        this.mainScreen = mainScreen;
        setupOutput(outputValues, padding);

        setupSuper(padding, outputValues.size());
    }

    private void setupSuper(boolean padding, int size) {
        // calculate frame size
        int linesPerResult = 4;
        if (padding) linesPerResult++;
        final int FRAME_HEIGHT = GLOBAL_PADDING + size*linesPerResult*HEIGHT + GLOBAL_PADDING;

        // setup frame
        super.setTitle(WINDOW_NAME);
        super.setSize(FRAME_WIDTH, FRAME_HEIGHT); // sets the frames size
        super.setLayout(null); // allows proper positioning of elements
        //super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminates the programm closing the frame
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        super.setLocationRelativeTo(null); // places the frame initially in the center of the screen
        super.setVisible(true); // show everything
    }

    private void setupOutput(ArrayList<OutputValues> outputValues, boolean padding){
        results = new JLabel[outputValues.size()][];
        for (int i = 0; i < outputValues.size(); i++) {
            displayResult(i, outputValues.get(i), padding);
        }
    }

    private void displayResult(int index, OutputValues outputValues, boolean padding) {
        // calculate the size of each previous text block
        int numberOfLinesPerBlock = 3;
        if (padding) numberOfLinesPerBlock++;
        int sizeOfEachTextBlock = HEIGHT * numberOfLinesPerBlock + HEIGHT;

        // setup array fot this protocols results
        results[index] = new JLabel[numberOfLinesPerBlock];

        // setup headline
        results[index][0] = new JLabel(protocolToString(outputValues.PROTOCOL));
        results[index][0].setFont(HEADLINE_FONT);
        results[index][0].setBounds(GLOBAL_PADDING, GLOBAL_PADDING + sizeOfEachTextBlock*index, FRAME_WIDTH - (GLOBAL_PADDING * 2), HEIGHT);
        results[index][0].setVisible(true);
        super.add(results[index][0]);

        // setup text
        // bytes
        results[index][1] = new JLabel(outputValues.TOTAL_BYTES+" bytes");
        results[index][1].setFont(TEXT_FONT);
        results[index][1].setBounds(GLOBAL_PADDING, GLOBAL_PADDING + sizeOfEachTextBlock*index + HEIGHT, FRAME_WIDTH, HEIGHT);
        results[index][1].setVisible(true);
        super.add(results[index][1]);

        // cells / frames
        results[index][2] = new JLabel(getPacketsAsString(outputValues));
        results[index][2].setFont(TEXT_FONT);
        results[index][2].setBounds(GLOBAL_PADDING, GLOBAL_PADDING + sizeOfEachTextBlock*index + (HEIGHT*2), FRAME_WIDTH, HEIGHT);
        results[index][2].setVisible(true);
        super.add(results[index][2]);

        // padding if needed
        if (padding){
            results[index][3] = new JLabel(outputValues.BYTES_OF_PADDING+" bytes of padding");
            results[index][3].setFont(TEXT_FONT);
            results[index][3].setBounds(GLOBAL_PADDING, GLOBAL_PADDING + sizeOfEachTextBlock*index + (HEIGHT*3), FRAME_WIDTH, HEIGHT);
            results[index][3].setVisible(true);
            super.add(results[index][3]);
        }
    }

    private String getPacketsAsString(OutputValues outputValues) {
        if (outputValues.PROTOCOL == L2Protocol.AAL3_4_ATM || outputValues.PROTOCOL == L2Protocol.AAL5_ATM) {
            return outputValues.NR_PACKETS + " cells";
        } else {
            return outputValues.NR_PACKETS + " frames";
        }
    }

    private String protocolToString(L2Protocol protocol) {
        if (protocol == L2Protocol.AAL3_4_ATM) return "AAL3/4-ATM";
        else if (protocol == L2Protocol.AAL5_ATM) return "AAL5-ATM";
        else if (protocol == L2Protocol.ETHERNET) return "Ethernet";
        else return "unexpected L2Protocol value in function rotocolToString of class ShowResultScreen";
    }

    @Override
    public void dispose(){
        mainScreen.setVisible(true);
        super.dispose();
    }
}
