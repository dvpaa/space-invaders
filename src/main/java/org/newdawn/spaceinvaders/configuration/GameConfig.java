package org.newdawn.spaceinvaders.configuration;

public class GameConfig {

    private String shipRef;
    private int shipPower;
    private int shipHealth;
    private int shipMagicPoint;
    private double shipMoveSpeed;
    private double alienMoveSpeed;
    private String shipFirstSkillRef;
    private String shipSecondSkillRef;

    private String shipShotRef;
    private double shipShotMoveSpeed;

    private String alienRef;
    private int alienHealth;
    private int alienPower;
    private int alienRow;

    private String alienShotRef;
    private double alienShotMoveSpeed;

    public GameConfig(String shipType, int stage) {

        switch (stage) {
            case 1:
                this.shipPower = 1;
                this.shipMagicPoint = 5;
                this.shipHealth = 2;

                this.shipMoveSpeed = 300;
                this.alienMoveSpeed = -150;

                this.shipShotRef = "sprites/shot.gif";
                this.shipShotMoveSpeed = -300;

                this.alienRef = "sprites/alien.gif";
                this.alienHealth = 1;
                this.alienPower = 1;
                this.alienRow = 3;

                this.alienShotRef = "sprites/alienshot.png";
                this.alienShotMoveSpeed = 300;

                this.shipFirstSkillRef = "sprites/shot2.png";
                this.shipSecondSkillRef = "sprites/shot2.png";
        }

        switch (shipType) {
            case ShipType.ATTACK_UP:
                this.shipRef = "sprites/attackUpShip.png";
                this.shipPower = shipPower + 1;
                break;
            case ShipType.DEFENCE_UP:
                this.shipRef = "sprites/defenceUpShip.png";
                this.shipHealth = shipHealth + 1;
                break;
            case ShipType.SPEED_UP:
                this.shipRef = "sprites/speedUpShip.png";
                this.shipMoveSpeed = shipMoveSpeed * 1.2;
                break;
            default:
                break;
        }
    }

    public String getShipRef() {
        return shipRef;
    }

    public int getShipPower() {
        return shipPower;
    }

    public int getShipHealth() {
        return shipHealth;
    }

    public int getShipMagicPoint() {
        return shipMagicPoint;
    }

    public double getShipMoveSpeed() {
        return shipMoveSpeed;
    }

    public String getShipShotRef() {
        return shipShotRef;
    }

    public double getShipShotMoveSpeed() {
        return shipShotMoveSpeed;
    }

    public String getAlienRef() {
        return alienRef;
    }

    public int getAlienHealth() {
        return alienHealth;
    }

    public int getAlienPower() {
        return alienPower;
    }

    public String getAlienShotRef() {
        return alienShotRef;
    }

    public double getAlienShotMoveSpeed() {
        return alienShotMoveSpeed;
    }

    public String getShipFirstSkillRef() {
        return shipFirstSkillRef;
    }

    public String getShipSecondSkillRef() {
        return shipSecondSkillRef;
    }

    public double getAlienMoveSpeed() {
        return alienMoveSpeed;
    }

    public int getAlienRow() {
        return alienRow;
    }
}
