package controller;

import view.menu.MainMenu;
import view.service.IngredientService;
import utils.InputHelper;
import view.service.MealPlanService;
import view.service.MealService;

public class Controller {

    private final MainMenu mainMenu;
    private final IngredientService ingredientService;
    private final MealService mealService;
    private final MealPlanService mealPlanService;

    //Creates initial entities and passes them to the main menu, closes resources when the application finishes
    public Controller(){
        this.ingredientService = new IngredientService();
        this.mealService = new MealService(ingredientService);
        this.mealPlanService = new MealPlanService(mealService);
        this.mainMenu = new MainMenu(ingredientService, mealService, mealPlanService);
        InputHelper.closeScanner();
    }

}
