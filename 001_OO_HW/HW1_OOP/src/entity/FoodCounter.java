package entity;

public class FoodCounter {
	private Food food;
	private int amount;
	
	public FoodCounter(Food food) { 
		this.setFood(food);
		this.setAmount(1);
	}
	public FoodCounter(Food food, int amount) {
		this.setFood(food);
		this.setAmount(amount);
	}
	
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		if(amount>1) {
			this.amount = amount;
		}else {
			this.amount = 1;
		}
	}
	@Override
	public String toString() {
		return "FoodCounter [food=" + food + ", amount=" + amount + "]";
	}
	
}
