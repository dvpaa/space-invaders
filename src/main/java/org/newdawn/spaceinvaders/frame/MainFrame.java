package org.newdawn.spaceinvaders.frame;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.GameConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    private MainFrame frame = this;

    private JLabel background;
    private ImageIcon quickButtonBasic = new ImageIcon("src/main/resources/button/quickButtonBasic.png");
    private ImageIcon quickButtonEntered = new ImageIcon("src/main/resources/button/quickButtonEntered.png");
    private JButton startButton;
    private JButton quickButton;
    private JButton shopButton;
    private JButton rankingButton;

    private JButton firstStageButton;
    private JButton secondStageButton;
    private JButton thirdStageButton;
    private JButton forthStageButton;
    private JButton fifthStageButton;

    public MainFrame() {
        initSetting();
        objectSetting();
        listenerSetting();
    }

    private void initSetting() {
        setTitle("Space Invaders 102");
        setSize(800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void objectSetting() {
        background = new JLabel(new ImageIcon("src/main/resources/background/introBackground.jpg"));
        setContentPane(background);

        rankingButton = new JButton("Ranking");
        rankingButton.setBounds(230, 420, 100, 50);
        rankingButton.setPreferredSize(new Dimension(100, 50));
        add(rankingButton);

        shopButton = new JButton("Shop");
        shopButton.setBounds(350, 420, 100, 50);
        shopButton.setPreferredSize(new Dimension(100, 50));
        add(shopButton);

        quickButton = new JButton("Exit");
        quickButton.setBounds(470, 420, 100, 50);
        quickButton.setPreferredSize(new Dimension(100, 50));
        add(quickButton);

        firstStageButton = new JButton("Stage 1");
        firstStageButton.setBounds(110, 350, 100, 50);
        firstStageButton.setPreferredSize(new Dimension(110, 50));
        add(firstStageButton);

        secondStageButton = new JButton("Stage 2");
        secondStageButton.setBounds(230, 350, 100, 50);
        secondStageButton.setPreferredSize(new Dimension(100, 50));
        add(secondStageButton);

        thirdStageButton = new JButton("Stage 3");
        thirdStageButton.setBounds(350, 350, 100, 50);
        thirdStageButton.setPreferredSize(new Dimension(100, 50));
        add(thirdStageButton);

        forthStageButton = new JButton("Stage 4");
        forthStageButton.setBounds(470, 350, 100, 50);
        forthStageButton.setPreferredSize(new Dimension(100, 50));
        add(forthStageButton);

        fifthStageButton = new JButton("Stage 5");
        fifthStageButton.setBounds(590, 350, 100, 50);
        fifthStageButton.setPreferredSize(new Dimension(100, 50));
        add(fifthStageButton);

        setVisible(true);
    }

    private void listenerSetting() {

        shopButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                new ShopFrame();
            }
        });

        quickButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

        firstStageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        setVisible(false);
                        Game game = new Game(frame, new GameConfig(1));
                        game.gameLoop();
                    }
                });
                thread.start();
            }
        });
    }

}