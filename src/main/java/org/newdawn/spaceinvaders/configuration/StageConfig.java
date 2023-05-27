package org.newdawn.spaceinvaders.configuration;

public class StageConfig {
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
    private int stage;


    public StageConfig (int stage, String alienRef, int alienHealth, int alienPower, int alienRow,
                        int alienShotMoveSpeed, String bossAlienRef, int bossAlienHealth,
                        int bossAlienPower, int bossAlienMoveSpeed, String bossAlienShotRef,
                        int bossAlienShotMoveSpeed, String shipType){

//        this.shipType = shipType;
        this.shipPower = 1;
        this.shipMagicPoint = 5;
        this.shipHealth = 3;
        this.shipMoveSpeed = 300;
        this.alienMoveSpeed = -150;
        this.alienShotRef = "sprites/alienshot.png";
        this.shipShotRef = "sprites/shot.gif";
        this.shipShotMoveSpeed = -300;
        this.shipFirstSkillRef = "sprites/shot2.png";

        this.alienRef = alienRef;
        this.alienHealth = alienHealth;
        this.alienPower = alienPower;
        this.alienRow = alienRow;
        this.alienShotMoveSpeed = alienShotMoveSpeed;
        this.bossAlienRef = bossAlienRef;
        this.bossAlienHealth = bossAlienHealth;
        this.bossAlienPower = bossAlienPower;
        this.bossAlienMoveSpeed = bossAlienMoveSpeed;
        this.bossAlienShotRef = bossAlienShotRef;
        this.bossAlienShotMoveSpeed = bossAlienShotMoveSpeed;

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
                this.shipRef = "sprites/ship.gif";
                break;
        }
    }


    public int getStage() {
        return stage;
    }

    public int getAlienMoveSpeed(){
        return (int) alienMoveSpeed;
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

    public int getAlienRow() {
        System.out.println(alienRow);
        return alienRow;
    }

    public int getAlienShotMoveSpeed() {
        return (int)alienShotMoveSpeed;
    }

    public String getBossAlienRef() {
        return bossAlienRef;
    }

    public int getBossAlienHealth() {
        return bossAlienHealth;
    }

    public int getBossAlienPower() {
        return bossAlienPower;
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

    public String getShipFirstSkillRef() {
        return shipFirstSkillRef;
    }

    public String getShipType() {
        return shipType.toString();
    }
}