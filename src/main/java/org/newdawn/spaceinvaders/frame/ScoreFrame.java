package org.newdawn.spaceinvaders.frame;

import javax.swing.*;

public class ScoreFrame extends JFrame {
    public ScoreFrame(float score) {
        setTitle("Score");
        setSize(300, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel label = new JLabel("You win! Score: " + score);
        label.setBounds(70, 20, 300, 200);
        add(label);
        label.setVisible(true);
        setVisible(true);

    }
}