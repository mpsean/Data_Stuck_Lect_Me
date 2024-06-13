package test;

import entity.Food;
import entity.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    @Test
    public void testConstructor() {
        Person p = new Person();
        assertEquals("John Doe", p.getName());
        assertEquals(300, p.getDailyIncome());
        assertEquals(-2, p.getHappinessLevel());
        assertEquals(20, p.getTotalMoney());

    }

    @Test
    public void testSetLegal() {
        Person p = new Person();

        p.setName("Jack");
        assertEquals("Jack", p.getName());

        p.setTotalMoney(5);
        assertEquals(5, p.getTotalMoney());

        p.setHappinessLevel(-1);
        assertEquals(-1, p.getHappinessLevel());

        p.setDailyIncome(400);
        assertEquals(400, p.getDailyIncome());
    }

    @Test
    public void testSetOutOfRange() {
        Person p = new Person();
        p.setTotalMoney(-5);
        assertEquals(0, p.getTotalMoney());

        p.setDailyIncome(-400);
        assertEquals(0, p.getDailyIncome());
    }

    @Test
    public void testEat(){
        Person p = new Person();
        Food food = new Food("Banana", 20, 4);

        p.eat(food);
        assertEquals(2,p.getHappinessLevel());

        p.eat(food);
        assertEquals(6,p.getHappinessLevel());
    }





}
