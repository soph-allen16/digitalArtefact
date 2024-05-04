package controller;

import utils.fileUtils.IngredientFileUtil;
import utils.fileUtils.MealPlanFileUtil;
import utils.fileUtils.MealsFileUtil;
import view.levelOneMenu.MainMenu;
import model.service.IngredientService;
import utils.InputHelper;
import model.service.MealPlanService;
import model.service.MealService;

public class Controller {

    private final MainMenu mainMenu;
    private final IngredientService ingredientService;
    private final MealService mealService;
    private final MealPlanService mealPlanService;

    //Creates initial entities and passes them to the main menu, closes resources when the application finishes and saves entities to csv
    public Controller(){
        this.ingredientService = new IngredientService();
        this.mealService = new MealService(ingredientService);
        this.mealPlanService = new MealPlanService(mealService);
        this.mainMenu = new MainMenu(ingredientService, mealService, mealPlanService);

        IngredientFileUtil.saveIngredientsToFile(ingredientService.getIngredientsList());
        MealsFileUtil.saveMealsToFile(mealService.getMeals());
        MealPlanFileUtil.saveMealPlansToFile(mealPlanService.getMealPlans());
        InputHelper.closeScanner();
    }

}
