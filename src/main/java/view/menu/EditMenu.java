package view.menu;

import utils.InputHelper;
import view.menu.meal.MealMenu;
import view.service.IngredientService;
import view.menu.ingredient.IngredientMenu;
import view.service.MealService;

public class EditMenu extends Menu {
    private final IngredientMenu ingredientMenu;
    private final MealMenu mealMenu;

    public EditMenu(InputHelper inputHelper,
                    IngredientService ingredientService,
                    MealService mealService){
        super(inputHelper);
        //Initialise Dependencies
        this.ingredientMenu = new IngredientMenu(inputHelper, ingredientService);
        this.mealMenu = new MealMenu(inputHelper, mealService);

        //Initialise menu-specific fields
        menuName = "Edit Ingredients/ Meals";
        options = new String[] {"View/Edit Ingredients","View/Edit Meals"};

    }

    @Override
    public void runMenu(){
        while(tryAgain){
            super.runMenu();

            if(choice == 1){
                ingredientMenu.runMenu();
            }if(choice == 2){
                mealMenu.runMenu();
            }else{
                System.out.println("Incorrect input. Please try again.");
            }

        }
    }
}
