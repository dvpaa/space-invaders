package org.newdawn.spaceinvaders.frame;

import org.newdawn.spaceinvaders.configuration.ShipType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShopFrame extends JFrame {

    private JLabel background;
    private JButton attackUpSpace;
    private JButton speedUpSpace;
    private JButton defenceUpSpace;
    private JButton buyButton;
    private String shipType;
    private JFrame prevFrame;
    private JFrame currentFrame = this;
    private JLabel pointLabel;
    private boolean state;

    public ShopFrame(JFrame frame) {
        this.prevFrame = frame;
        initSetting();
        objectSetting();
        listenerSetting();
    }

    private void initSetting() {
        setTitle("Shop");
        setSize(800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        background = new JLabel(new ImageIcon("src/main/resources/background/mainBackground.jpg"));
        setContentPane(background);
    }

    private void objectSetting() {
        pointLabel = new JLabel("Point: " + ((MainFrame) prevFrame).getPoint());
        pointLabel.setBounds(10, 150, 150, 50);
        add(pointLabel);
        pointLabel.setVisible(true);

        attackUpSpace = new JButton("attack up: " + ShipType.ATTACK_UP_PRICE);
        attackUpSpace.setBounds(125, 275, 150, 50);
        attackUpSpace.setPreferredSize(new Dimension(150, 50));
        add(attackUpSpace);
        attackUpSpace.setVisible(true);

        speedUpSpace = new JButton("speed up: " + ShipType.SPEED_UP_PRICE);
        speedUpSpace.setBounds(325, 275, 150, 50);
        speedUpSpace.setPreferredSize(new Dimension(150, 50));
        add(speedUpSpace);
        speedUpSpace.setVisible(true);

        defenceUpSpace = new JButton("defecne up: " + ShipType.DEFENCE_UP_PRICE);
        defenceUpSpace.setBounds(525, 275, 150, 50);
        defenceUpSpace.setPreferredSize(new Dimension(150, 50));
        add(defenceUpSpace);
        defenceUpSpace.setVisible(true);

        buyButton = new JButton("구매");
        buyButton.setBounds(350, 375, 100, 50);
        buyButton.setPreferredSize(new Dimension(100, 50));
        add(buyButton);
        buyButton.setVisible(true);
    }

    private void listenerSetting() {

        attackUpSpace.addActionListener((e)->{
            shipType = ShipType.ATTACK_UP;
        });

        speedUpSpace.addActionListener((e)->{
            shipType = ShipType.SPEED_UP;
        });

        defenceUpSpace.addActionListener((e)->{
            shipType = ShipType.DEFENCE_UP;
        });

        buyButton.addActionListener((e)->{
            switch (shipType) {
                case ShipType.ATTACK_UP:
                    if (((MainFrame) prevFrame).getPoint() >= ShipType.ATTACK_UP_PRICE) {
                        ((MainFrame) prevFrame).decreasePoint(ShipType.ATTACK_UP_PRICE);
                        ((MainFrame) prevFrame).setAttackUpship(true);
                        state = true;
                    } else {
                        state = false;
                    }
                    break;
                case ShipType.SPEED_UP:
                    if (((MainFrame) prevFrame).getPoint() >= ShipType.SPEED_UP_PRICE) {
                        ((MainFrame) prevFrame).decreasePoint(ShipType.SPEED_UP_PRICE);
                        ((MainFrame) prevFrame).setSpeedUpShip(true);
                        state = true;
                    } else {
                        state = false;
                    }
                    break;
                case ShipType.DEFENCE_UP:
                    if (((MainFrame) prevFrame).getPoint() >= ShipType.DEFENCE_UP_PRICE) {
                        ((MainFrame) prevFrame).decreasePoint(ShipType.DEFENCE_UP_PRICE);
                        ((MainFrame) prevFrame).setDefenceUpShip(true);
                        state = true;
                    } else {
                        state = false;
                    }
                    break;
            }
            currentFrame.setVisible(false);
            prevFrame.setVisible(true);
            new BuyFrame(state);
        });
    }
}
