package org.newdawn.spaceinvaders.frame;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.configuration.GameConfig;
import org.newdawn.spaceinvaders.configuration.ShipType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private JFrame mainFrame = this;

    private JLabel background;
    private JLabel introBackgroundLabel = new JLabel(new ImageIcon("src/main/resources/background/introBackground.jpg"));
    private JButton quickButton;
    private JButton shopButton;
    private JButton rankingButton;

    private JButton firstStageButton;
    private JButton secondStageButton;
    private JButton thirdStageButton;
    private JButton forthStageButton;
    private JButton fifthStageButton;
    private JButton attackUpShipButton;
    private JButton speedUpShipButton;
    private JButton defenceUpShipButton;
    private String shipType;
    private int stage;
    private ArrayList<JButton> mainButtons = new ArrayList<>();
    private ArrayList<JButton> shipSelectButtons = new ArrayList<>();

    private int point = 0;

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
        background = introBackgroundLabel;
        setContentPane(background);

        rankingButton = new JButton("Ranking");
        rankingButton.setBounds(230, 420, 100, 50);
        rankingButton.setPreferredSize(new Dimension(100, 50));
        mainButtons.add(rankingButton);
        add(rankingButton);

        shopButton = new JButton("Shop");
        shopButton.setBounds(350, 420, 100, 50);
        shopButton.setPreferredSize(new Dimension(100, 50));
        mainButtons.add(shopButton);
        add(shopButton);

        quickButton = new JButton("Exit");
        quickButton.setBounds(470, 420, 100, 50);
        quickButton.setPreferredSize(new Dimension(100, 50));
        mainButtons.add(quickButton);
        add(quickButton);

        firstStageButton = new JButton("Stage 1");
        firstStageButton.setBounds(110, 350, 100, 50);
        firstStageButton.setPreferredSize(new Dimension(110, 50));
        mainButtons.add(firstStageButton);
        add(firstStageButton);

        secondStageButton = new JButton("Stage 2");
        secondStageButton.setBounds(230, 350, 100, 50);
        secondStageButton.setPreferredSize(new Dimension(100, 50));
        mainButtons.add(secondStageButton);
        add(secondStageButton);

        thirdStageButton = new JButton("Stage 3");
        thirdStageButton.setBounds(350, 350, 100, 50);
        thirdStageButton.setPreferredSize(new Dimension(100, 50));
        mainButtons.add(thirdStageButton);
        add(thirdStageButton);

        forthStageButton = new JButton("Stage 4");
        forthStageButton.setBounds(470, 350, 100, 50);
        forthStageButton.setPreferredSize(new Dimension(100, 50));
        mainButtons.add(forthStageButton);
        add(forthStageButton);

        fifthStageButton = new JButton("Stage 5");
        fifthStageButton.setBounds(590, 350, 100, 50);
        fifthStageButton.setPreferredSize(new Dimension(100, 50));
        mainButtons.add(fifthStageButton);
        add(fifthStageButton);

        attackUpShipButton = new JButton("Attack Up");
        attackUpShipButton.setBounds(230, 300, 100, 50);
        attackUpShipButton.setPreferredSize(new Dimension(100, 50));
        add(attackUpShipButton);

        speedUpShipButton = new JButton("Speed Up");
        speedUpShipButton.setBounds(350, 300, 100, 50);
        speedUpShipButton.setPreferredSize(new Dimension(100, 50));
        add(speedUpShipButton);

        defenceUpShipButton = new JButton("Defence Up");
        defenceUpShipButton.setBounds(470, 300, 100, 50);
        defenceUpShipButton.setPreferredSize(new Dimension(100, 50));
        add(defenceUpShipButton);

        attackUpShipButton.setVisible(false);
        speedUpShipButton.setVisible(false);
        defenceUpShipButton.setVisible(false);

        shipSelectButtons.add(attackUpShipButton);
        shipSelectButtons.add(speedUpShipButton);
        shipSelectButtons.add(defenceUpShipButton);

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
                setMainButtonsInvisible();
                stage = 1;
            }
        });

        secondStageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setMainButtonsInvisible();
                stage = 2;
            }
        });

        thirdStageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setMainButtonsInvisible();
                stage = 3;
            }
        });

        forthStageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setMainButtonsInvisible();
                stage = 4;
            }
        });

        fifthStageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setMainButtonsInvisible();
                stage = 5;
            }
        });

        attackUpShipButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setMainButtonsVisible();
                gameThreadStart(ShipType.ATTACK_UP, stage);
            }
        });

        speedUpShipButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setMainButtonsVisible();
                gameThreadStart(ShipType.SPEED_UP, stage);
            }
        });

        defenceUpShipButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setMainButtonsVisible();
                gameThreadStart(ShipType.DEFENCE_UP, stage);
            }
        });

        shopButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ShopFrame(mainFrame, point);
                setVisible(false);
            }
        });
    }

    private void gameThreadStart(String shipType, int stage) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                setVisible(false);
                Game game = new Game(mainFrame, new GameConfig(shipType, stage));
                game.gameLoop();
            }
        });
        thread.start();
    }

    private void setMainButtonsInvisible() {
        for (JButton mainButton : mainButtons) {
            mainButton.setVisible(false);
        }
        for (JButton shipSelectButton : shipSelectButtons) {
            shipSelectButton.setVisible(true);
        }
    }

    private void setMainButtonsVisible() {
        for (JButton mainButton : mainButtons) {
            mainButton.setVisible(true);
        }
        for (JButton shipSelectButton : shipSelectButtons) {
            shipSelectButton.setVisible(false);
        }
    }

    public void increasePoint(int score) {
        this.point += score;
    }
}
