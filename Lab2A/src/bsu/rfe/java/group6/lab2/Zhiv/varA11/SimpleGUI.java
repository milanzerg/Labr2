package bsu.rfe.java.group6.lab2.Zhiv.varA11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {

    private final JButton button = new JButton("Calculate");
    private final JButton buttonMC = new JButton("MC");
    private final JButton buttonMPlus = new JButton("M+");
    private final JTextField inputX = new JTextField("",1);
    private final JTextField inputY = new JTextField("",1);
    private final JTextField inputZ = new JTextField("",1);
    private final JRadioButton radio1 = new JRadioButton("Formula №1");

    eHandler handler = new eHandler();

    public SimpleGUI(){
        super("Lab 2A");
        this.setBounds(100, 100, 250, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6,2,2,2));

        JLabel labelX = new JLabel(" x");
        labelX.setHorizontalAlignment(JLabel.RIGHT);
        container.add(labelX);
        container.add(inputX);
        JLabel labelY = new JLabel(" y");
        labelY.setHorizontalAlignment(JLabel.RIGHT);
        container.add(labelY);
        container.add(inputY);
        JLabel labelZ = new JLabel(" z");
        labelZ.setHorizontalAlignment(JLabel.RIGHT);
        container.add(labelZ);
        container.add(inputZ);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        JRadioButton radio2 = new JRadioButton("Formula №2");
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);

        container.add(buttonMC);
        container.add(buttonMPlus);
        container.add(button);

        buttonMC.addActionListener(handler);
        buttonMPlus.addActionListener(handler);
        button.addActionListener(handler);
    }

    public class eHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button){
                double result1, result2;
                String message = "";
                message += "x = " + inputX.getText() + "  ";
                message += "y =  " + inputY.getText() + "  ";
                message += "z = " + inputZ.getText() + "\n";
                Formula.numerator1 = Math.pow(Math.log(Math.pow(Double.parseDouble(inputZ.getText()+1), 2)) + Math.cos(Math.PI * Math.pow(Double.parseDouble(inputY.getText()),3)),1/4);
                Formula.denominator1 = Math.pow((Math.cos(Math.exp(Double.parseDouble(inputX.getText()))) + Math.sqrt(1/Double.parseDouble(inputX.getText())) + Math.exp(Math.pow(Double.parseDouble(inputY.getText()),2))),Math.sin(Double.parseDouble(inputX.getText())));
                Formula.numerator2 = Math.pow(Math.sin(Math.pow(Double.parseDouble(inputZ.getText()),Double.parseDouble(inputY.getText()))),2);
                Formula.denominator2 = Math.sqrt(1 + Math.pow(Double.parseDouble(inputX.getText()),3));
                result1 =  Formula.numerator1 /  Formula.denominator1;
                result2 =  Formula.numerator2 /  Formula.denominator2;
                if (radio1.isSelected()){
                    Formula.result = result1;
                    message += "f1(x,y,z) = " + result1 + "\n";
                } else {
                    message += "f2(x,y,z) = " + result2 + "\n";
                }
                message += "M+: " + Formula.sum + "\n";
                JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
            }
            if (e.getSource() == buttonMC){
                Formula.sum = 0;
            }
            if (e.getSource() == buttonMPlus){
                Formula.sum += Formula.result;
            }
        }
    }
}