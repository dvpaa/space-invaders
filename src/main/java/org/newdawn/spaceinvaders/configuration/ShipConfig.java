package org.newdawn.spaceinvaders.configuration;

public class ShipConfig {

	private final String shipRef;
	private final int extraPower;
	private final int extraHealth;
	private final double moveSpeedMultiplier;
	private final double shotSpeedMultiplier;

	private ShipConfig(ShipBuilder shipBuilder) {
		this.shipRef = shipBuilder.shipRef;
		this.extraPower = shipBuilder.extraPower;
		this.extraHealth = shipBuilder.extraHealth;
		this.moveSpeedMultiplier = shipBuilder.moveSpeedMultiplier;
		this.shotSpeedMultiplier = shipBuilder.shotSpeedMultiplier;
	}

	public String getShipRef() {
		return shipRef;
	}

	public int getExtraPower() {
		return extraPower;
	}

	public int getExtraHealth() {
		return extraHealth;
	}

	public double getMoveSpeedMultiplier() {
		return moveSpeedMultiplier;
	}

	public double getShotSpeedMultiplier() {
		return shotSpeedMultiplier;
	}

	public static class ShipBuilder {
		private String shipRef;
		private int extraPower = 0;
		private int extraHealth = 0;
		private double moveSpeedMultiplier = 1.0;
		private double shotSpeedMultiplier = 1.0;

		public ShipBuilder(String shipRef) {
			this.shipRef = shipRef;
		}

		public ShipBuilder extraPower(int extraPower) {
			this.extraPower = extraPower;
			return this;
		}

		public ShipBuilder extraHealth(int extraHealth) {
			this.extraHealth = extraHealth;
			return this;
		}

		public ShipBuilder moveSpeedMultiplier(double moveSpeedMultiplier) {
			this.moveSpeedMultiplier = moveSpeedMultiplier;
			return this;
		}

		public ShipBuilder shotSpeedMultiplier(double shotSpeedMultiplier) {
			this.shotSpeedMultiplier = shotSpeedMultiplier;
			return this;
		}

		public ShipConfig build() {
			return new ShipConfig(this);
		}
	}
}
