package test;
import entity.Food;
import entity.FoodCounter;
import entity.Refrigerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class RefrigeratorTest {
    private Refrigerator refrigerator;

    @BeforeEach
    public void setUp() {
        refrigerator = new Refrigerator();
    }

    @Test
    public void testAddNewFood() {
        Food food = new Food("Apple", 10, 3);
        refrigerator.addFood(food, 5);
        assertEquals(1, refrigerator.getFoods().size());
        assertEquals(food, refrigerator.getFoods().get(0).getFood());
        assertEquals(5, refrigerator.getFoods().get(0).getAmount());
    }

    @Test
    public void testAddExistingFood() {
        Food f1 = new Food("Apple", 10, 3);
        Food f2 = new Food("Meat", 12, 12);
        Food f3 = new Food("Chocolate",5,20);

        refrigerator.addFood(f1, 3);
        refrigerator.addFood(f2, 4);
        refrigerator.addFood(f3, 5);

        refrigerator.addFood(f2, 4);
        assertEquals(3, refrigerator.getFoods().size());
        assertEquals(f1, refrigerator.getFoods().get(0).getFood());
        assertEquals(3, refrigerator.getFoods().get(0).getAmount());
        assertEquals(f2, refrigerator.getFoods().get(1).getFood());
        assertEquals(8, refrigerator.getFoods().get(1).getAmount());
        assertEquals(f3, refrigerator.getFoods().get(2).getFood());
        assertEquals(5, refrigerator.getFoods().get(2).getAmount());

    }

    @Test
    public void testDeleteExistingFood01() {
        Food f1 = new Food("Apple", 10, 3);
        Food f2 = new Food("Meat", 12, 12);
        Food f3 = new Food("Chocolate",5,20);
        Food f4 = new Food("Jelly",3,15);

        refrigerator.addFood(f1, 3);
        refrigerator.addFood(f2, 1);
        refrigerator.addFood(f3, 7);
        refrigerator.addFood(f4, 5);

        assertTrue(refrigerator.deleteFood(f2));
        assertEquals(3,refrigerator.getFoods().size());
        assertEquals(f1, refrigerator.getFoods().get(0).getFood());
        assertEquals(3, refrigerator.getFoods().get(0).getAmount());
        assertEquals(f3, refrigerator.getFoods().get(1).getFood());
        assertEquals(7, refrigerator.getFoods().get(1).getAmount());
        assertEquals(f4, refrigerator.getFoods().get(2).getFood());
        assertEquals(5, refrigerator.getFoods().get(2).getAmount());

    }

    @Test
    public void testDeleteExistingFood02() {
        Food f1 = new Food("Apple", 10, 3);
        Food f2 = new Food("Meat", 12, 12);
        Food f3 = new Food("Chocolate",5,20);
        Food f4 = new Food("Jelly",3,15);

        refrigerator.addFood(f1, 3);
        refrigerator.addFood(f2, 1);
        refrigerator.addFood(f3, 7);
        refrigerator.addFood(f4, 5);

        assertTrue(refrigerator.deleteFood(f3));
        assertEquals(4,refrigerator.getFoods().size());
        assertEquals(f1, refrigerator.getFoods().get(0).getFood());
        assertEquals(3, refrigerator.getFoods().get(0).getAmount());
        assertEquals(f2, refrigerator.getFoods().get(1).getFood());
        assertEquals(1, refrigerator.getFoods().get(1).getAmount());
        assertEquals(f3, refrigerator.getFoods().get(2).getFood());
        assertEquals(6, refrigerator.getFoods().get(2).getAmount());
        assertEquals(f4, refrigerator.getFoods().get(3).getFood());
        assertEquals(5, refrigerator.getFoods().get(3).getAmount());

    }

    @Test
    public void testDeleteNonExistingFood() {
        Food f1 = new Food("Apple", 10, 3);
        Food f2 = new Food("Meat", 12, 12);
        Food f3 = new Food("Chocolate",5,20);
        Food f4 = new Food("Jelly",3,15);

        refrigerator.addFood(f1, 3);
        refrigerator.addFood(f2, 1);
        refrigerator.addFood(f3, 7);
        refrigerator.addFood(f4, 5);

        Food food = new Food("Banana", 10, 3);
        assertFalse(refrigerator.deleteFood(food));
        assertEquals(4,refrigerator.getFoods().size());

        assertEquals(f1, refrigerator.getFoods().get(0).getFood());
        assertEquals(3, refrigerator.getFoods().get(0).getAmount());
        assertEquals(f2, refrigerator.getFoods().get(1).getFood());
        assertEquals(1, refrigerator.getFoods().get(1).getAmount());
        assertEquals(f3, refrigerator.getFoods().get(2).getFood());
        assertEquals(7, refrigerator.getFoods().get(2).getAmount());
        assertEquals(f4, refrigerator.getFoods().get(3).getFood());
        assertEquals(5, refrigerator.getFoods().get(3).getAmount());

    }

    @Test
    public void testIsNewFood() {
        Food f1 = new Food("Apple", 10, 3);
        Food f2 = new Food("Meat", 12, 12);
        Food f3 = new Food("Chocolate",5,20);
        FoodCounter fc1 = new FoodCounter(f1 ,3);
        FoodCounter fc2 = new FoodCounter(f2 ,4);
        FoodCounter fc3 = new FoodCounter(f3 ,5);

        assertTrue(refrigerator.isNewFood(f1));
        assertTrue(refrigerator.isNewFood(f2));
        assertTrue(refrigerator.isNewFood(f3));

        refrigerator.getFoods().add(fc1);
        refrigerator.getFoods().add(fc2);
        refrigerator.getFoods().add(fc3);

        assertFalse(refrigerator.isNewFood(f1));
        assertFalse(refrigerator.isNewFood(f2));
        assertFalse(refrigerator.isNewFood(f3));

        refrigerator.getFoods().remove(0);
        assertTrue(refrigerator.isNewFood(f1));

    }

}

