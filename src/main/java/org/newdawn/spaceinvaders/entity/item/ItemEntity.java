package org.newdawn.spaceinvaders.entity.item;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.Sprite;
import org.newdawn.spaceinvaders.entity.Entity;

import java.awt.*;

public abstract class ItemEntity extends Entity{
    protected Sprite sprite;
    protected Game game;
    protected double x;
    protected double y;
    protected double dx;
    protected double dy;
    protected boolean used = false;
    private Rectangle me = new Rectangle();
    private Rectangle him = new Rectangle();

    public ItemEntity(Game game, String ref, int x, int y) {
        super(ref, x, y);

        this.game = game;
    }

    public void move(long delta) {
        x += (delta * dx) / 1000;
        y += (delta * dy) / 1000;
    }

    public boolean collidesWith(Entity other) {
        me.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
        him.setBounds((int) other.getX(),(int) other.getY(),other.getSprite().getWidth(),other.getSprite().getHeight());

        return me.intersects(him);
    }

    public abstract void doItemLogic();

    public abstract void collidedWith(Entity other);
}
