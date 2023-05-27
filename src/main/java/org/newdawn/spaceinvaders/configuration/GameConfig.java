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

    private int stage;
    private ShipType shipType;
    private List<StageConfig> stageConfigs;


    public GameConfig(String shipType, int stage) { // 몇 스테이지를 원하는지 들어올것

        stageConfigs = new ArrayList<>();
        stageConfigs.add(null); // 0번 인덱스는 사용하지 않음

        stageConfigs.add(new StageConfig(1,"sprites/alien2.png", 2, 1, 3,
                300, "sprites/boss1.png", 50, 2, -300,
                "sprites/boss2.png", 500, shipType));

        stageConfigs.add(new StageConfig(1,"sprites/alien2.png", 2, 1, 3,
                300, "sprites/boss1.png", 50, 2, -300,
                "sprites/boss2.png", 500, shipType));
        stageConfigs.add(new StageConfig(3,"sprites/alien4., png",4,2,4,400,
                "sprites/boss3.png",50,2,-400,
                "sprites/alienshot.png",600, shipType));
        stageConfigs.add(new StageConfig(4,"sprites/alien5.png",5,2,4,400,
                "sprites/boss4.png",70,2,-400,
                "sprites/alienshot.png", 600, shipType));
        stageConfigs.add(new StageConfig(5,"sprites/alien5.png",5,3,4,400,
                "sprites/boss5.png",100,3,-500,
                "sprites/alienshot.png", 600, shipType));

//        switch (stage){
//            case 1: //stage1
//                stageConfigs.add(new StageConfig(1,"sprites/alien2.png", 2, 1, 3,
//                        300, "sprites/boss1.png", 50, 2, -300,
//                        "sprites/boss2.png", 500));
//                break;
//            case 2: // stage2
//                stageConfigs.add(new StageConfig(1,"sprites/alien2.png", 2, 1, 3,
//                        300, "sprites/boss1.png", 50, 2, -300,
//                        "sprites/boss2.png", 500));
//                break;
//            case 3: //stage3
//                stageConfigs.add(new StageConfig(3,"sprites/alien4.png",4,2,4,400,
//                        "sprites/boss3.png",50,2,-400,
//                        "sprites/alienshot.png",600));
//                break;
//            case 4: //stage4
//                stageConfigs.add(new StageConfig(4,"sprites/alien5.png",5,2,4,400,
//                        "sprites/boss4.png",70,2,-400,
//                        "sprites/alienshot.png", 600));
//                break;
//            case 5: //stgae5
//                stageConfigs.add(new StageConfig(5,"sprites/alien5.png",5,3,4,400,
//                        "sprites/boss5.png",100,3,-500,
//                        "sprites/alienshot.png", 600));
//                break;
//        }


//        switch (shipType) {
//            case ShipType.ATTACK_UP:
//                this.shipRef = "sprites/attackUpShip.png";
//                this.shipPower = shipPower + 2;
//                break;
//            case ShipType.DEFENCE_UP:
//                this.shipRef = "sprites/defenceUpShip.png";
//                this.shipHealth = shipHealth + 2;
//                break;
//            case ShipType.SPEED_UP:
//                this.shipRef = "sprites/speedUpShip.png";
//                this.shipMoveSpeed = shipMoveSpeed * 1.4;
//                this.shipShotMoveSpeed = shipShotMoveSpeed * 1.4;
//                break;
//            default:
//                this.shipRef = "sprites/ship.gif";
//                break;
//        }
        }

//    public String getShipRef() {
//        return shipRef;
//    }
//
//    public int getShipPower() {
//        return shipPower;
//    }
//
//    public int getShipHealth() {
//        return shipHealth;
//    }
//
//    public int getShipMagicPoint() {
//        return shipMagicPoint;
//    }
//
//    public double getShipMoveSpeed() {
//        return shipMoveSpeed;
//    }
//
//    public String getShipShotRef() {
//        return shipShotRef;
//    }
//
//    public double getShipShotMoveSpeed() {
//        return shipShotMoveSpeed;
//    }
//
//    public String getShipFirstSkillRef() {
//        return shipFirstSkillRef;
//    }
//
//    public String getShipType() {
//        return shipType.toString();
//    }
//
//    public int getStage() {
//        return stage;
//    }
}
