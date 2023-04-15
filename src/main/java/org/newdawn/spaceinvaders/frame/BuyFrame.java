package org.newdawn.spaceinvaders.frame;

import javax.swing.*;

public class BuyFrame extends JFrame {
    private String message;
    public BuyFrame(boolean state) {
        setTitle("Buy");
        setSize(150, 150);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        if (state) {
            message = "Success!";
        } else {
            message = "Fail!";
        }
        JLabel label = new JLabel(message);
        label.setBounds(60, 50, 50, 50);
        add(label);
        label.setVisible(true);
        setVisible(true);
    }
}
