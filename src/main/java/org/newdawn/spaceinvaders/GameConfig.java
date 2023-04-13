package org.newdawn.spaceinvaders;

public class GameConfig {

    private String shipRef;
    private int shipPower;
    private int shipHealth;
    private int shipMagicPoint;

    private String shipShotRef;
    private double shipShotMoveSpeed;

    private String alienRef;
    private int alienHealth;
    private int alienPower;

    private String alienShotRef;
    private double alienShotMoveSpeed;

    public GameConfig(int stage) {
        switch (stage) {
            case 1:
                this.shipRef = "sprites/ship.gif";
                this.shipPower = 1;
                this.shipMagicPoint = 5;

                this.shipShotRef = "sprites/shot.gif";
                this.shipShotMoveSpeed = -300;

                this.alienRef = "sprites/alien.gif";
                this.alienHealth = 1;
                this.alienPower = 1;

                this.alienShotRef = "sprites/alienshot.png";
                this.shipShotMoveSpeed = 300;
        }
    }
}
