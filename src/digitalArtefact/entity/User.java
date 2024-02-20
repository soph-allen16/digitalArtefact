package digitalArtefact.entity;

import java.util.Scanner;

public class User {
    String firstname;
    String surname;
    String workplace;
    String yearsWorked;

    public User(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello and welcome to the application. Before we start, let's collect some information about you.");

        System.out.println("What is your first name?");
        this.firstname = scanner.nextLine();

        System.out.println("What is your surname?");
        this.surname = scanner.nextLine();

        System.out.println("Where do you work?");
        this.workplace = scanner.nextLine();

        System.out.println("How many years have you worked for " + workplace + "?");
        this.yearsWorked = scanner.nextLine();

        System.out.println("Ok, all information has been gathered.");
        System.out.println("Welcome to the program " + firstname + " " + surname + ". "
                + "Congratulations on working for " + workplace + " for " + yearsWorked + " years.") ;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getYearsWorked() {
        return yearsWorked;
    }
}
