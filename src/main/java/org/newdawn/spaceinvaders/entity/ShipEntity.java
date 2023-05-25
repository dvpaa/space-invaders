package org.newdawn.spaceinvaders.entity;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.entity.item.ItemEntity;
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
	private double moveSpeed;

	// gameConfig에서 가져올 정보
	private double shotMoveSpeed;
	private String shotRef;
	private String skillRef;

	public ShipEntity(Game game, GameConfig gameConfig, int x, int y) {

		super(gameConfig.getShipRef(), x, y);

		this.game = game;
		this.gameConfig = gameConfig;
		this.power = gameConfig.getShipPower();
		this.health = gameConfig.getShipHealth();
		this.magicPoint = gameConfig.getShipMagicPoint();

		this.moveSpeed = gameConfig.getShipMoveSpeed();

		this.shotMoveSpeed = gameConfig.getShipShotMoveSpeed();
		this.shotRef = gameConfig.getShipShotRef();
		this.skillRef = gameConfig.getShipFirstSkillRef();
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
		
		super.move(delta * (long) moveSpeed);
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
			game.removeEntity(other);

			// remove the affected entities
			if (this.health <= 0) {
				game.notifyDeath();
			}
		}
		if (other instanceof ItemEntity) {
			((ItemEntity) other).setShipEntity(this);
		}
	}

	@Override
	public ShotEntity fire() {
		return new ShotEntity(game, power, shotMoveSpeed, shotRef, true, this.getX() + 10, this.getY() - 30, false);
	}

	@Override
	public Entity attackSkill() {
		return new ShotEntity(game, power, shotMoveSpeed, skillRef, true, this.getX(), this.getY()-70, true);
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
//	public Entity secondSkill() {
//		return new ShotEntity(game, gameConfig, gameConfig.getShipFirstSkillRef(), true, this.getX(), this.getY()-70, true);
//	}
	public Entity secondSkill() {
		return new ShotEntity(game, power, shotMoveSpeed, skillRef, true, this.getX(), this.getY()-70, true);
	}

	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public double getMoveSpeed(){
		return moveSpeed;
	}
	public void setMoveSpeed(double moveSpeed){
		this.moveSpeed = moveSpeed;
	}
	public int getHealth() {
		return health;
	}
}