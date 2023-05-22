package org.newdawn.spaceinvaders.entity.item;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;

import java.awt.*;

public class SkillCooldownItem extends ItemEntity{

    public SkillCooldownItem(Game game, int x, int y) {
        super(game, "sprites/skillCooldownItem.png", x, y);
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
                game.setlastShipSkill1((long) (game.getlastShipSkill1()-game.getSkillInterval1()));
                game.setlastShipSkill2((long) (game.getlastShipSkill2()-game.getSkillInterval2()));
                is_apply = true;
            }
            else{
                game.removeItem(this);
            }
        }
    }
    public void resetItemEffect(){
    }
}
