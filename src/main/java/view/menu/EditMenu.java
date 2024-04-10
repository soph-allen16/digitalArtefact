package view.menu;

import utils.InputHelper;
import view.menu.meal.MealMenu;
import view.service.IngredientService;
import view.menu.ingredient.IngredientMenu;
import view.service.MealService;

public class EditMenu {
    private final InputHelper inputHelper;
    private final IngredientMenu ingredientMenu;
    private final MealMenu mealMenu;

    public EditMenu(InputHelper inputHelper,
                    IngredientService ingredientService,
                    MealService mealService){
        this.inputHelper = inputHelper;
        this.ingredientMenu = new IngredientMenu(inputHelper, ingredientService);
        this.mealMenu = new MealMenu(inputHelper, mealService);
    }

    public void runMenu(){

        boolean tryAgain = true;

        do{
            System.out.println("""
                    \r\n
                    ***** View & Edit *****
                    1: View/Edit Ingredients
                    2: View/Edit Meals
                    3: Return
                    Please select (1-3)
                    """);

            int choice = inputHelper.getIntegerInput();

            if(choice == 1){
                ingredientMenu.runMenu();
            }if(choice == 2){
                mealMenu.runMenu();
            }if(choice == 3){
                tryAgain = false;
            }else{
                System.out.println("Incorrect input. Please try again.");
            }

        }while(tryAgain);

    }
}
