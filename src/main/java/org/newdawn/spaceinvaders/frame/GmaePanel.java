package org.newdawn.spaceinvaders.frame;

import javax.swing.*;
import java.awt.*;

public class GmaePanel extends JPanel {
    private GmaePanel gmaePanel = this;
    private GameFrame gameFrame;
    private ImageIcon backgroundIcon = new ImageIcon("src/main/resources/background/gameBackground.jpg");
    private Image backgroundImg = backgroundIcon.getImage();

    public GmaePanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImg, 0, 0, null);
        repaint();

    }
}
