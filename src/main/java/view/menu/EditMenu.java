package view.menu;

import utils.InputHelper;
import view.menu.meal.EditMealMenu;
import view.service.IngredientService;
import view.menu.ingredient.EditIngredientMenu;
import view.service.MealService;

import java.awt.*;

public class EditMenu {
    private final InputHelper inputHelper;
    private final EditIngredientMenu editIngredientMenu;
    private final EditMealMenu editMealMenu;

    public EditMenu(InputHelper inputHelper,
                    IngredientService ingredientService,
                    MealService mealService){
        this.inputHelper = inputHelper;
        this.editIngredientMenu = new EditIngredientMenu(inputHelper, ingredientService);
        this.editMealMenu = new EditMealMenu(inputHelper, mealService);
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
                editIngredientMenu.runMenu();
            }if(choice == 2){
                editMealMenu.runMenu();
            }if(choice == 3){
                tryAgain = false;
            }else{
                System.out.println("Incorrect input. Please try again.");
            }

        }while(tryAgain);

    }
}
