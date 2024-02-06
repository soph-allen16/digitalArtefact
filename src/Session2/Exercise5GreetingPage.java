package Session2;

import java.util.Scanner;

public class Exercise5GreetingPage {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello and welcome to the application. Before we start, let's collect some information about you.");

        System.out.println("What is your first name?");
        String firstName = scanner.nextLine();

        System.out.println("What is your surname?");
        String surname = scanner.nextLine();

        System.out.println("Where do you work?");
        String workplace = scanner.nextLine();

        System.out.println("How many years have you worked for " + workplace + "?");
        String yearsWorked = scanner.nextLine();

        System.out.println("Ok, all information has been gathered.");
        System.out.println("Welcome to the program " + firstName + " " + surname + ". "
        + "Congratulations on working for " + workplace + " for " + yearsWorked + " years.") ;
    }
}
