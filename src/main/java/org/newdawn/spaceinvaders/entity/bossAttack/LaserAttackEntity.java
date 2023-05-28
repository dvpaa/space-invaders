package org.newdawn.spaceinvaders.entity.bossAttack;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.Sprite;
import org.newdawn.spaceinvaders.SpriteStore;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;

import java.util.Timer;
import java.util.TimerTask;

public class LaserAttackEntity extends BossAttackEntity{
    private boolean warningPhase = true;
    public LaserAttackEntity(Game game, String laserRef, String warningRef, int x, int y) {
        super(game, warningRef, x, y);
        moveSpeed = 0;
        dy = moveSpeed;

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                warningPhase = false;
                sprite = SpriteStore.get().getSprite(laserRef);
            }
        },3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                game.removeEntity(LaserAttackEntity.this);
            }
        },6000);
    }

    @Override
    public void collidedWith(Entity other) {
        if(warningPhase) return;

        if(other instanceof ShipEntity){
            game.notifyDeath();
        }
    }
}
