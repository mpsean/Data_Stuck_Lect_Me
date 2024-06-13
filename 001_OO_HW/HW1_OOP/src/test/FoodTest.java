package test;
import entity.Food;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class FoodTest {
    @Test
    public void testConstructor() {
        Food food = new Food("Apple", 10, 3);
        assertEquals("Apple", food.getName());
        assertEquals(10, food.getPrice());
        assertEquals(3, food.getTasteScore());
    }

    @Test
    public void testBadConstructor() {
        Food food = new Food("Apple", 10, -3);
        assertEquals("Apple", food.getName());
        assertEquals(10, food.getPrice());
        assertEquals(1, food.getTasteScore());

        food = new Food("Apple", 10, 8);
        assertEquals("Apple", food.getName());
        assertEquals(10, food.getPrice());
        assertEquals(5, food.getTasteScore());
    }

    @Test
    public void testSet(){
        Food food = new Food("Apple", 10, 3);
        food.setName("Orange");
        assertEquals("Orange", food.getName());

        food.setPrice(5);
        assertEquals(5, food.getPrice());

        food.setTasteScore(4);
        assertEquals(4, food.getTasteScore());
        food.setTasteScore(0);
        assertEquals(1, food.getTasteScore());
        food.setTasteScore(6);
        assertEquals(5, food.getTasteScore());
    }

    @Test
    public void testEquals() {
        Food food1 = new Food("Apple", 10, 3);
        Food food2 = new Food("Apple", 10, 3);
        Food food3 = new Food("Banana", 10, 3);
        Food food4 = new Food("Banana", 15, 3);
        Food food5 = new Food("Banana", 15, 6);
        assertTrue(food1.equals(food2));
        assertFalse(food1.equals(food3));
        assertFalse(food3.equals(food4));
        assertFalse(food4.equals(food5));

    }
}
