package org.newdawn.spaceinvaders.entity.item;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;

import java.awt.*;

public class AttackItemEntity extends ItemEntity{
    private long effectTime = 3000;
    private long startTime = 0;



    public AttackItemEntity(Game game, int x, int y) {
        super(game, "sprites/attackItem.png", x, y);
        dx = 0;
        dy = moveSpeed * 0.5;
    }
    @Override
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
                shipEntity.setPower(shipEntity.getPower() + 1);
                is_apply = true;
            }
            if(System.currentTimeMillis() - startTime > effectTime){
                shipEntity.setPower(shipEntity.getPower() - 1);
                game.removeItem(this);
            }
        }
    }
    public void resetItemEffect(){
        shipEntity.setPower(shipEntity.getPower() - 1);
    }
}
