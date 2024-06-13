package test;
import entity.Food;
import entity.FoodCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class FoodCounterTest {
    @Test
    public void testConstructor() {
        Food food = new Food("Apple", 10, 3);
        FoodCounter foodCounter = new FoodCounter(food, 5);
        assertEquals(food, foodCounter.getFood());
        assertEquals(5, foodCounter.getAmount());

        foodCounter = new FoodCounter(food);
        assertEquals(food, foodCounter.getFood());
        assertEquals(1, foodCounter.getAmount());
    }
    @Test
    public void testBadConstructor() {
        Food food = new Food("Apple", 10, 3);
        FoodCounter foodCounter = new FoodCounter(food, -5);
        assertEquals(food, foodCounter.getFood());
        assertEquals(1, foodCounter.getAmount());
    }

    @Test
    public void testSet(){
        Food food = new Food("Apple", 10, 3);
        FoodCounter fc = new FoodCounter(food, 5);

        fc.setFood(new Food("Meat",12,12));
        assertTrue((new Food("Meat",12,12)).equals(fc.getFood()));

        fc.setAmount(3);
        assertEquals(3,fc.getAmount());

        fc.setAmount(0);
        assertEquals(1,fc.getAmount());

    }

}
