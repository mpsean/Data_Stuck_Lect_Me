package entity;

import java.util.ArrayList;

public class Refrigerator {
	private ArrayList<FoodCounter> foods = new ArrayList<FoodCounter>();
	
	public Refrigerator() {
		//this.setFoods(new ArrayList<FoodCounter>);
	}
	
	public Refrigerator(ArrayList<FoodCounter> foods) {
		super();
		this.foods = foods;
	}
	//no food
	public boolean isNewFood(Food food) {
		// If food isn’t equal to any, return true. Otherwise, return false.
		if(foods.size()==0) {
			return true;
		}
		for(int n = 0; n+1 <= foods.size();n++) {
			Food myFood = foods.get(n).getFood();
			if(myFood.equals(food)) {
				return false;
			}
		}
		return true;
	}
	public void addFood(Food food, int amount) {
		//If food is a new food, we will add a FoodCounter with the amount assigned from the parameter to the arraylist. Otherwise, add the amount to the existing foodCounter which contains that food type.
		if(isNewFood(food)) {
			FoodCounter newCounter = new FoodCounter(food, amount);
			foods.add(newCounter);
		}else {
			for(int n = 0; n+1 <= foods.size();n++) {
				Food myFood = foods.get(n).getFood();
				if(myFood.equals(food)) {
					foods.get(n).setAmount(foods.get(n).getAmount()+amount);
				}
			}
		}
	}
	public boolean deleteFood(Food food) {
		//If food doesn't exist, print “No food in refrigerator” via the console and return false.
		//1) If that food type has only 1 amount, remove it
		//from the existing foodcounter arraylist. Then returntrue.
		//2) If that food has more than 1 amount, reduce the amount by 1. Then return true.
		for(int n = 0; n+1 <= foods.size();n++) {
			Food myFood = foods.get(n).getFood();
			if(myFood.equals(food)) {
				int foodAmount = foods.get(n).getAmount();
				if(foodAmount == 1) {
					foods.remove(foods.get(n));
				}else {
					foods.get(n).setAmount(foods.get(n).getAmount()-1);
				}
				return true;
			}
		}
		System.out.println("No food in refrigerator");
		return false;
		
	}
	
	
	public void setFoods(ArrayList<FoodCounter> foods) {
		this.foods = foods;
	}

	@Override
	public String toString() {
		return "Refrigerator [foods=" + foods + "]";
	}

	public ArrayList<FoodCounter> getFoods() {
		return foods;
	}
}
