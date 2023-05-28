package org.newdawn.spaceinvaders.entity.bossAttack;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;

public class MeteorAttackEntity extends BossAttackEntity{

    public MeteorAttackEntity(Game game, String ref, int x, int y) {
        super(game, ref, x, y);
        moveSpeed = 80;
        dy = moveSpeed;
    }

    @Override
    public void collidedWith(Entity other) {
        if(other instanceof ShipEntity){
            game.notifyDeath();
        }
    }
}
