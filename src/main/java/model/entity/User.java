package model.entity;

import utils.InputHelper;

public class User {
    private final InputHelper inputHelper;
    private String firstname;
    private String surname;
    private String workplace;
    private int yearsWorked;

    public User(InputHelper inputHelper){
        this.inputHelper = inputHelper;
        gatherInformation();
    }

    private void gatherInformation(){
        System.out.println("Hello and welcome to the application. Before we start, let's collect some information about you.");

        this.firstname = inputHelper.getStringInput("What is your first name?");

        this.surname = inputHelper.getStringInput("What is your surname?");

        this.workplace = inputHelper.getStringInput("Where do you work?");

        this.yearsWorked = inputHelper.getIntegerInput("How many years have you worked for " + workplace + "?");

        System.out.println();
        System.out.println("Ok, all information has been gathered. \r\n" + "Welcome to the program " + firstname + " " + surname + ". "
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

    public int getYearsWorked() {
        return yearsWorked;
    }

    public String getUserSummary(){
        return "Your name is: " + firstname + " " + surname + ". You have worked for " + workplace + " for " + yearsWorked + " years.";
    }
}
