package view.menu;

import view.menu.meal.MealMenu;
import view.service.IngredientService;
import view.menu.ingredient.IngredientMenu;
import view.service.MealService;

public class EditMenu extends Menu {
    private final IngredientMenu ingredientMenu;
    private final MealMenu mealMenu;

    public EditMenu(IngredientService ingredientService,
                    MealService mealService){
        super();

        //Initialise Dependencies
        this.ingredientMenu = new IngredientMenu( ingredientService);
        this.mealMenu = new MealMenu( mealService);

        //Initialise menu-specific fields
        menuName = "Edit Ingredients/ Meals";
        menuOptions = new String[] {
                "View/Edit Ingredients",
                "View/Edit Meals"
        };
    }

    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain){
            if(choice == 1){
                ingredientMenu.runMenu();
            }else if(choice == 2){
                mealMenu.runMenu();
            }
            super.runMenu();
        }
    }
}
