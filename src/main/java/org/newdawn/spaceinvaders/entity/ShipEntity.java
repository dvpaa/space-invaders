package org.newdawn.spaceinvaders.entity;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.configuration.GameConfig;

/**
 * The entity that represents the players ship
 * 
 * @author Kevin Glass
 */
public class ShipEntity extends Entity {
	/** The game in which the ship exists */
	private Game game;

	private int power;

	private int health;

	private int magicPoint;
	private GameConfig gameConfig;


//	public ShipEntity(Game game, String ref, int x, int y, int power) {
//
//		super(ref, x, y);
//
//		this.game = game;
//		this.power = power;
//	}
	public ShipEntity(Game game, GameConfig gameConfig, int x, int y) {

		super(gameConfig.getShipRef(), x, y);

		this.game = game;
		this.gameConfig = gameConfig;
		this.power = gameConfig.getShipPower();
		this.health = gameConfig.getShipHealth();
		this.magicPoint = gameConfig.getShipMagicPoint();
	}
	
	/**
	 * Request that the ship move itself based on an elapsed ammount of
	 * time
	 * 
	 * @param delta The time that has elapsed since last move (ms)
	 */
	public void move(long delta) {
		// if we're moving left and have reached the left hand side
		// of the screen, don't move
		if ((dx < 0) && (x < 10)) {
			return;
		}
		// if we're moving right and have reached the right hand side
		// of the screen, don't move
		if ((dx > 0) && (x > 750)) {
			return;
		}
		
		super.move(delta);
	}
	
	/**
	 * Notification that the player's ship has collided with something
	 * 
	 * @param other The entity with which the ship has collided
	 */
	public void collidedWith(Entity other) {
		// if its an alien, notify the game that the player
		// is dead
		if (other instanceof AlienEntity) {
			game.notifyDeath();
		}

		if (other instanceof ShotEntity) {
			ShotEntity _other = (ShotEntity) other;
			this.health -= _other.attack();

			// remove the affected entities
			if (this.health <= 0) {
				game.notifyDeath();
			}
		}
	}

	@Override
	public ShotEntity fire() {
		return new ShotEntity(game, gameConfig, gameConfig.getShipShotRef(), true, this.getX() + 10, this.getY() - 30, false);
	}

	@Override
	public Entity attackSkill() {
		return new ShotEntity(game, gameConfig, gameConfig.getShipFirstSkillRef(), true, this.getX(), this.getY()-70, true);
	}

	@Override
	public void defenceSkill() {
		for (Entity entity : game.entities) {
			if (entity instanceof ShotEntity) {
				if (!((ShotEntity) entity).isShip) {
					game.removeEntity(entity);
				}
			}
		}
	}

	@Override
	public Entity secondSkill() {
		return new ShotEntity(game, gameConfig, gameConfig.getShipFirstSkillRef(), true, this.getX(), this.getY()-70, true);
	}
}