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

	public StageConfig(Builder builder) {
		this.alienRef = builder.alienRef;
		this.alienHealth = builder.alienHealth;
		this.alienPower = builder.alienPower;
		this.alienRow = builder.alienRow;
		this.alienShotMoveSpeed = builder.alienShotMoveSpeed;
		this.bossAlienRef = builder.bossAlienRef;
		this.bossAlienHealth = builder.bossAlienHealth;
		this.bossAlienPower = builder.bossAlienPower;
		this.bossAlienMoveSpeed = builder.bossAlienMoveSpeed;
		this.bossAlienShotRef = builder.bossAlienShotRef;
		this.bossAlienShotMoveSpeed = builder.bossAlienShotMoveSpeed;
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

	public static class Builder {
		private String alienRef;
		private int alienHealth;
		private int alienPower;
		private int alienRow;
		private double alienShotMoveSpeed;
		private String bossAlienRef;
		private int bossAlienHealth;
		private int bossAlienPower;
		private int bossAlienMoveSpeed;
		private String bossAlienShotRef;
		private int bossAlienShotMoveSpeed;

		public Builder alienRef(String alienRef) {
			this.alienRef = alienRef;
			return this;
		}

		public Builder alienHealth(int alienHealth) {
			this.alienHealth = alienHealth;
			return this;
		}

		public Builder alienPower(int alienPower) {
			this.alienPower = alienPower;
			return this;
		}

		public Builder alienRow(int alienRow) {
			this.alienRow = alienRow;
			return this;
		}

		public Builder alienShotMoveSpeed(double alienShotMoveSpeed) {
			this.alienShotMoveSpeed = alienShotMoveSpeed;
			return this;
		}

		public Builder bossAlienRef(String bossAlienRef) {
			this.bossAlienRef = bossAlienRef;
			return this;
		}

		public Builder bossAlienHealth(int bossAlienHealth) {
			this.bossAlienHealth = bossAlienHealth;
			return this;
		}

		public Builder bossAlienPower(int bossAlienPower) {
			this.bossAlienPower = bossAlienPower;
			return this;
		}

		public Builder bossAlienMoveSpeed(int bossAlienMoveSpeed) {
			this.bossAlienMoveSpeed = bossAlienMoveSpeed;
			return this;
		}

		public Builder bossAlienShotRef(String bossAlienShotRef) {
			this.bossAlienShotRef = bossAlienShotRef;
			return this;
		}

		public Builder bossAlienShotMoveSpeed(int bossAlienShotMoveSpeed) {
			this.bossAlienShotMoveSpeed = bossAlienShotMoveSpeed;
			return this;
		}

		public StageConfig build() {
			return new StageConfig(this);
		}
	}
}