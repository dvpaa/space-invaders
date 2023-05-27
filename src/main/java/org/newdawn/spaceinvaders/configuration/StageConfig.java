package org.newdawn.spaceinvaders.configuration;

public class StageConfig {
//    private String shipRef;
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
    private int stage=0;

    public StageConfig (int stage, String alienRef, int alienHealth, int alienPower, int alienRow,
                        int alienShotMoveSpeed, String bossAlienRef, int bossAlienHealth,
                        int bossAlienPower, int bossAlienMoveSpeed, String bossAlienShotRef,
                        int bossAlienShotMoveSpeed){

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
}

/*
public enum StageConfig {
    STAGE1(1,"sprites/alien2.png",2, 1, 3, 300, "sprites/boss1.png", 50, 2, -300, "sprites/boss2.png", 500),
    STAGE2(2, "sprites/alien3.png", 3,1,4,300,"sprites/boss2.png",50,2,-300,"sprites/alienshot.png",500),
    STAGE3(3,"sprites/alien4.png",4,2,4,400,"sprites/boss3.png",50,2,-400,"sprites/alienshot.png",600);

    // 변수선언
    private int stage;
    private String alienRef;
    private int alienHealth;
    private int alienPower;
    private int alienRow;
    private int alienShotMoveSpeed;
    private String bossAlienRef;
    private int bossAlienHealth;
    private int bossAlienPower;
    private int bossAlienMoveSpeed;
    private String bossAlienShotRef;
    private int bossAlienShotMoveSpeed;
    private int stageCount=0; // static

    // 생성자
    StageConfig(int stage, String alienRef, int alienHealth, int alienPower, int alienRow,
                int alienShotMoveSpeed, String bossAlienRef, int bossAlienHealth,
                int bossAlienPower, int bossAlienMoveSpeed, String bossAlienShotRef,
                int bossAlienShotMoveSpeed) {
        this.stage = stage;
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
    }

    // getter
    public int getStage() {
        return stage;
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
        return alienRow;
    }

    public int getAlienShotMoveSpeed() {
        return alienShotMoveSpeed;
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

    public int numberOfStage(){
        for(StageConfig type : StageConfig.values()){
            stageCount++;
            return stageCount;
        }
    }
}
*/