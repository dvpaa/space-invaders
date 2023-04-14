package org.newdawn.spaceinvaders.entity;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.Sprite;
import org.newdawn.spaceinvaders.SpriteStore;
import org.newdawn.spaceinvaders.configuration.GameConfig;

/**
 * An entity which represents one of our space invader aliens.
 * 
 * @author Kevin Glass
 */
public class AlienEntity extends Entity {
	/** The speed at which the alient moves horizontally */
	private double moveSpeed = 75;
	/** The game in which the entity exists */
	private Game game;
	/** The animation frames */
	private Sprite[] frames = new Sprite[5];
	/** The time since the last frame change took place */
	private long lastFrameChange;
	/** The frame duration in milliseconds, i.e. how long any given frame of animation lasts */
	private long frameDuration = 250;
	/** The current frame of animation being displayed */
	private int frameNumber;

	private int health;

	private int power;
	private GameConfig gameConfig;
	private boolean isBoss;

public AlienEntity(Game game, GameConfig gameConfig, String alienRef,  int x, int y, boolean isBoss) {
	super(alienRef, x, y);

	this.game = game;
	this.gameConfig = gameConfig;
	this.isBoss = isBoss;
	if (isBoss) {
		this.health = gameConfig.getBossAlienHealth();
		this.power = gameConfig.getBossAlienPower();
		dx = gameConfig.getBossAlienMoveSpeed();
	} else {
		this.health = gameConfig.getAlienHealth();
		this.power = gameConfig.getAlienPower();
		dx = gameConfig.getAlienMoveSpeed();
	}

	// setup the animatin frames
	frames[0] = SpriteStore.get().getSprite("sprites/alien1.png");
	frames[1] = SpriteStore.get().getSprite("sprites/alien2.png");
	frames[2] = SpriteStore.get().getSprite("sprites/alien3.png");
	frames[3] = SpriteStore.get().getSprite("sprites/alien4.png");
	frames[4] = SpriteStore.get().getSprite("sprites/alien5.png");
}

	/**
	 * Request that this alien moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) {
		// since the move tells us how much time has passed
		// by we can use it to drive the animation, however
		// its the not the prettiest solution

		if (!this.isBoss) {
			sprite = frames[this.health - 1];
		}
		
		// if we have reached the left hand side of the screen and
		// are moving left then request a logic update 
		if ((dx < 0) && (x < 10)) {
			game.updateLogic();
		}
		// and vice vesa, if we have reached the right hand side of 
		// the screen and are moving right, request a logic update
		if ((dx > 0) && (x > 750)) {
			game.updateLogic();
		}
		
		// proceed with normal move
		super.move(delta);
	}
	
	/**
	 * Update the game logic related to aliens
	 */
	public void doLogic() {
		// swap over horizontal movement and move down the
		// screen a bit

		dx = -dx;
		if (!isBoss) {
			y += 10;
		}
		
		// if we've reached the bottom of the screen then the player
		// dies
		if (y > 570) {
			game.notifyDeath();
		}
	}
	
	/**
	 * Notification that this alien has collided with another entity
	 * 
	 * @param other The other entity
	 */
	public void collidedWith(Entity other) {
		// collisions with aliens are handled elsewhere
		// if we've hit an alien, kill it!
		if (other instanceof ShotEntity) {
			ShotEntity _other = (ShotEntity) other;
			health -= _other.attack();

			// remove the affected entities
			if (health <= 0) {
				game.removeEntity(this);
				// notify the game that the alien has been killed
				game.notifyAlienKilled();
			}
		}
	}

	@Override
	public ShotEntity fire() {
//		return new ShotEntity(game, "sprites/alienshot.png",this.getX()+25,this.getY()+30, this.power, -1);
		return new ShotEntity(game, gameConfig, gameConfig.getAlienShotRef(), false, this.getX() + 25, this.getY() + 30, false);
	}
}