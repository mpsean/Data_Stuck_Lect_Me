package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		setName(name);
		setBloodCost(bloodCost);
		setPower(power);
		setHealth(health);
		setFlavorText(flavorText);
	}
	public void setName(String name) {
		if(name.isBlank()) {
			name = "Creature";
		}
		this.name = name;
	}
	public void setBloodCost(int bloodCost) {
		if(bloodCost < 0) {
			bloodCost = 0;
		}
		this.bloodCost = bloodCost;
	}
	public void setPower(int power) {
		if(power < 0) {
			power = 0;
		}
		this.power = power;
	}
	public void setHealth(int health) {
		if(health < 1) {
			health = 1;
		}
		this.health = health;
	}
	public void setFlavorText(String flavorText) {
		if(name.isBlank()) {
			flavorText = "Creature";
		}
		this.flavorText = flavorText;
	}
	public boolean equals(UnitCard other) {
		if(other.getName() == this.name) {
			return true;
		}
		return false;
	}
	public String getName() {
		return this.name;
	}
	public int getBloodCost() {
		return this.bloodCost;
	}
	public int getPower() {
		return this.power;
	}
	public int getHealth() {
		return this.health;
	}
	public String getFlavorText() {
		return this.flavorText;
	}
	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
}
