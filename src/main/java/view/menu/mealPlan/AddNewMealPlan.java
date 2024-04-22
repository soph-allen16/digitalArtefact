package view.menu.mealPlan;

import utils.InputHelper;

public class AddNewMealPlan {
    private final InputHelper inputHelper;

    public AddNewMealPlan(InputHelper inputHelper) {
        this.inputHelper = inputHelper;
    }

    public void runMenu(){
        System.out.println("***** Create Meal Plan *****");
        System.out.println("Please enter a date: (dd/mm/yy)");
        String date = inputHelper.getStringInput();

        System.out.println("Would you like to view saved meals? (y/n)");
        String choice = inputHelper.getStringInput();

        if(choice.equalsIgnoreCase("y")) {
            //print meals list
        }
        System.out.println("Please enter a meal name or ID for each of the following: ");
        String mondayChoice = inputHelper.getStringInput("Monday");
        String tuesdayChoice = inputHelper.getStringInput("Tuesday");
    }
}


