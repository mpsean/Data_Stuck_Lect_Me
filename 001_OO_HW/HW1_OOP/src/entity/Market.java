package entity;

import java.util.ArrayList;

public class Market {
    private final ArrayList<FoodCounter> stock;
    public Market() {

        this.stock = new ArrayList<FoodCounter>();
        // food String name , int price , int  tastescore
        stock.add(new FoodCounter(new Food("Bottle of Milk", 20, 3), 3));
        stock.add(new FoodCounter(new Food("Chocolate", 80, 2), 3));
        stock.add(new FoodCounter(new Food("Cheese", 50, 1), 3));
        stock.add(new FoodCounter(new Food("Bread", 40, 5), 3));
        stock.add(new FoodCounter(new Food("Chicken", 50, 5), 3));
        stock.add(new FoodCounter(new Food("Fish", 60, 3), 3));
        stock.add(new FoodCounter(new Food("Prime Beef", 1000, 5), 3));
        stock.add(new FoodCounter(new Food("Pork", 50, 3), 3));
        stock.add(new FoodCounter(new Food("Egg", 10, 2), 3));
        stock.add(new FoodCounter(new Food("Jasmine Rice", 20, 3), 3));
    }
    public ArrayList<FoodCounter> getStock() {
        return stock;
    }
}
