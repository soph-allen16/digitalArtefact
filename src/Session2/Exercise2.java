package Session2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("How old are you?");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is your date of birth?");
        String date = scanner.nextLine();

        System.out.println("Your name is " + name +" and you are " + age+ " years old. You were born on "+ date);

        scanner.close();
    }
}
