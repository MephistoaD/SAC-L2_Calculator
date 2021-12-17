package code.src.main.java.gui;

import code.src.main.java.calculators.Calculator;
import code.src.main.java.valueobjects.OutputValues;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainScreen extends JFrame implements GUIMode {
    // global settings
    private final int GLOBAL_PADDING = 50;
    private final Font GLOBAL_FONT = new Font("Sans Serif", Font.PLAIN, 18);
    private final int HEIGHT = 40;

    // frame settings
    private final int FRAME_WIDTH = 450;
    private final int FRAME_HEIGHT = GLOBAL_PADDING * 8;
    private final String WINDOW_NAME = "L2_Calculator";

    // calculateButton settings (the button is in the lower right corner with GLOBAL_PADDING distance to the frames boarder)
    private final int BUTTON_WIDTH = 120;
    private final int BUTTON_HEIGTH = 50;

    // byteInput settings
    private final String DEFAULT_INPUT = "800B";
    private final String MESSAGE = "Please introduce the number of bytes:";

    private JButton calculateButton;
    private JTextField byteInput;
    private JLabel textLabel;
    private JRadioButton aal5, aal34, ethernet;
    private JCheckBox padding;

    MainScreen(){
        // init jframe
        super();
        setupCalculateButton();
        setupByteInput();
        setupTextPanel();
        setupRadioButtons();
        setupPadding();
        setupSuper();
    }

    private void setupSuper() {
        super.setTitle(WINDOW_NAME);
        super.setSize(FRAME_WIDTH, FRAME_HEIGHT); // sets the frames size
        super.setLayout(null); // allows proper positioning of elements
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminates the programm closing the frame
        super.setLocationRelativeTo(null); // places the frame initially in the center of the screen
        super.setVisible(true); // show everything
    }

    private void setupCalculateButton() {
        calculateButton = new JButton("calculate");
        calculateButton.setBounds(FRAME_WIDTH - GLOBAL_PADDING - BUTTON_WIDTH, FRAME_HEIGHT - BUTTON_HEIGTH - GLOBAL_PADDING - 30, BUTTON_WIDTH, BUTTON_HEIGTH);
        calculateButton.setFont(GLOBAL_FONT);
        calculateButton.setFocusPainted(false); // removes boarder around text
        calculateButton.addActionListener(e -> calculate()); // ActionListener for the button
        super.add(calculateButton);
    }

    private void setupByteInput() {
        byteInput = new JTextField(DEFAULT_INPUT, 10);
        byteInput.setBounds(GLOBAL_PADDING,GLOBAL_PADDING*2, FRAME_WIDTH - (GLOBAL_PADDING * 2), HEIGHT);
        byteInput.setFont(GLOBAL_FONT);

        byteInput.setVisible(true);
        super.add(byteInput);
    }

    private void setupTextPanel(){
        textLabel = new JLabel(MESSAGE);
        textLabel.setBounds(GLOBAL_PADDING, GLOBAL_PADDING, FRAME_WIDTH - (GLOBAL_PADDING * 2), HEIGHT);
        textLabel.setFont(GLOBAL_FONT);
        textLabel.setVisible(true);
        super.add(textLabel);
    }

    private void setupRadioButtons(){
        final int RADIO_BUTTON_WIDTH = (FRAME_WIDTH - GLOBAL_PADDING) / 2;
        // AAL5-ATM
        aal5 = new JRadioButton("AAL5-ATM");
        aal5.setBounds(GLOBAL_PADDING, GLOBAL_PADDING*3, RADIO_BUTTON_WIDTH, HEIGHT);
        aal5.setFont(GLOBAL_FONT);
        super.add(aal5);

        // AAL3/4-ATM
        aal34 = new JRadioButton("AAL3/4-ATM");
        aal34.setBounds(GLOBAL_PADDING, GLOBAL_PADDING*3 + HEIGHT, RADIO_BUTTON_WIDTH, HEIGHT);
        aal34.setFont(GLOBAL_FONT);
        super.add(aal34);

        // Ehernet
        ethernet = new JRadioButton("Ethernet");
        ethernet.setBounds(GLOBAL_PADDING, (GLOBAL_PADDING*3) + (HEIGHT*2), RADIO_BUTTON_WIDTH, HEIGHT);
        ethernet.setFont(GLOBAL_FONT);
        super.add(ethernet);
    }

    private void setupPadding(){
        padding = new JCheckBox("calculate padding");
        padding.setBounds(GLOBAL_PADDING, FRAME_HEIGHT - HEIGHT - GLOBAL_PADDING - 30, (FRAME_WIDTH - GLOBAL_PADDING*2) - BUTTON_WIDTH, HEIGHT);
        padding.setFont(GLOBAL_FONT);
        super.add(padding);
    }

    /**
     * Gets executed in case someone clicked on the calculateButton
     */
    private void calculate() {
        // restore original view
        textLabel.setText(MESSAGE);

        // calculations
        ArrayList<OutputValues> outputValues = new ArrayList<>();
        int bytes = getBytes(byteInput.getText());
        // confrim the bytes field is set properly
        if (bytes == -1){
            textLabel.setText("Please enter a valid value:");
            byteInput.setText(DEFAULT_INPUT);
            return;
        }
        // confirm any protocol is selected
        if (!(aal34.isSelected() || aal5.isSelected() || ethernet.isSelected())){
            textLabel.setText("Please select a protocol");
            return;
        }
        if (aal5.isSelected()){
            outputValues.add(Calculator.createAAL5Calculator().calculate(bytes));
        }
        if (aal34.isSelected()){
            outputValues.add(Calculator.createAAL34Calculator().calculate(bytes));
        }
        if (ethernet.isSelected()){
            outputValues.add(Calculator.createEhernetCalculator().calculate(bytes));
        }
        // show answer in new thread
        swithcToResultScreen(outputValues);
    }

    private void swithcToResultScreen(ArrayList<OutputValues> outputValues) {
        MainScreen mainScreen = this;
        super.setVisible(false);
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new ShowResultScreen(outputValues, padding.isSelected(), mainScreen);
            }
        } );
    }

    private int getBytes(String arg) {
        int kb = 1024;
        int mb = kb * 1024;
        int gb = mb * 1024;
        int tb = gb * 1024;
        int pb = tb * 1024;
        arg.toUpperCase();
        int bytes = -1;
        try{
            if (arg.endsWith("KB")){ // implement kilobytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-2))*kb);
            } else if (arg.endsWith("MB")){ // implement megabytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-2))*mb);
            } else if (arg.endsWith("GB")){ // implement gigabytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-2))*gb);
            } else if (arg.endsWith("TB")){ // implement terrabytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-2))*tb);
            } else if (arg.endsWith("PB")){ // implement petabytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-2))*pb);
            } else if (arg.endsWith("B")){ // implement bytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-1)));
            } else { // implement lonely numbers
                bytes = Integer.parseInt(arg);
            }
        } catch (NumberFormatException e){ // given string is not convertible to a number
            return -1;
        }
        return bytes;
    }
}
