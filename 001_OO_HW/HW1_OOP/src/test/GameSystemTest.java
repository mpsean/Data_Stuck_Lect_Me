package test;
import entity.*;
import logic.GameSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameSystemTest {
    private Food food;
    private FoodCounter foodCounter;
    private Person player;

    @BeforeEach
    public void setUp() {
        food = new Food("Bottle of Milk", 20, 3);
        foodCounter = new FoodCounter(food, 10);
        player = new Person();
        player.setTotalMoney(100);
        GameSystem.player = player;
        GameSystem.refrigerator = new Refrigerator();
    }

    @Test
    public void testAddFoodToRefrigerator() {
        // index 0 is bottle of milk in market
        assertTrue(GameSystem.addFoodToRefrigerator(0, 1));
        assertEquals(1, GameSystem.refrigerator.getFoods().size());

        assertTrue(food.getName().equals(GameSystem.refrigerator.getFoods().get(0).getFood().getName()));
        assertEquals(1, GameSystem.refrigerator.getFoods().get(0).getAmount());
        assertEquals(80, player.getTotalMoney());
    }

    @Test
    public void testAddFoodToRefrigeratorNotEnoughMoney() {
        assertFalse(GameSystem.addFoodToRefrigerator(0, 11));
        assertTrue(GameSystem.refrigerator.getFoods().isEmpty());
        assertEquals(100, player.getTotalMoney());
    }

    @Test
    public void testAddFoodToRefrigeratorInvalidIndex() {
        assertFalse(GameSystem.addFoodToRefrigerator(-69, 1));
        assertTrue(GameSystem.refrigerator.getFoods().isEmpty());
        assertEquals(100, player.getTotalMoney());
    }
}

