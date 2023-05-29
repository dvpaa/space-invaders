package org.newdawn.spaceinvaders.entity.item;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;

public abstract class ItemEntity extends Entity {
    protected boolean used = false;
    protected double moveSpeed = 300;
    protected ShipEntity shipEntity;
    protected boolean is_apply = false;
    protected Game game;

    public ItemEntity(Game game, String ref, int x, int y) {
        super(ref, x, y);
        this.game = game;
    }

    public void move(long delta) {
        super.move(delta);
        if (y > 650) {
            game.removeEntity(this);
        }
    }

    public void collidedWith(Entity other) {
        // TODO Auto-generated method stub
    }

    public void setShipEntity(ShipEntity shipEntity) {
        this.shipEntity = shipEntity;
    }

    public abstract void doItemLogic();

    public abstract void resetItemEffect();
}
