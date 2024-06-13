package logic;

import java.util.Scanner;

public class Utility {
    public static Scanner sc = new Scanner(System.in);
    public static void showPageBreak(){
        System.out.println("======================================================");
    }

    public static void showAlertAndContinue(String message){
        System.out.println(message);
        System.out.println("Press any number to continue.");
        int number = getInput(1,99999999);
    }
    public static int getInput(int min, int max){
        while (true){
            int input = sc.nextInt();
            if(min <= input && input <= max ){
                return input;
            }
            else{
                System.out.println("Invalid input. Please try again!");
            }
        }
    }
}
