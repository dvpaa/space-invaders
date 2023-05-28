package org.newdawn.spaceinvaders.frame;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.ImageUtil;
import org.newdawn.spaceinvaders.configuration.GameConfig;
import org.newdawn.spaceinvaders.configuration.GameMusicPlayer;
import org.newdawn.spaceinvaders.configuration.ShipType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private JFrame mainFrame = this;
    private JLabel background;
    private JLabel introBackgroundLabel;
    private JButton quickButton;
    private JButton shopButton;
    private JButton rankingButton;
    private JButton firstStageButton;
    private JButton secondStageButton;
    private JButton thirdStageButton;
    private JButton forthStageButton;
    private JButton fifthStageButton;
    private JButton defaultShipButton;
    private JButton attackUpShipButton;
    private JButton speedUpShipButton;
    private JButton defenceUpShipButton;
    private boolean attackUpship = false;
    private boolean speedUpShip = false;
    private boolean defenceUpShip = false;
    private int stage;
    public int[] bestScore = new int[5];
    private ArrayList<JButton> mainButtons = new ArrayList<>();
    private ArrayList<JButton> shipSelectButtons = new ArrayList<>();
    private JButton[] stageButtons = new JButton[5];
    private int point = GameConfig.defaultPoint;
    private GameMusicPlayer gameMusicPlayer = new GameMusicPlayer("MainBgm");

    public void setAttackUpship(boolean attackUpship) {
        this.attackUpship = attackUpship;
    }

    public void setSpeedUpShip(boolean speedUpShip) {
        this.speedUpShip = speedUpShip;
    }

    public void setDefenceUpShip(boolean defenceUpShip) {
        this.defenceUpShip = defenceUpShip;
    }

    public int getPoint() {
        return point;
    }

    public MainFrame() {
        gameMusicPlayer.play();
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
        introBackgroundLabel = new JLabel(
            new ImageIcon(ImageUtil.getImage(this.getClass(), "background/introBackground.jpg")));
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

        firstStageButton = new JButton("<html>Stage 1" + "<br>Best Score: " + bestScore[0] + "</html>");
        firstStageButton.setBounds(30, 350, 140, 50);
        firstStageButton.setPreferredSize(new Dimension(140, 50));
        stageButtons[0] = firstStageButton;
        add(firstStageButton);

        secondStageButton = new JButton("<html>Stage 2" + "<br>Best Score: " + bestScore[1] + "</html>");
        secondStageButton.setBounds(180, 350, 140, 50);
        secondStageButton.setPreferredSize(new Dimension(140, 50));
        stageButtons[1] = secondStageButton;
        add(secondStageButton);

        thirdStageButton = new JButton("<html>Stage 3" + "<br>Best Score: " + bestScore[2] + "</html>");
        thirdStageButton.setBounds(330, 350, 140, 50);
        thirdStageButton.setPreferredSize(new Dimension(140, 50));
        stageButtons[2] = thirdStageButton;
        add(thirdStageButton);

        forthStageButton = new JButton("<html>Stage 4" + "<br>Best Score: " + bestScore[3] + "</html>");
        forthStageButton.setBounds(480, 350, 140, 50);
        forthStageButton.setPreferredSize(new Dimension(140, 50));
        stageButtons[3] = forthStageButton;
        add(forthStageButton);

        fifthStageButton = new JButton("<html>Stage 5" + "<br>Best Score: " + bestScore[4] + "</html>");
        fifthStageButton.setBounds(630, 350, 140, 50);
        fifthStageButton.setPreferredSize(new Dimension(140, 50));
        stageButtons[4] = fifthStageButton;
        add(fifthStageButton);

        defaultShipButton = new JButton("Default");
        defaultShipButton.setBounds(350, 300, 100, 50);
        defaultShipButton.setPreferredSize(new Dimension(100, 50));
        add(defaultShipButton);

        attackUpShipButton = new JButton("Attack Up");
        attackUpShipButton.setBounds(230, 400, 100, 50);
        attackUpShipButton.setPreferredSize(new Dimension(100, 50));
        add(attackUpShipButton);

        speedUpShipButton = new JButton("Speed Up");
        speedUpShipButton.setBounds(350, 400, 100, 50);
        speedUpShipButton.setPreferredSize(new Dimension(100, 50));
        add(speedUpShipButton);

        defenceUpShipButton = new JButton("Defence Up");
        defenceUpShipButton.setBounds(470, 400, 100, 50);
        defenceUpShipButton.setPreferredSize(new Dimension(100, 50));
        add(defenceUpShipButton);

        defaultShipButton.setVisible(false);
        attackUpShipButton.setVisible(false);
        speedUpShipButton.setVisible(false);
        defenceUpShipButton.setVisible(false);

        shipSelectButtons.add(defaultShipButton);
        shipSelectButtons.add(attackUpShipButton);
        shipSelectButtons.add(speedUpShipButton);
        shipSelectButtons.add(defenceUpShipButton);

        setVisible(true);
    }

    private void listenerSetting() {

        shopButton.addActionListener((e)->{

        });

        quickButton.addActionListener((e)->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        });


        firstStageButton.addActionListener((e)->{
            setMainButtonsInvisible();
            stage = 1;
        });

        secondStageButton.addActionListener((e)->{
            setMainButtonsInvisible();
            stage = 2;
        });

        thirdStageButton.addActionListener((e)->{
            setMainButtonsInvisible();
            stage = 3;
        });

        forthStageButton.addActionListener((e)->{
            setMainButtonsInvisible();
            stage = 4;
        });

        fifthStageButton.addActionListener((e)->{
            setMainButtonsInvisible();
            stage = 5;
        });

        defaultShipButton.addActionListener((e)->{
            gameThreadStart("DEFAULT", stage);
        });

        attackUpShipButton.addActionListener((e)->{
            gameThreadStart("ATTACK_UP", stage);
        });

        speedUpShipButton.addActionListener((e)->{
            gameThreadStart("SPEED_UP", stage);
        });

        defenceUpShipButton.addActionListener((e)->{
            gameThreadStart("DEFENCE_UP", stage);
        });

        shopButton.addActionListener((e)->{
            new ShopFrame(mainFrame);
            setVisible(false);
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
        for (JButton stageButton : stageButtons) {
            stageButton.setVisible(false);
        }
        defaultShipButton.setVisible(true);
        if (attackUpship) {
            attackUpShipButton.setVisible(true);
        }
        if (speedUpShip) {
            speedUpShipButton.setVisible(true);
        }
        if (defenceUpShip) {
            defenceUpShipButton.setVisible(true);
        }
    }

    public void setMainButtonsVisible() {
        for (JButton mainButton : mainButtons) {
            mainButton.setVisible(true);
        }
        for (int i = 0; i < stageButtons.length; i++) {
            stageButtons[i].setVisible(true);
            stageButtons[i].setText("<html>Stage " + (i+1) + "<br>Best Score: " + bestScore[i] + "</html>");
        }
        for (JButton shipSelectButton : shipSelectButtons) {
            shipSelectButton.setVisible(false);
        }
    }

    public void increasePoint(int score) {
        this.point += score;
    }

    public void decreasePoint(int point) {
        this.point -= point;
    }
}
