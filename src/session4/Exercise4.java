package session4;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args){
        String password = "password";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your password");
        String attempt = scanner.nextLine();

        while(!password.equals(attempt)) {
            System.out.println("incorrect! Please try again.");
            attempt = scanner.nextLine();
        }

        System.out.println("Success!");
        scanner.close();
    }
}
