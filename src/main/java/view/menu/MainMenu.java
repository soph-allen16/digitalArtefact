package view.menu;

import view.service.IngredientService;
import view.service.MealPlanService;
import view.service.MealService;

public class MainMenu extends Menu {
    private final EditMenu editMenu;
    private final MealPlanningMenu mealPlanningMenu;


    public MainMenu(IngredientService ingredientService,
                    MealService mealService,
                    MealPlanService mealPlanService){
        super();

        //Initialise dependencies
        this.editMenu = new EditMenu(ingredientService, mealService);
        this.mealPlanningMenu = new MealPlanningMenu( mealPlanService);

        //Set menu information
        menuName = "Main Menu";
        menuOptions = new String[]{
                "View/Edit Ingredients & Meals",
                "Meal Planning"};

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
