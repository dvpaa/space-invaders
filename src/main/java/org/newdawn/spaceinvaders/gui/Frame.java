package org.newdawn.spaceinvaders.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground = new ImageIcon("src/main/resources/background/introBackground.jpg").getImage();
    private ImageIcon startButtonBasicImage = new ImageIcon("src/main/resources/button/startButtonBasic.png");
    private ImageIcon startButtonEnteredImage = new ImageIcon("src/main/resources/button/startButtonEntered.png");

    private JButton startButton = new JButton(startButtonBasicImage);

    public Frame() {
        setTitle("Space Invader");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.setBounds(0, 0, 230, 80);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // 게임 시작
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        add(startButton);
    }

    public void paint(Graphics g) {
        screenImage = createImage(800, 600);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    private void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);
        paintComponents(g);
        this.repaint();
    }

}
