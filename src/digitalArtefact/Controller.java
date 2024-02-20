package digitalArtefact;

import digitalArtefact.entity.User;

import java.util.Scanner;

public class Controller {
    private final User user;

    public Controller(User user) {
        this.user = user;
        menu();
    }

    private void menu() {
        Scanner menuScanner = new Scanner(System.in);
        boolean tryAgain = false;

        do {
            tryAgain = false;
            System.out.println("""
                    You have 4 choices:g
                    1: See your details
                    2: Hear some words of encouragement
                    3: Exit application
                    Please select (1-3)
                    """);

            int choice;
            choice = menuScanner.nextInt();
            menuScanner.nextLine();

            if (choice == 1) {
                System.out.println("Your name is: " + user.getFirstname() + " " + user.getSurname() + ". You have worked for " + user.getWorkplace() + " for " + user.getYearsWorked() + " years.");
            } else if (choice == 2) {
                System.out.println(user.getFirstname() + ", you are doing really well.");
            } else if (choice == 3) {
                System.out.println("Okay, exiting...");
                System.exit(0);
            } else {
                System.out.println("incorrect input. Please try again");
                tryAgain = true;
            }
        } while (tryAgain);

    }
}
