package org.newdawn.spaceinvaders.entity.item;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;

import java.awt.*;

public class SpeedItemEntity extends ItemEntity{
    private Rectangle me = new Rectangle();
    private Rectangle him = new Rectangle();
    private long effectTime = 10000;
    private long startTime = 0;

    public SpeedItemEntity(Game game, int x, int y) {
        super(game, "sprites/speedupItem.png", x, y);
        dx = 0;
        dy = moveSpeed * 0.5;
    }
    @Override
    public boolean collidesWith(Entity other) {
        me.setBounds((int) x, (int) y, sprite.getWidth(), sprite.getHeight());
        him.setBounds(other.getX(), other.getY(), other.getSprite().getWidth(), other.getSprite().getHeight());

        return me.intersects(him);
    }

    public void collidedWith(Entity other) {
        if(other instanceof ShipEntity){
            if(used){return;}
            game.removeEntity(this);
            game.addItem(this);
            used = true;
            startTime = System.currentTimeMillis();
        }
    }

    @Override
    public void move(long delta) {
        super.move(delta);
    }

    @Override
    public void doItemLogic() {
        if(used){
            if(!is_apply){
                game.setmoveSpeed(game.getmoveSpeed()*1.5);
                is_apply = true;
            }
            if(System.currentTimeMillis() - startTime > effectTime){
                game.setmoveSpeed(game.getmoveSpeed()/1.5);
                game.removeItem(this);
            }
        }
    }
    public void resetItemEffect(){
        game.setmoveSpeed(game.getmoveSpeed()/1.5);
    }
}
