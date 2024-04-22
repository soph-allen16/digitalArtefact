package view.menu;

import utils.InputHelper;
import view.service.IngredientService;
import view.service.MealPlanService;
import view.service.MealService;

public class MainMenu extends Menu {
    private final EditMenu editMenu;
    private final MealPlanningMenu mealPlanningMenu;


    public MainMenu(InputHelper inputHelper,
                    IngredientService ingredientService,
                    MealService mealService,
                    MealPlanService mealPlanService){
        super(inputHelper);

        //Initialise dependencies
        this.editMenu = new EditMenu(inputHelper, ingredientService, mealService);
        this.mealPlanningMenu = new MealPlanningMenu(inputHelper, mealPlanService);

        //Set menu information
        menuName = "Main Menu";
        options = new String[]{
                "View/Edit Ingredients & Meals",
                "Meal Planning" };

        //Run the main menu - begin process
        runMenu();
    }

    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain) {
            if (choice == 1) {
                editMenu.runMenu();
            }else if (choice == 2) {
                mealPlanningMenu.runMenu();
            }
            super.runMenu();
        }
    }
}
