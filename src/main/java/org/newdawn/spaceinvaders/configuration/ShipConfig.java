package org.newdawn.spaceinvaders.configuration;

public class ShipConfig {

	private final String shipRef;
	private final int extraPower;
	private final int extraHealth;
	private final double moveSpeedMultiplier;
	private final double shotSpeedMultiplier;

	public ShipConfig(String shipRef, int extraPower, int extraHealth) {
		this(shipRef, extraPower, extraHealth, 1.0, 1.0);
	}

	public ShipConfig(String shipRef, int extraPower, int extraHealth, double moveSpeedMultiplier, double shotSpeedMultiplier) {
		this.shipRef = shipRef;
		this.extraPower = extraPower;
		this.extraHealth = extraHealth;
		this.moveSpeedMultiplier = moveSpeedMultiplier;
		this.shotSpeedMultiplier = shotSpeedMultiplier;
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
}
