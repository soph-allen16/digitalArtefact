package view.levelOneMenu;

import model.service.IngredientService;
import model.service.MealPlanService;
import model.service.MealService;
import view.levelTwoMenu.IngredientMenu;
import view.levelTwoMenu.MealMenu;
import view.levelTwoMenu.MealPlanningMenu;
import view.Menu;

public class MainMenu extends Menu {
    private final MealPlanningMenu mealPlanningMenu;
    private final IngredientMenu ingredientMenu;
    private final MealMenu mealMenu;


    public MainMenu(IngredientService ingredientService,
                    MealService mealService,
                    MealPlanService mealPlanService, MealMenu mealMenu){
        super();
        //Initialise dependencies
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

    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain) {
            if (choice == 1) {
                ingredientMenu.runMenu();
            }else if (choice == 2) {
                mealMenu.runMenu();
            }else if(choice==3){
                mealPlanningMenu.runMenu();
            }
            super.runMenu();
        }
    }
}
