package view.menu;

import utils.InputHelper;
import view.service.IngredientService;

public class MainMenu {
    //private final User user;
    private final InputHelper inputHelper;

    private final EditMenu editMenu;
    private final IngredientService ingredientService;

    public MainMenu(InputHelper inputHelper, IngredientService ingredientService) {
        this.inputHelper = inputHelper;
        //this.user = new User(inputHelper);
        this.ingredientService = ingredientService;
        this.editMenu = new EditMenu(inputHelper, ingredientService);
        runMenu();
    }

    private void runMenu() {
        boolean tryAgain = true;

        do {
            System.out.println("""
                    \r\n
                    ***** Main Menu *****
                    1: View/Edit Ingredients & Meals
                    2: Meal Planning
                    3: Exit Application
                    Please select (1-3)
                    """);

            int choice = inputHelper.getIntegerInput();

            if (choice == 1) {
                editMenu.runMenu();
            } else if (choice == 2) {
                ingredientService.viewIngredientList();
            } else if (choice == 3) {
                tryAgain = false;
                //System.exit(0);
            } else {
                System.out.println("incorrect input. Please try again");
            }
        } while (tryAgain);

    }
}
