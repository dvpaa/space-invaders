package org.newdawn.spaceinvaders.entity;

import org.newdawn.spaceinvaders.Game;

/**
 * The entity that represents the players ship
 * 
 * @author Kevin Glass
 */
public class ShipEntity extends Entity {
	/** The game in which the ship exists */
	private Game game;

	private int power;

	private int health = 2;

	private int magicPoint = 1;

	/**
	 * Create a new entity to represent the players ship
	 *
	 * @param game The game in which the ship is being created
	 * @param ref  The reference to the sprite to show for the ship
	 * @param x    The initial x location of the player's ship
	 * @param y    The initial y location of the player's ship
	 */
	public ShipEntity(Game game, String ref, int x, int y, int power) {

		super(ref, x, y);

		this.game = game;
		this.power = power;
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
		return new ShotEntity(game, "sprites/shot.gif",this.getX()+10,this.getY()-30, this.power, 1);
	}

	@Override
	public Entity skill1() {
		return new ShotEntity(game, "sprites/shot2.png", this.getX(), this.getY()-70, 5, 1.5);
	}

	@Override
	public Entity skill2() {
		return new ShotEntity(game, "sprites/shot2.png", this.getX(), this.getY()-70, 5, 1.5);
	}
}