package logic;

import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSystem {
    public static Scanner sc = new Scanner(System.in);
    public static Refrigerator refrigerator = new Refrigerator();

    public static Market market = new Market();

    public static Person player = new Person();


    public static void runMainMenu() {
        System.out.println("Welcome to my shop ! ");
        while (true) {
            System.out.println("Please Select number to continue");
            System.out.println("<1> Go to market");
            System.out.println("<2> List all Food in Refrigerator");
            System.out.println("<3> List people Status");
            System.out.println("<4> Eating just 1 piece of Food in Refrigerator");
            System.out.println("<5> QUIT GAME");
            int choice = Utility.getInput(1, 5);
            switch (choice) {
                case 1 -> {
                    runMarketStatus();
                }
                case 2 -> {
                    ShowAllFoodInRefrigerator();
                }
                case 3 -> {
                    ShowAllPeopleStatus();
                }
                case 4 -> {
                    RunEatingFood();
                }

                case 5 -> {
                    System.out.print(5);
                    System.exit(0);
                }
            }
        }
    }

    public static void runMarketStatus() {
        while (true) {
            System.out.println("Welcome to Market");
            System.out.println("<1> List all Food in Market");
            System.out.println("<2> Buy food in market and add to Refrigerator");
            System.out.println("<3> Back to main menu");
            int choice = Utility.getInput(1, 3);
            if (choice == 3) {
                break;
            }
            switch (choice) {
                case 1 -> {
                    showFoodInMarket();
                }
                case 2 -> {
                    System.out.println("Please enter index of food that you want to buy");
                    int index = Utility.getInput(0, market.getStock().size() - 1);
                    System.out.println("Please enter amount of food that you want to buy");
                    int amount = Utility.getInput(1, 99999999);
                    if (addFoodToRefrigerator(index, amount)) {
                        System.out.println("Add food to refrigerator successfully");
                    } else {
                        System.out.println("Add food to refrigerator failed");
                    }
                }
            }
        }
    }

    public static void showFoodInMarket() {
        ArrayList<FoodCounter> foodCounters = market.getStock();
        Utility.showPageBreak();
        System.out.println("Food in Market");
        Utility.showPageBreak();
        for (int i = 0; i < foodCounters.size(); i++) {
            System.out.println("<" + i + ">  name :" + foodCounters.get(i).getFood().getName() + " , price : " + foodCounters.get(i).getFood().getPrice());
        }
        Utility.showPageBreak();
    }

    public static boolean addFoodToRefrigerator(int index, int amount) {
        //TODO:  Write code here
		if(index < 0 || index >= market.getStock().size()) {
			System.out.println("Error: Invalid index number!");
			return false;
		}
    	FoodCounter indexFood = (market.getStock()).get(index);
		int price = amount * indexFood.getFood().getPrice();
		if(player.getTotalMoney()< price) {
			return false;
		}else {
			player.setTotalMoney(player.getTotalMoney()-price);
			refrigerator.addFood(indexFood.getFood(), amount);
	        return true; // you can delete this line
		}
    }

    public static void ShowAllFoodInRefrigerator() {
        ArrayList<FoodCounter> foodCounters = refrigerator.getFoods();
        Utility.showPageBreak();
        System.out.println("Food in Refrigerator");
        Utility.showPageBreak();
        if (foodCounters.isEmpty()) {
            System.out.println("Your refrigerator is empty. Please buy food at market to get more food.");
        } else {
            for (int i = 0; i < foodCounters.size(); i++) {
                System.out.println("[" + i + "]  name :" + foodCounters.get(i).getFood().getName() + " , amount : " + foodCounters.get(i).getAmount() + " , tasteScore : " + foodCounters.get(i).getFood().getTasteScore());
            }
        }
        Utility.showPageBreak();
    }

    public static void ShowAllPeopleStatus() {
        Utility.showPageBreak();
        System.out.println("Player Status");
        Utility.showPageBreak();
        System.out.println("Name : " + player.getName());
        System.out.println("Money : " + player.getTotalMoney());
        System.out.println("DailyIncome : " + player.getDailyIncome());
        System.out.println("Happiness level : " + player.getHappinessLevel());
        Utility.showPageBreak();
    }

    public static void RunEatingFood() {
        if (refrigerator.getFoods().isEmpty()) {
            System.out.println("Your refrigerator is empty. Please buy food at market to get more food.");
        } else {
            ShowAllFoodInRefrigerator();
            System.out.println("Please enter index of food that you want to eat");
            int choice = Utility.getInput(0, refrigerator.getFoods().size() - 1);
//            System.out.println(choice);
//            System.out.println(refrigerator.getFoods());
//            System.out.println(refrigerator.getFoods().get(choice).getFood());
            Food food = refrigerator.getFoods().get(choice).getFood();
            if (refrigerator.deleteFood(food)) {
                player.eat(food);
                System.out.println("Eating food successfully");
            } else {
                System.out.println("Eating food failed");
            }
        }

    }

}
