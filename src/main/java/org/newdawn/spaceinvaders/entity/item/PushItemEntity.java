package org.newdawn.spaceinvaders.entity.item;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;

import java.util.ArrayList;

public class PushItemEntity extends ItemEntity {

    private ArrayList ailen = new ArrayList();

    public PushItemEntity(Game game, int x, int y) {
        super(game, "sprites/pushItem.png", x, y);
        dx = 0;
        dy = moveSpeed * 0.5;
    }

    @Override
    public void collidedWith(Entity other) {
        if (other instanceof ShipEntity) {
            if (used) {
                return;
            }
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
        if (used) {
            if (!is_apply) {
                is_apply = true;
                ailen = game.getAlien();
                for (int i = 0; i < ailen.size(); i++) {
                    if (((Entity)ailen.get(i)).getY() < 10) {
                        return;
                    }
                    ((Entity)ailen.get(i)).setY(((Entity)ailen.get(i)).getY() - 10);
                }
                is_apply = true;
            } else {
                game.removeItem(this);
            }
        }

    }

    public void resetItemEffect() {
    }
}
