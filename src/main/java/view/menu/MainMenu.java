package view.menu;

import utils.InputHelper;
import view.service.IngredientService;
import view.service.MealService;

public class MainMenu extends Menu {
    private final EditMenu editMenu;
    private final IngredientService ingredientService;
    private final MealService mealService;
    public MainMenu(InputHelper inputHelper,
                    IngredientService ingredientService,
                    MealService mealService) {
        super(inputHelper);

        this.ingredientService = ingredientService;
        this.mealService = mealService;
        this.editMenu = new EditMenu(inputHelper, ingredientService, mealService);

        menuName = "Main Menu";
        options = new String[]{"View/Edit Ingredients & Meals", "Meal Planning"};


        runMenu();
    }

    @Override
    protected void runMenu(){

        while(tryAgain) {
            super.runMenu();

            if (choice == 1) {
                editMenu.runMenu();
            } else if (choice == 2) {
                ingredientService.viewIngredientList();
            } else {
                System.out.println("incorrect input. Please try again");
            }
        }

        // Implemented inheritance -- else is always reached -- implement try-catch instead???
    }

}
