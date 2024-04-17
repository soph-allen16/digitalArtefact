package view.menu.meal;

import utils.InputHelper;
import view.menu.Menu;
import view.service.MealService;

public class MealMenu extends Menu {

    private final MealService mealService;
    private final EditMealMenu editMealMenu;

    public MealMenu(InputHelper inputHelper, MealService mealService){
        super(inputHelper);

        //Initialise dependencies
        this.mealService = mealService;
        this.editMealMenu = new EditMealMenu(inputHelper, mealService);

        //Set menu information
        menuName = "View/Edit Ingredients";
        options = new String[] {
                "View list of meals",
                "View meal details",
                "Add meal",
                "Edit meal",
                "Delete meal" };
    }

    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain){
            if(choice == 1){
                mealService.viewMealList();
            }else if (choice == 2) {
                mealService.viewMealDetails(inputHelper.getIntegerInput("Enter a meal ID"));
            }else if(choice == 3) {
                mealService.addMeal();
            }else if ( choice == 4) {
                editMealMenu.runMenu(mealService.findMealById());
            }
            super.runMenu();
        }
    }
}
