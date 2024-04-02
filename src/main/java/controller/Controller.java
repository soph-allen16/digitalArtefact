package controller;

import view.menu.MainMenu;
import view.service.IngredientService;
import utils.InputHelper;
import view.service.MealService;

public class Controller {
    private final InputHelper inputHelper;
    private final MainMenu mainMenu;
    private final IngredientService ingredientService;
    private final MealService mealService;

    //Creates initial entities and passes them to the main menu, closes resources when the application finishes
    public Controller(){
        this.inputHelper = new InputHelper();
        this.ingredientService = new IngredientService(inputHelper);
        this.mealService = new MealService(inputHelper, ingredientService);
        this.mainMenu = new MainMenu(inputHelper, ingredientService, mealService);
        inputHelper.closeScanner();
    }

}
