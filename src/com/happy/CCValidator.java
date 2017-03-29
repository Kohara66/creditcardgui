package com.happy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Happy on 3/29/2017.
 * This program validate credit cards
 */
public class CCValidator extends JFrame {
    private JTextField creditCardNumberTextField;
    private JButton validateButton;
    private JButton quitButton;
    private JPanel rootPanel;
    private JLabel validMessageLabel;

    public CCValidator() {
        super("Credit Card Validator");//Calls superclass constructor and sets the title to the window
        setContentPane(rootPanel);// The frame needs to have something to display
        pack(); //This sizes the window to fit its components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); //what it sounds like
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ccNumber = creditCardNumberTextField.getText();
                boolean valid = isValidCreditCardNummberValid(ccNumber);

                if (valid) {
                    validMessageLabel.setText("Credit card number is valid");

                } else {
                    validMessageLabel.setText("credit card number is NOT valid");
                }
            }

            private boolean isValidCreditCardNummberValid(String cc) {


                if (!cc.startsWith("4") || (cc.length() != 16)) {
                    return false;
                }
                int sum = 0;
                for (int i = 0; i < 16; i++) {
                    int thisDigit = Integer.parseInt((cc.substring(i, i + 1)));
                    if (i % 2 == 1) {
                        sum = sum + thisDigit;
                    } else {
                        int doubled = thisDigit * 2;
                        if (doubled > 9) {
                            int toAdd = 1 + (doubled % 10);
                            sum = sum + toAdd;
                        } else {
                            sum = sum + (thisDigit * 2);
                        }
                    }
                }
                if (sum % 10 == 0) {
                    return true;
                }
                return false;
            }

        });


        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}