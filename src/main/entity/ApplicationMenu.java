package main.entity;

import main.utils.InputHelper;

public class ApplicationMenu {
    private final User user;
    private final InputHelper inputHelper;

    private final IngredientService ingredientService;

    public ApplicationMenu(InputHelper inputHelper) {
        this.inputHelper = inputHelper;
        this.user = new User(inputHelper);
        this.ingredientService = new IngredientService(inputHelper);
        menu();
    }

    private void menu() {
        boolean tryAgain = false;

        do {
            tryAgain = false;
            System.out.println("""
                    \r\n
                    You have 4 choices:
                    1: See your details
                    2: View ingredient list
                    3: Add ingredient
                    Please select (1-3)
                    """);

            int choice = inputHelper.getIntegerInput();

            if (choice == 1) {
                System.out.println(user.getUserSummary());
                tryAgain = true;
            } else if (choice == 2) {
                ingredientService.viewIngredientList();
                tryAgain = true;
            } else if (choice == 3) {
                ingredientService.addIngredient();
                tryAgain = true;
            } else {
                System.out.println("incorrect input. Please try again");
                tryAgain = true;
            }
        } while (tryAgain);

    }
}
