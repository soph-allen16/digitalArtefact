package Session3;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println( "Guess a number from 1-10:");
        int guessNumber = scanner.nextInt();
        int randomNumber = (int) (Math.random() * 10) +1;
        if(guessNumber == randomNumber){
            System.out.println("Well guessed!");
        }else{
            System.out.println("You guessed wrong. The random number was:" + randomNumber);
        }

        scanner.close();
    }
}
