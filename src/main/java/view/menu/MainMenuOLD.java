//package view.menu;
//
//import utils.InputHelper;
//import view.service.IngredientService;
//import view.service.MealService;
//
//import javax.swing.*;
//
//// Main menu for the application, provides options for the user and forwards them to their desired functionality.
//public class MainMenu {
//
//    private final InputHelper inputHelper;
//    private final EditMenu editMenu;
//    private final IngredientService ingredientService;
//    private final MealService mealService;
//
//    //Initialise dependencies and run the menu
//    public MainMenu(InputHelper inputHelper,
//                    IngredientService ingredientService,
//                    MealService mealService) {
//        this.inputHelper = inputHelper;
//        this.ingredientService = ingredientService;
//        this.mealService = mealService;
//        this.editMenu = new EditMenu(inputHelper, ingredientService, mealService);
//        runMenu();
//    }
//
//    // Collects user input and directs them on. Menu finishes and application ends when the while loop is ended by setting the tryAgain variable to false.
//    private void runMenu() {
//        boolean tryAgain = true;
//
//        do {
//            System.out.println("""
//                    \r\n
//                    ***** Main Menu *****
//                    1: View/Edit Ingredients & Meals
//                    2: Meal Planning
//                    3: Exit Application
//                    Please select (1-3)
//                    """);
//
//            int choice = inputHelper.getIntegerInput();
//
//            if (choice == 1) {
//                editMenu.runMenu();
//            } else if (choice == 2) {
//                ingredientService.viewIngredientList();
//            } else if (choice == 3) {
//                tryAgain = false;
//            } else {
//                System.out.println("incorrect input. Please try again");
//            }
//        } while (tryAgain);
//
//    }
//}
