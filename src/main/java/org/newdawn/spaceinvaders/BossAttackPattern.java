package org.newdawn.spaceinvaders;

import org.newdawn.spaceinvaders.configuration.GameConfig;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.bossAttack.LaserAttackEntity;
import org.newdawn.spaceinvaders.entity.bossAttack.MeteorAttackEntity;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

public class BossAttackPattern {
    private Game game;
    private ArrayList<Supplier<Entity>> bossAttackPattern = new ArrayList<>();
    private Random random = new Random();
    private String meteorRef = "sprites/Meteor.png";
    private String laserRef = "sprites/Laser.png";
    private String warningRef = "sprites/warningLaser.png";
    private long shotInterval;
    private long lastShot;
    private int stage = -1;
    private boolean isBoss = false;
    public BossAttackPattern(Game game, int stage) {
        this.game = game;
        this.stage = stage%2;
        if(this.stage==0){
            shotInterval = 1000;
        }
        else {
            shotInterval = 10000;
        }
    }

    public void initBossAttackPattern(){
        bossAttackPattern.add(()->new MeteorAttackEntity(game, meteorRef,random.nextInt(GameConfig.FRAME_WIDTH), -100));
        bossAttackPattern.add(()->new LaserAttackEntity(game,laserRef, warningRef, random.nextInt(GameConfig.FRAME_WIDTH), 0));
    }

    public Entity doBossAttack(){
        if(!isBoss) return null;

        long currTime = System.currentTimeMillis();
        if(currTime - lastShot > shotInterval){
            lastShot = currTime;
            Entity bossAttack = bossAttackPattern.get(stage).get();

            return bossAttack;
        }
        return null;
    }

    public void setBoss(boolean isBoss){
        this.isBoss = isBoss;
    }
}
