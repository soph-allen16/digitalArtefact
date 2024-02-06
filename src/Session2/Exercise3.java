package Session2;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What times table would you like to see?");

        int multiple = scanner.nextInt();

        for( int i = 1 ; i<13; i++) {
            System.out.println( i + " x " + multiple + " = " + i*multiple );
        }

        scanner.close();
    }
}
