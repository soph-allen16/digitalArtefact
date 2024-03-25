package view;

import view.service.IngredientService;
import model.entity.User;
import utils.InputHelper;

public class MainMenu {
    //private final User user;
    private final InputHelper inputHelper;

    private final ViewEditMenu viewEditMenu;
    private final IngredientService ingredientService;

    public MainMenu(InputHelper inputHelper) {
        this.inputHelper = inputHelper;
        this.viewEditMenu = new ViewEditMenu(inputHelper);
        //this.user = new User(inputHelper);
        this.ingredientService = new IngredientService(inputHelper);
        runMenu();
    }

    private void runMenu() {
        boolean tryAgain = false;

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
                viewEditMenu.runMenu();
                tryAgain = true;
            } else if (choice == 2) {
                ingredientService.viewIngredientList();
                tryAgain = true;
            } else if (choice == 3) {
                tryAgain = false;
                //System.exit(0);
            } else {
                System.out.println("incorrect input. Please try again");
                tryAgain = true;
            }
        } while (tryAgain);

    }
}
