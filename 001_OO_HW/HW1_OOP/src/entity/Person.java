package entity;

public class Person {
	private String name;
	private int totalMoney; // The value can't be below 0
	private int happinessLevel; 
	private int dailyIncome; //can’t be below 0
	
	public Person() {
		this.setDailyIncome(300);
		this.setHappinessLevel(-2);
		this.setTotalMoney(20);
		this.setName("John Doe");
	}
	
	public void eat(Food food) {
		int foodScore = food.getTasteScore();
		this.setHappinessLevel(this.happinessLevel+foodScore);
	}
	
 	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		if(totalMoney>0) {
			this.totalMoney = totalMoney;
		}else {
			this.totalMoney = 0;
		}
	}
	public int getHappinessLevel() {
		return happinessLevel;
	}
	public void setHappinessLevel(int happinessLevel) {
		this.happinessLevel = happinessLevel;
	}
	public int getDailyIncome() {
		return dailyIncome;
	}
	public void setDailyIncome(int dailyIncome) {
		if(dailyIncome>0) {
			this.dailyIncome = dailyIncome;
		}else {
			this.dailyIncome = 0;
		}
	}
}
