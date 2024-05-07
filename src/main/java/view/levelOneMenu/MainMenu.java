package view.levelOneMenu;

import model.service.IngredientService;
import model.service.MealPlanService;
import model.service.MealService;
import view.levelTwoMenu.IngredientMenu;
import view.levelTwoMenu.MealMenu;
import view.levelTwoMenu.MealPlanningMenu;
import view.Menu;

public class MainMenu extends Menu {
    private final IngredientMenu ingredientMenu;
    private final MealMenu mealMenu;
    private final MealPlanningMenu mealPlanningMenu;

    public MainMenu(IngredientService ingredientService,
                    MealService mealService,
                    MealPlanService mealPlanService){
        super();
        //Initialise fields
        this.ingredientMenu = new IngredientMenu(ingredientService);
        this.mealMenu = new MealMenu(mealService);
        this.mealPlanningMenu = new MealPlanningMenu( mealPlanService);

        //Set menu information
        menuName = "Main Menu";
        menuOptions = new String[]{
                "View/Edit Ingredients",
                "View/Edit Meals",
                "Meal Planning"};

        //Run the main menu - begin process
        runMenu();
    }

    //Loops through a main menu until user chooses to exit the application
    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain) {
            if (choice == 1) {
                //View or edit ingredients
                ingredientMenu.runMenu();
            }else if (choice == 2) {
                //View or edit meals
                mealMenu.runMenu();
            }else if(choice==3){
                //Create a meal plan
                mealPlanningMenu.runMenu();
            }
            super.runMenu();
        }
    }
}
