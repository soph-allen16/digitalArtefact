package digitalArtefact.entity;

import java.util.Scanner;

public class ApplicationMenu {
    private final User user;
    private final Scanner scanner;

    public ApplicationMenu(User user, Scanner scanner) {
        this.user = user;
        this.scanner = scanner;
        menu();
    }

    private void menu() {
        boolean tryAgain = false;

        do {
            tryAgain = false;
            System.out.println("""
                    You have 4 choices:
                    1: See your details
                    2: Hear some words of encouragement
                    3: Exit application
                    Please select (1-3)
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println(user.getUserSummary());
                tryAgain = true;
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
