package org.newdawn.spaceinvaders;

import org.newdawn.spaceinvaders.configuration.GameConfig;
import org.newdawn.spaceinvaders.entity.AlienEntity;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;
import org.newdawn.spaceinvaders.frame.MainFrame;
import org.newdawn.spaceinvaders.frame.ScoreFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;


public class GameGUI extends Canvas {

    /**
     * The stragey that allows us to use accelerate page flipping
     */
    private BufferStrategy strategy;
    /** The normal title of the game window */
    private String windowTitle = "Space Invaders 102";
    /** The game window that we'll update with the frame count */
    private JFrame container;
    private JFrame frame;
    private JButton mainButton;
    private JLabel timerlabel;
    private JLabel bossHealthLabel;
    private JLabel shipHealthLabel;
    private JLabel shipPowerLabel;
    private JLabel shipMoveSpeedLabel;
    private JPanel panel;
    private GameTimer gameTimer = GameTimer.getInstance();
    private GameConfig gameConfig;
    private Graphics2D g;
    private JLabel skillLabel;
    private JLabel magicPointLabel;

    public GameGUI(JFrame frame, GameConfig gameConfig) {
        this.frame = frame;
        this.gameConfig = gameConfig;

        // create a frame to contain our game
        container = new JFrame("Space Invaders 102");
        panel = (JPanel) container.getContentPane();
        panel.setPreferredSize(new Dimension(GameConfig.FRAME_WIDTH, GameConfig.FRAME_HEIGHT));
        panel.setLayout(null);

        mainButton = new JButton("M");
        mainButton.setBounds(750 , 550, 30, 30);

        mainButton.addActionListener((e)->{
            container.setVisible(false);
            frame.setVisible(true);
        });
        panel.add(mainButton);
        mainButton.setVisible(true);

        timerlabel = gameTimer.getTimerLabel(); // 타이머 라벨 추가 add GameTimer by Eungyu
        timerlabel.setBounds(740, 0, GameConfig.TIMER_LABEL_WIDTH, GameConfig.LABEL_HEIGHT); // 타이머 크기, 위치 지정 add GameTimer by Eungyu
        timerlabel.setOpaque(true); // 라벨 배경 색깔 적용 add GameTimer by Eungyu
        timerlabel.setBackground(Color.black); // 뒷배경 검은색 설정 add GameTimer by Eungyu
        timerlabel.setForeground(Color.white); // 글씨 하얀색 설정 add GameTimer by Eungyu
        panel.add(timerlabel); // 패널에 타이머 라벨 추가 add GameTimer by Eungyu

        bossHealthLabel = new JLabel();
        bossHealthLabel.setBounds(350, 0, GameConfig.LABEL_WIDTH, GameConfig.LABEL_HEIGHT);
        bossHealthLabel.setOpaque(true);
        bossHealthLabel.setBackground(Color.black);
        bossHealthLabel.setForeground(Color.white);
        this.panel.add(bossHealthLabel);

        shipHealthLabel = new JLabel();
        shipHealthLabel.setBounds(10, 475, GameConfig.LABEL_WIDTH, GameConfig.LABEL_HEIGHT);
        shipHealthLabel.setOpaque(true);
        shipHealthLabel.setBackground(Color.black);
        shipHealthLabel.setForeground(Color.white);
        this.panel.add(shipHealthLabel);

        shipPowerLabel = new JLabel();
        shipPowerLabel.setBounds(10, 500, GameConfig.LABEL_WIDTH, GameConfig.LABEL_HEIGHT);
        shipPowerLabel.setOpaque(true);
        shipPowerLabel.setBackground(Color.black);
        shipPowerLabel.setForeground(Color.white);
        this.panel.add(shipPowerLabel);

        shipMoveSpeedLabel = new JLabel();
        shipMoveSpeedLabel.setBounds(10, 525, GameConfig.LABEL_WIDTH, GameConfig.LABEL_HEIGHT);
        shipMoveSpeedLabel.setOpaque(true);
        shipMoveSpeedLabel.setBackground(Color.black);
        shipMoveSpeedLabel.setForeground(Color.white);
        this.panel.add(shipMoveSpeedLabel);

        if(gameConfig.getShipType()!="DEFAULT"){
            magicPointLabel = new JLabel();
            magicPointLabel.setBounds(10, 550, GameConfig.LABEL_WIDTH, GameConfig.LABEL_HEIGHT);
            magicPointLabel.setOpaque(true);
            magicPointLabel.setBackground(Color.black);
            magicPointLabel.setForeground(Color.white);
            this.panel.add(magicPointLabel);
        }

        skillLabel = new JLabel();
        skillLabel.setBounds(0, 0, 100, 40);
        skillLabel.setOpaque(true);
        skillLabel.setBackground(Color.black);
        skillLabel.setForeground(Color.white);
        this.panel.add(skillLabel);


        // setup our canvas size and put it into the content of the frame
        setBounds(0, 0, GameConfig.FRAME_WIDTH, GameConfig.FRAME_HEIGHT);
        panel.add(this);
        // Tell AWT not to bother repainting our canvas since we're
        // going to do that our self in accelerated mode
        setIgnoreRepaint(true);

        // finally make the window visible
        container.pack();
        container.setLocationRelativeTo(null);
        container.setResizable(false);
        container.setVisible(true);

        // add a listener to respond to the user closing the window. If they
        // do we'd like to exit the game
        container.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // create the buffering strategy which will allow AWT
        // to manage our accelerated graphics
        createBufferStrategy(2);
        strategy = getBufferStrategy();
    }

