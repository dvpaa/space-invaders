package org.newdawn.spaceinvaders.configuration;

public class GameConfig {

    private String shipRef;
    private int shipPower;
    private int shipHealth;
    private int shipMagicPoint;
    private double shipMoveSpeed;
    private String shipFirstSkillRef;
    private String shipSecondSkillRef;

    private String shipShotRef;
    private double shipShotMoveSpeed;

    private String alienRef;
    private int alienHealth;
    private int alienPower;
    private int alienRow;
    private double alienMoveSpeed;

    private String alienShotRef;
    private double alienShotMoveSpeed;

    private String shipType;
    private String bossAlienRef;
    private int bossAlienHealth;
    private int bossAlienPower;
    private int bossAlienMoveSpeed;
    private String bossAlienShotRef;
    private int bossAlienShotMoveSpeed;

    public GameConfig(String shipType, int stage) {
        this.shipType = shipType;
        this.shipPower = 1;
        this.shipMagicPoint = 5;
        this.shipHealth = 3;
        this.shipMoveSpeed = 300;
        this.alienMoveSpeed = -150;
        this.alienShotRef = "sprites/alienshot.png";
        this.shipShotRef = "sprites/shot.gif";
        this.shipShotMoveSpeed = -300;
        this.shipFirstSkillRef = "sprites/shot2.png";

        switch (stage) {
            case 1:
                this.alienRef = "sprites/alien2.png";
                this.alienHealth = 2;
                this.alienPower = 1;
                this.alienRow = 3;
                this.alienShotMoveSpeed = 300;
                this.bossAlienRef = "sprites/boss1.png";
                this.bossAlienHealth = 50;
                this.bossAlienPower = 2;
                this.bossAlienMoveSpeed = -300;
                this.bossAlienShotRef = "sprites/boss2.png";
                this.bossAlienShotMoveSpeed = 500;
                break;
            case 2:
                this.alienRef = "sprites/alien3.png";
                this.alienHealth = 3;
                this.alienPower = 1;
                this.alienRow = 4;
                this.alienShotMoveSpeed = 300;
                this.bossAlienRef = "sprites/boss2.png";
                this.bossAlienHealth = 50;
                this.bossAlienPower = 2;
                this.bossAlienMoveSpeed = -300;
                this.bossAlienShotRef = "sprites/alienshot.png";
                this.bossAlienShotMoveSpeed = 500;
                break;
            case 3:
                this.alienRef = "sprites/alien4.png";
                this.alienHealth = 4;
                this.alienPower = 2;
                this.alienRow = 4;
                this.alienShotMoveSpeed = 400;
                this.bossAlienRef = "sprites/boss3.png";
                this.bossAlienHealth = 50;
                this.bossAlienPower = 2;
                this.bossAlienMoveSpeed = -400;
                this.bossAlienShotRef = "sprites/alienshot.png";
                this.bossAlienShotMoveSpeed = 600;
                break;
            case 4:
                this.alienRef = "sprites/alien5.png";
                this.alienHealth = 5;
                this.alienPower = 2;
                this.alienRow = 4;
                this.alienShotMoveSpeed = 400;
                this.bossAlienRef = "sprites/boss4.png";
                this.bossAlienHealth = 70;
                this.bossAlienPower = 2;
                this.bossAlienMoveSpeed = -400;
                this.bossAlienShotRef = "sprites/alienshot.png";
                this.bossAlienShotMoveSpeed = 600;
                break;
            case 5:
                this.alienRef = "sprites/alien5.png";
                this.alienHealth = 5;
                this.alienPower = 3;
                this.alienRow = 4;
                this.alienShotMoveSpeed = 400;
                this.bossAlienRef = "sprites/boss5.png";
                this.bossAlienHealth = 100;
                this.bossAlienPower = 3;
                this.bossAlienMoveSpeed = -500;
                this.bossAlienShotRef = "sprites/alienshot.png";
                this.bossAlienShotMoveSpeed = 600;
                break;
        }

        switch (shipType) {
            case ShipType.ATTACK_UP:
                this.shipRef = "sprites/attackUpShip.png";
                this.shipPower = shipPower + 2;
                break;
            case ShipType.DEFENCE_UP:
                this.shipRef = "sprites/defenceUpShip.png";
                this.shipHealth = shipHealth + 2;
                break;
            case ShipType.SPEED_UP:
                this.shipRef = "sprites/speedUpShip.png";
                this.shipMoveSpeed = shipMoveSpeed * 1.4;
                this.shipShotMoveSpeed = shipShotMoveSpeed * 1.4;
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

    public String getBossAlienRef() {
        return bossAlienRef;
    }

    public String getShipType() {
        return shipType;
    }

    public int getBossAlienHealth() {
        return bossAlienHealth;
    }

    public int getBossAlienMoveSpeed() {
        return bossAlienMoveSpeed;
    }

    public String getBossAlienShotRef() {
        return bossAlienShotRef;
    }

    public int getBossAlienShotMoveSpeed() {
        return bossAlienShotMoveSpeed;
    }

    public int getBossAlienPower() {
        return bossAlienPower;
    }
}
