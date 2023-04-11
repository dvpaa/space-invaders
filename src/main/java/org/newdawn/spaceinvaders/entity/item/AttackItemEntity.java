package org.newdawn.spaceinvaders.entity.item;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.Sprite;
import org.newdawn.spaceinvaders.entity.Entity;

import java.awt.*;

public class AttackItemEntity extends ItemEntity{
    private Game game;
    private Sprite sprite;
    private Rectangle me = new Rectangle();
    private Rectangle him = new Rectangle();


    public AttackItemEntity(Game game, int x, int y) {
        super("sprites/attackItem.png", x, y);

        this.game = game;
    }
    @Override
    public boolean collidesWith(Entity other) {
        me.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
        him.setBounds((int) other.getX(),(int) other.getY(),other.getSprite().getWidth(),other.getSprite().getHeight());

        return me.intersects(him);
    }

    public void collidedWith(Entity other) {
        // TODO Auto-generated method stub
    }
}
