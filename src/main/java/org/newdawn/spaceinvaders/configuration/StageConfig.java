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

	public StageConfig(StageBuilder stageBuilder) {
		this.alienRef = stageBuilder.alienRef;
		this.alienHealth = stageBuilder.alienHealth;
		this.alienPower = stageBuilder.alienPower;
		this.alienRow = stageBuilder.alienRow;
		this.alienShotMoveSpeed = stageBuilder.alienShotMoveSpeed;
		this.bossAlienRef = stageBuilder.bossAlienRef;
		this.bossAlienHealth = stageBuilder.bossAlienHealth;
		this.bossAlienPower = stageBuilder.bossAlienPower;
		this.bossAlienMoveSpeed = stageBuilder.bossAlienMoveSpeed;
		this.bossAlienShotRef = stageBuilder.bossAlienShotRef;
		this.bossAlienShotMoveSpeed = stageBuilder.bossAlienShotMoveSpeed;
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

	public static class StageBuilder {
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

		public StageBuilder alienRef(String alienRef) {
			this.alienRef = alienRef;
			return this;
		}

		public StageBuilder alienHealth(int alienHealth) {
			this.alienHealth = alienHealth;
			return this;
		}

		public StageBuilder alienPower(int alienPower) {
			this.alienPower = alienPower;
			return this;
		}

		public StageBuilder alienRow(int alienRow) {
			this.alienRow = alienRow;
			return this;
		}

		public StageBuilder alienShotMoveSpeed(double alienShotMoveSpeed) {
			this.alienShotMoveSpeed = alienShotMoveSpeed;
			return this;
		}

		public StageBuilder bossAlienRef(String bossAlienRef) {
			this.bossAlienRef = bossAlienRef;
			return this;
		}

		public StageBuilder bossAlienHealth(int bossAlienHealth) {
			this.bossAlienHealth = bossAlienHealth;
			return this;
		}

		public StageBuilder bossAlienPower(int bossAlienPower) {
			this.bossAlienPower = bossAlienPower;
			return this;
		}

		public StageBuilder bossAlienMoveSpeed(int bossAlienMoveSpeed) {
			this.bossAlienMoveSpeed = bossAlienMoveSpeed;
			return this;
		}

		public StageBuilder bossAlienShotRef(String bossAlienShotRef) {
			this.bossAlienShotRef = bossAlienShotRef;
			return this;
		}

		public StageBuilder bossAlienShotMoveSpeed(int bossAlienShotMoveSpeed) {
			this.bossAlienShotMoveSpeed = bossAlienShotMoveSpeed;
			return this;
		}

		public StageConfig build() {
			return new StageConfig(this);
		}
	}
}