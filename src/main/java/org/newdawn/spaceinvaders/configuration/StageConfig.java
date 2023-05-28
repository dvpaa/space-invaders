package org.newdawn.spaceinvaders.configuration;

public class StageConfig {
	private final String alienRef;
	private final int alienHealth;
	private final int alienPower;
	private final int alienRow;
	private final double alienShotMoveSpeed;
	private final String bossAlienRef;
	private final int bossAlienHealth;
	private final int bossAlienPower;
	private final int bossAlienMoveSpeed;
	private final String bossAlienShotRef;
	private final int bossAlienShotMoveSpeed;

	public StageConfig(String alienRef, int alienHealth, int alienPower, int alienRow, double alienShotMoveSpeed,
		String bossAlienRef, int bossAlienHealth, int bossAlienPower, int bossAlienMoveSpeed,
		String bossAlienShotRef, int bossAlienShotMoveSpeed) {
		this.alienRef = alienRef;
		this.alienHealth = alienHealth;
		this.alienPower = alienPower;
		this.alienRow = alienRow;
		this.alienShotMoveSpeed = alienShotMoveSpeed;
		this.bossAlienRef = bossAlienRef;
		this.bossAlienHealth = bossAlienHealth;
		this.bossAlienPower = bossAlienPower;
		this.bossAlienMoveSpeed = bossAlienMoveSpeed;
		this.bossAlienShotRef = bossAlienShotRef;
		this.bossAlienShotMoveSpeed = bossAlienShotMoveSpeed;
	}

	public String getAlienRef() {
		return alienRef;
	}

	public int getAlienHealth() {
		return alienHealth;
	}

	public int getAlienPower() {
		return alienPower;
	}

	public int getAlienRow() {
		return alienRow;
	}

	public double getAlienShotMoveSpeed() {
		return alienShotMoveSpeed;
	}

	public String getBossAlienRef() {
		return bossAlienRef;
	}

	public int getBossAlienHealth() {
		return bossAlienHealth;
	}

	public int getBossAlienPower() {
		return bossAlienPower;
	}

	public int getBossAlienMoveSpeed() {
		return bossAlienMoveSpeed;
	}

	public String getBossAlienShotRef() {
		return bossAlienShotRef;
	}

	public int getBossAlienShotMoveSpeed() {
		return bossAlienShotMoveSpeed;
	}
}