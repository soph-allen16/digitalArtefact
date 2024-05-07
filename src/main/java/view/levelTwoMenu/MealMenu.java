package view.levelTwoMenu;

import utils.InputHelper;
import model.service.MealService;
import view.Menu;

public class MealMenu extends Menu {

    private final MealService mealService;

    public MealMenu(MealService mealService){
        super();

        //Initialise dependencies
        this.mealService = mealService;

        //Set menu information
        menuName = "View/Edit Meals";
        menuOptions = new String[] {
                "View list of meals",
                "View meal details",
                "Add meal",
                "Delete meal" };
    }

    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain){
            if(choice == 1){
                //View meal list
                mealService.viewMealList();
            }else if (choice == 2) {
                //View specific meal details
                mealService.viewMealDetails(InputHelper.getIntegerInput("Enter a meal ID"));
            }else if(choice == 3) {
                //Add new meal
                mealService.addMeal();
            }else if ( choice == 4) {
                //Delete meal
                mealService.deleteMealById(InputHelper.getIntegerInput("Enter the ID of the meal you would like to delete"));
            }
            super.runMenu();
        }
    }
}
