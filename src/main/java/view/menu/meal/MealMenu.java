package view.menu.meal;

import utils.InputHelper;
import view.menu.Menu;
import view.service.MealService;

public class MealMenu extends Menu {

    private final MealService mealService;

    public MealMenu(MealService mealService){
        super();

        //Initialise dependencies
        this.mealService = mealService;

        //Set menu information
        menuName = "View/Edit Ingredients";
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
                mealService.viewMealList();
            }else if (choice == 2) {
                mealService.viewMealDetails(InputHelper.getIntegerInput("Enter a meal ID"));
            }else if(choice == 3) {
                mealService.addMeal();
            }else if ( choice == 4) {
                mealService.deleteMealById();
            }
            super.runMenu();
        }
    }
}
