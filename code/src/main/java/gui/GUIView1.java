package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIView1 extends JFrame{
    private JPanel panel1;
    private JTextField introduceTheBytesTextField;
    private JRadioButton AAL34RadioButton;
    private JRadioButton AAL5RadioButton;
    private JRadioButton ethernetRadioButton;
    private JButton runButton;
    private JCheckBox paddingCheckBox;
    ButtonGroup radiosGroup;
    public String bytesString;
    public GUIView1() {
        JPanel jp = new JPanel();
        jp.add(panel1);
        JTextField jt= new JTextField();
        jt.add(introduceTheBytesTextField);

        //With these groups, we cannot select more than one button.
        radiosGroup = new ButtonGroup();
        radiosGroup.add(AAL34RadioButton);
        radiosGroup.add(AAL5RadioButton);
        radiosGroup.add(ethernetRadioButton);

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                bytesString = introduceTheBytesTextField.getText(); //get the number of bytes that the users have wirte in the textbox
                int bytes = Integer.parseInt(bytesString);
                functionality(bytes); //When you press the button "run" we will can see the option selected.
            }
        });
    }
    public void functionality(int bytes){
        //In this function we have three different "ifs" with the three algorithm that we have...
        //if we select one of them we have two options, that we just have selected the algorithm, or we have selected the algorithm and the padding
        String radioSelected="";
        if(AAL34RadioButton.isSelected()){

            if(paddingCheckBox.isSelected()){
                //HERE WE CALL THE FUNCTION WHICH CALCULATE THE ALGORITHM SELECTED but WITH PADDING
            }else{
                radioSelected+="AAL34 selected, ";
                //HERE WE CALL THE FUNCTION WHICH CALCULATE THE ALGORITHM SELECTED
            }
        }
        if(AAL5RadioButton.isSelected()){

            if(paddingCheckBox.isSelected()){
                //HERE WE CALL THE FUNCTION WHICH CALCULATE THE ALGORITHM SELECTED but WITH PADDING
            }else {
                radioSelected+="AAL5 selected, ";
                //HERE WE CALL THE FUNCTION WHICH CALCULATE THE ALGORITHM SELECTED
            }
        }
        if(ethernetRadioButton.isSelected()){

            if(paddingCheckBox.isSelected()){
                //HERE WE CALL THE FUNCTION WHICH CALCULATE THE ALGORITHM SELECTED but WITH PADDING
            }else {
                radioSelected+="Ethernet selected, ";
                //HERE WE CALL THE FUNCTION WHICH CALCULATE THE ALGORITHM SELECTED
            }
        }
        JOptionPane.showMessageDialog(null, radioSelected);

    }
    /*public void View() {
        setContentPane(panel1); //Panel1 contains all elements


    }*/
}