    public void win() {
        int bestScore = Math.max(((MainFrame)this.frame).bestScore[gameConfig.getStage() - 1],
            (int)gameTimer.getScore());
        ((MainFrame)this.frame).bestScore[gameConfig.getStage() - 1] = bestScore;
        ((MainFrame)this.frame).setMainButtonsVisible();

        this.container.setVisible(false);
        this.frame.setVisible(true);
        ((MainFrame)this.frame).increasePoint((int)gameTimer.getScore());
        new ScoreFrame(gameTimer.getScore());
    }

    public void setTitie(int fps) {
        container.setTitle(windowTitle + " (FPS: " + fps + ")");
    }

    public void makeGraphics() {
        g = (Graphics2D) strategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, GameConfig.FRAME_WIDTH, GameConfig.FRAME_HEIGHT);
    }

    public void drawEntity(ArrayList<Entity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = (Entity) entities.get(i);
            entity.draw(g);
        }
    }

    public void drawInitialMessage(String message) {
        g.setColor(Color.white);
        g.drawString(message, (GameConfig.FRAME_WIDTH - g.getFontMetrics().stringWidth(message)) / 2, 250);
        g.drawString("Press any key", (GameConfig.FRAME_WIDTH - g.getFontMetrics().stringWidth("Press any key")) / 2, 300);
    }

    public void clearGraphics() {
        g.dispose();
        strategy.show();
    }

    public void setBossHealthText(Entity bossAlien) {
        bossHealthLabel.setText("Boss HP: " + ((AlienEntity)bossAlien).getHealth());
    }

    public void setShipInfoText(Entity ship) {
        shipHealthLabel.setText("Health: " + ((ShipEntity)ship).getHealth());
        shipPowerLabel.setText("Power: " + ((ShipEntity)ship).getPower());
        shipMoveSpeedLabel.setText("Speed: " + ((ShipEntity)ship).getHorizontalMovement());
        magicPointLabel.setText("MagicPoint "+"|".repeat(((ShipEntity)ship).getMagicPoint()));
    }

    public void setSkillText(long interval, long elapsedTime) {
        long cooldown = (interval - elapsedTime);
        if(cooldown>0){
            skillLabel.setText("Skill: " + cooldown / 1000);
        }
        else {
            skillLabel.setText("Skill is Ready!");
        }
    }

}