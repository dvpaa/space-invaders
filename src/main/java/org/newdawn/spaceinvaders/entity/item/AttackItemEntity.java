package org.newdawn.spaceinvaders.entity.item;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;

import java.awt.*;

public class AttackItemEntity extends ItemEntity{
    private Rectangle me = new Rectangle();
    private Rectangle him = new Rectangle();
    private long effectTime = 3000;
    private long startTime = 0;



    public AttackItemEntity(Game game, String ref, int x, int y, double direction) {
        super(game, ref, x, y);
        dx = 0;
        dy = movespeed * direction;
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
            if(System.currentTimeMillis() - startTime > effectTime){
                shipEntity.setPower(shipEntity.getPower() - 1);
                game.removeItem(this);
            }
            if(!is_apply){
                shipEntity.setPower(shipEntity.getPower() + 1);
                is_apply = true;
            }
        }
    }

    public long getStartTime(){
        return startTime;
    }

    public long getEffectTime(){
        return effectTime;
    }

}
