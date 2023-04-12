package org.newdawn.spaceinvaders.frame;

import javax.swing.*;

import static org.newdawn.spaceinvaders.frame.ScreenSize.SCREEN_HEIGHT;
import static org.newdawn.spaceinvaders.frame.ScreenSize.SCREEN_WIDTH;

public class GameFrame extends JFrame {

    private GameFrame gameFrame = this;
    public boolean isGame;
//    public MainPanel mainFrame;
    public GmaePanel gamePanel;

    public GameFrame() {
        init();
        setting();
//        listener();

        setVisible(true);
    }

    public void init() {
        change(PanelName.MAIN_PAGE);
        isGame = false;
    }

    public void setting() {
        setTitle(PanelName.GAME_TITLE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void change(String panelName) {
        if (panelName.equals(PanelName.MAIN_PAGE)) {
//            mainFrame = new MainPanel(gameFrame);
            getContentPane().removeAll();
//            getContentPane().add(mainFrame);
            revalidate();
            repaint();
        } else if (panelName.equals(PanelName.FIRST_STAGE)) {
            gamePanel = new GmaePanel(gameFrame);
            getContentPane().removeAll();
            getContentPane().add(gamePanel);
            revalidate();
            repaint();
        }
    }

    private void listener() {
    }
}
