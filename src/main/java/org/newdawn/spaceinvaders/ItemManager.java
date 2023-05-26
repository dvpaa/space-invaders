package org.newdawn.spaceinvaders;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

import org.newdawn.spaceinvaders.configuration.MagicNumber;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.item.*;

public class ItemManager {
    private Game game;
    private long itemInterval = 10000;
    private long lastItemGenerate = 0;
    private ArrayList<Supplier<Entity>> randomItemList = new ArrayList();
    private Random random = new Random();


    public ItemManager(Game game) {
        this.game = game;
    }
    public void initItem(){
        randomItemList.add(()->new AilenSlowItemEntity(game,random.nextInt(MagicNumber.FRAME_WIDTH),-35));
        randomItemList.add(()->new SpeedItemEntity(game,random.nextInt(MagicNumber.FRAME_WIDTH),-35));
        randomItemList.add(()->new PushItemEntity(game, random.nextInt(MagicNumber.FRAME_WIDTH), -35));
        randomItemList.add(()->new AttackItemEntity(game, random.nextInt(MagicNumber.FRAME_WIDTH), -35));
        randomItemList.add(()->new SkillCooldownItem(game, random.nextInt(MagicNumber.FRAME_WIDTH), -35));
    }
    public Entity generateItem(){
        long currTime = System.currentTimeMillis();
        if(currTime - lastItemGenerate > itemInterval){
            lastItemGenerate = currTime;
            Entity item = randomItemList.get(random.nextInt(randomItemList.size())).get();

            return item;
        }
        else{
            return null;
        }
    }
}
