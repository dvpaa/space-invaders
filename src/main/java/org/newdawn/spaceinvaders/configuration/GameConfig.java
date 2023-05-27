package org.newdawn.spaceinvaders.configuration;

import java.util.ArrayList;
import java.util.List;

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

//    private String alienRef;
//    private int alienHealth;
//    private int alienPower;
//    private int alienRow;
//    private double alienMoveSpeed;
//    private String alienShotRef;
//    private double alienShotMoveSpeed;
//    private String shipType;
//    private String bossAlienRef;
//    private int bossAlienHealth;
//    private int bossAlienPower;
//    private int bossAlienMoveSpeed;
//    private String bossAlienShotRef;
//    private int bossAlienShotMoveSpeed;
    private int stage;
    private ShipType shipType;
    private List<StageConfig> stageConfigs;


    public GameConfig(String shipType, int stage) { // 몇 스테이지를 원하는지 들어올것

//        this.shipType = shipType;
//        this.shipPower = 1;
//        this.shipMagicPoint = 5;
//        this.shipHealth = 3;
//        this.shipMoveSpeed = 300;
//        this.alienMoveSpeed = -150;
//        this.alienShotRef = "sprites/alienshot.png";
//        this.shipShotRef = "sprites/shot.gif";
//        this.shipShotMoveSpeed = -300;
//        this.shipFirstSkillRef = "sprites/shot2.png";


        stageConfigs = new ArrayList<>();
        stageConfigs.add(null); // 0번 인덱스는 사용하지 않음

        switch (stage){
            case 1: //stage1
                stageConfigs.add(new StageConfig(1,"sprites/alien2.png", 2, 1, 3,
                        300, "sprites/boss1.png", 50, 2, -300,
                        "sprites/boss2.png", 500));
                break;
            case 2: // stage2
                stageConfigs.add(new StageConfig(2,"sprites/alien3.png", 3,1,4,
                        300,"sprites/boss2.png",50,2,-300,
                        "sprites/alienshot.png",500));
                break;
            case 3: //stage3
                stageConfigs.add(new StageConfig(3,"sprites/alien4.png",4,2,4,400,
                        "sprites/boss3.png",50,2,-400,
                        "sprites/alienshot.png",600));
                break;
            case 4: //stage4
                stageConfigs.add(new StageConfig(4,"sprites/alien5.png",5,2,4,400,
                        "sprites/boss4.png",70,2,-400,
                        "sprites/alienshot.png", 600));
                break;
            case 5: //stgae5
                stageConfigs.add(new StageConfig(5,"sprites/alien5.png",5,3,4,400,
                        "sprites/boss5.png",100,3,-500,
                        "sprites/alienshot.png", 600));
                break;
        }

//        StageConfig currentStageConfig = stageConfigs.get(stage);
//        if (currentStageConfig != null) {
//            this.alienRef = currentStageConfig.getAlienRef();
//            this.alienHealth = currentStageConfig.getAlienHealth();
//            this.alienPower = currentStageConfig.getAlienPower();
//            this.alienRow = currentStageConfig.getAlienRow();
//            this.alienShotMoveSpeed = currentStageConfig.getAlienShotMoveSpeed();
//            this.bossAlienRef = currentStageConfig.getBossAlienRef();
//            this.bossAlienHealth = currentStageConfig.getBossAlienHealth();
//            this.bossAlienPower = currentStageConfig.getBossAlienPower();
//            this.bossAlienMoveSpeed = currentStageConfig.getBossAlienMoveSpeed();
//            this.bossAlienShotRef = currentStageConfig.getBossAlienShotRef();
//            this.bossAlienShotMoveSpeed = currentStageConfig.getBossAlienShotMoveSpeed();

//            switch (stage) {
//                case 1:
//                    this.alienRef = "sprites/alien2.png";
//                    this.alienHealth = 2;
//                    this.alienPower = 1;
//                    this.alienRow = 3;
//                    this.alienShotMoveSpeed = 300;
//                    this.bossAlienRef = "sprites/boss1.png";
//                    this.bossAlienHealth = 50;
//                    this.bossAlienPower = 2;
//                    this.bossAlienMoveSpeed = -300;
//                    this.bossAlienShotRef = "sprites/boss2.png";
//                    this.bossAlienShotMoveSpeed = 500;
//                    break;
//                case 2:
//                    this.alienRef = "sprites/alien3.png";
//                    this.alienHealth = 3;
//                    this.alienPower = 1;
//                    this.alienRow = 4;
//                    this.alienShotMoveSpeed = 300;
//                    this.bossAlienRef = "sprites/boss2.png";
//                    this.bossAlienHealth = 50;
//                    this.bossAlienPower = 2;
//                    this.bossAlienMoveSpeed = -300;
//                    this.bossAlienShotRef = "sprites/alienshot.png";
//                    this.bossAlienShotMoveSpeed = 500;
//                    break;
//                case 3:
//                    this.alienRef = "sprites/alien4.png";
//                    this.alienHealth = 4;
//                    this.alienPower = 2;
//                    this.alienRow = 4;
//                    this.alienShotMoveSpeed = 400;
//                    this.bossAlienRef = "sprites/boss3.png";
//                    this.bossAlienHealth = 50;
//                    this.bossAlienPower = 2;
//                    this.bossAlienMoveSpeed = -400;
//                    this.bossAlienShotRef = "sprites/alienshot.png";
//                    this.bossAlienShotMoveSpeed = 600;
//                    break;
//                case 4:
//                    this.alienRef = "sprites/alien5.png";
//                    this.alienHealth = 5;
//                    this.alienPower = 2;
//                    this.alienRow = 4;
//                    this.alienShotMoveSpeed = 400;
//                    this.bossAlienRef = "sprites/boss4.png";
//                    this.bossAlienHealth = 70;
//                    this.bossAlienPower = 2;
//                    this.bossAlienMoveSpeed = -400;
//                    this.bossAlienShotRef = "sprites/alienshot.png";
//                    this.bossAlienShotMoveSpeed = 600;
//                    break;
//                case 5:
//                    this.alienRef = "sprites/alien5.png";
//                    this.alienHealth = 5;
//                    this.alienPower = 3;
//                    this.alienRow = 4;
//                    this.alienShotMoveSpeed = 400;
//                    this.bossAlienRef = "sprites/boss5.png";
//                    this.bossAlienHealth = 100;
//                    this.bossAlienPower = 3;
//                    this.bossAlienMoveSpeed = -500;
//                    this.bossAlienShotRef = "sprites/alienshot.png";
//                    this.bossAlienShotMoveSpeed = 600;
//                    break;
//            }

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

//    public String getAlienRef() {
//        return alienRef;
//    }

//    public int getAlienHealth() {
//        return alienHealth;
//    }
//
//    public int getAlienPower() {
//        return alienPower;
//    }
//
//    public String getAlienShotRef() {
//        return alienShotRef;
//    }
//
//    public double getAlienShotMoveSpeed() {
//        return alienShotMoveSpeed;
//    }

    public String getShipFirstSkillRef() {
        return shipFirstSkillRef;
    }

//    public String getShipSecondSkillRef() {
//        return shipSecondSkillRef;
//    }
//
//    public double getAlienMoveSpeed() {
//        return alienMoveSpeed;
//    }

//    public int getAlienRow() {
//        return alienRow;
//    }

//    public String getBossAlienRef() {
//        return bossAlienRef;
//    }

    public String getShipType() {
        return shipType.toString();
    }

//    public int getBossAlienHealth() {
//        return bossAlienHealth;
//    }
//
//    public int getBossAlienMoveSpeed() {
//        return bossAlienMoveSpeed;
//    }
//
//    public String getBossAlienShotRef() {
//        return bossAlienShotRef;
//    }
//
//    public int getBossAlienShotMoveSpeed() {
//        return bossAlienShotMoveSpeed;
//    }
//
//    public int getBossAlienPower() {
//        return bossAlienPower;
//    }

    public int getStage() {
        return stage;
    }
}
