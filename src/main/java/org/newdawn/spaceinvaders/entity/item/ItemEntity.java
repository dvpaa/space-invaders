package org.newdawn.spaceinvaders.entity.item;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.Sprite;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;

import java.awt.*;

public abstract class ItemEntity extends Entity{
    private Rectangle me = new Rectangle();
    private Rectangle him = new Rectangle();
    protected boolean used = false;
    protected double movespeed = 300;
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

    public boolean collidesWith(Entity other) {
        me.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
        him.setBounds((int) other.getX(),(int) other.getY(),other.getSprite().getWidth(),other.getSprite().getHeight());

        return me.intersects(him);
    }
    public void doLogic(){
    }

    public void collidedWith(Entity other){
        // TODO Auto-generated method stub
    }

    public void setShipEntity(ShipEntity shipEntity){
        this.shipEntity = shipEntity;
    }
    public abstract void doItemLogic();

    public boolean is_apply(){
        return is_apply;
    }
}
