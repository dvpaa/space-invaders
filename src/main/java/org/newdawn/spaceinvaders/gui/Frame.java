package org.newdawn.spaceinvaders.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {

    private JLabel background;
    private ImageIcon startButtonBasic = new ImageIcon("src/main/resources/button/startButtonBasic.png");
    private ImageIcon startButtonEntered = new ImageIcon("src/main/resources/button/startButtonEntered.png");
    private ImageIcon quickButtonBasic = new ImageIcon("src/main/resources/button/quickButtonBasic.png");
    private ImageIcon quickButtonEntered = new ImageIcon("src/main/resources/button/quickButtonEntered.png");
    private JButton startButton;
    private JButton quickButton;

    public Frame() {
        initSetting();
        objectSetting();
        listenerSetting();
    }

    private void listenerSetting() {
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // game start
                startButton.setVisible(false);
                quickButton.setVisible(false);
                background.setIcon(new ImageIcon("src/main/resources/background/gameBackground.jpg"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEntered);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonBasic);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        quickButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // game start
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                quickButton.setIcon(quickButtonEntered);
                quickButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                quickButton.setIcon(quickButtonBasic);
                quickButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    private void objectSetting() {
        background = new JLabel(new ImageIcon("src/main/resources/background/introBackground.jpg"));
        setContentPane(background);

        startButton = new JButton(startButtonBasic);
        startButton.setBounds(0, 0, 180, 50);
        startButton.setPreferredSize(new Dimension(180, 50));
        add(startButton);

        quickButton = new JButton(quickButtonBasic);
        quickButton.setBounds(0, 100, 180, 50);
        quickButton.setPreferredSize(new Dimension(180, 50));
        add(quickButton);
        setVisible(true);


    }

    private void initSetting() {
        setTitle("Space Invader");
        setSize(800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
