package org.newdawn.spaceinvaders.entity.bossAttack;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.entity.Entity;

public abstract class BossAttackEntity extends Entity {
    protected Game game;

    public BossAttackEntity(Game game, String ref, int x, int y) {
        super(ref, x, y);
        this.game = game;

        dx = 0;
    }
    @Override
    public void move(long delta) {
        super.move((long) moveSpeed);
    }
}
