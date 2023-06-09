package org.newdawn.spaceinvaders.configuration;

import java.util.HashMap;
import java.util.Map;

public class GameConfig {
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
    public static final int TIMER_LABEL_WIDTH = 60;
    public static final int LABEL_WIDTH = 100;
    public static final int LABEL_HEIGHT = 25;
    public static final int INITIAL_SHIP_X = 370;
    public static final int INITIAL_SHIP_Y = 550;
    public static final int INITIAL_BOSS_X = 400;
    public static final int INITIAL_BOSS_Y = 90;
    public static final int MILLISECOND_PER_SECOND = 1000;
    public static final int defaultPoint = 1000;

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
    private StageConfig stageConfig;
    private ShipConfig shipConfig;

    public static final Map<Integer, StageConfig> stageConfigMap = new HashMap<>();
    public static final Map<String, ShipConfig> shipConfigMap = new HashMap<>();

    static {
        stageConfigMap.put(1, new StageConfig.StageBuilder()
            .alienRef("sprites/alien2.png")
            .alienHealth(2)
            .alienPower(1)
            .alienRow(3)
            .alienShotMoveSpeed(300)
            .bossAlienRef("sprites/boss1.png")
            .bossAlienHealth(50)
            .bossAlienPower(2)
            .bossAlienMoveSpeed(-300)
            .bossAlienShotRef("sprites/alienshot.png")
            .bossAlienShotMoveSpeed(500)
            .build());
        stageConfigMap.put(2, new StageConfig.StageBuilder()
            .alienRef("sprites/alien3.png")
            .alienHealth(3)
            .alienPower(1)
            .alienRow(4)
            .alienShotMoveSpeed(300)
            .bossAlienRef("sprites/boss2.png")
            .bossAlienHealth(50)
            .bossAlienPower(2)
            .bossAlienMoveSpeed(-300)
            .bossAlienShotRef("sprites/alienshot.png")
            .bossAlienShotMoveSpeed(500)
            .build());
        stageConfigMap.put(3, new StageConfig.StageBuilder()
            .alienRef("sprites/alien4.png")
            .alienHealth(4)
            .alienPower(2)
            .alienRow(4)
            .alienShotMoveSpeed(400)
            .bossAlienRef("sprites/boss3.png")
            .bossAlienHealth(50)
            .bossAlienPower(2)
            .bossAlienMoveSpeed(-400)
            .bossAlienShotRef("sprites/alienshot.png")
            .bossAlienShotMoveSpeed(600)
            .build());
        stageConfigMap.put(4, new StageConfig.StageBuilder()
            .alienRef("sprites/alien5.png")
            .alienHealth(5)
            .alienPower(2)
            .alienRow(4)
            .alienShotMoveSpeed(400)
            .bossAlienRef("sprites/boss4.png")
            .bossAlienHealth(70)
            .bossAlienPower(2)
            .bossAlienMoveSpeed(-400)
            .bossAlienShotRef("sprites/alienshot.png")
            .bossAlienShotMoveSpeed(600)
            .build());
        stageConfigMap.put(5, new StageConfig.StageBuilder()
            .alienRef("sprites/alien5.png")
            .alienHealth(5)
            .alienPower(3)
            .alienRow(4)
            .alienShotMoveSpeed(400)
            .bossAlienRef("sprites/boss5.png")
            .bossAlienHealth(100)
            .bossAlienPower(3)
            .bossAlienMoveSpeed(-500)
            .bossAlienShotRef("sprites/alienshot.png")
            .bossAlienShotMoveSpeed(600)
            .build());

        shipConfigMap.put(ShipType.ATTACK_UP, new ShipConfig.ShipBuilder("sprites/attackUpShip.png")
            .extraPower(2)
            .build());
        shipConfigMap.put(ShipType.DEFENCE_UP, new ShipConfig.ShipBuilder("sprites/defenceUpShip.png")
            .extraHealth(2)
            .build());
        shipConfigMap.put(ShipType.SPEED_UP, new ShipConfig.ShipBuilder("sprites/speedUpShip.png")
            .moveSpeedMultiplier(1.4)
            .shotSpeedMultiplier(1.4)
            .build());
    }

    public GameConfig(String shipType, int stage) {
        this.stage = stage;
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

        this.stageConfig = stageConfigMap.get(this.stage);
        this.shipConfig = shipConfigMap.get(this.shipType);

        stageSetting();
        shipSetting();

        System.out.println(this.shipType);
    }

    private void shipSetting() {
        if (shipConfig != null) {
            this.shipRef = shipConfig.getShipRef();
            this.shipPower += shipConfig.getExtraPower();
            this.shipHealth += shipConfig.getExtraHealth();
            this.shipMoveSpeed *= shipConfig.getMoveSpeedMultiplier();
            this.shipShotMoveSpeed *= shipConfig.getShotSpeedMultiplier();
            System.out.println("not null");
            return;
        }
        this.shipRef = "sprites/ship.gif";
        System.out.println("null");
    }

    private void stageSetting() {
        if (stageConfig != null) {
            this.alienRef = stageConfig.getAlienRef();
            this.alienHealth = stageConfig.getAlienHealth();
            this.alienPower = stageConfig.getAlienPower();
            this.alienRow = stageConfig.getAlienRow();
            this.alienShotMoveSpeed = stageConfig.getAlienShotMoveSpeed();
            this.bossAlienRef = stageConfig.getBossAlienRef();
            this.bossAlienHealth = stageConfig.getBossAlienHealth();
            this.bossAlienPower = stageConfig.getBossAlienPower();
            this.bossAlienMoveSpeed = stageConfig.getBossAlienMoveSpeed();
            this.bossAlienShotRef = stageConfig.getBossAlienShotRef();
            this.bossAlienShotMoveSpeed = stageConfig.getBossAlienShotMoveSpeed();
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

    public int getStage() {
        return stage;
    }
}
