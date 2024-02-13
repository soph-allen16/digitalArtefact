package digitalArtefact;

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

        System.out.println("""
                You have 4 choices:
                1: See your details
                2: Hear some words of encouragement
                3: Exit application
                Please select (1-3)
                """);
        int choice = scanner.nextInt();
        scanner.nextLine();

        if(choice ==1){
            System.out.println("Your name is: " + firstName + " "+ surname+ ". You have worked for " + workplace + " for " + yearsWorked + " years.");
        }else if( choice ==2 ){
            System.out.println( firstName + ", you are doing really well.");
        }else if( choice == 3){
            System.out.println("Okay, exiting...");
            System.exit(0);
        }else{
            System.out.println("incorrect input.");
        }

        scanner.close();
    }
}
