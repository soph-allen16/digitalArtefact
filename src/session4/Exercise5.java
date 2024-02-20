package session4;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 10) +1;

        System.out.println("please enter a guess between 1 and 10:");
        int guessNumber = scanner.nextInt();
        scanner.nextLine();

        while( guessNumber != randomNumber){
            if( (guessNumber>10)||(guessNumber<1)){
                System.out.println("Please enter a number between 1 and 10");
            }else{
                System.out.println("Wrong! Please try again");
            }
            guessNumber = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Well done!");
        scanner.close();
    }
}
