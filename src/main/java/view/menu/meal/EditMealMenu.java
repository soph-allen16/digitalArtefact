package view.menu.meal;

import utils.InputHelper;
import view.service.MealService;

public class EditMealMenu {

    private final MealService mealService;
    private final InputHelper inputHelper;

    public EditMealMenu(InputHelper inputHelper, MealService mealService){
        this.inputHelper = inputHelper;
        this.mealService = mealService;
    }

    public void runMenu(){
        boolean tryAgain = true;

        do{
            System.out.println("""
                    \r\n
                    ***** View/Edit Ingredients *****
                    1: Add Meal
                    2: 
                    3: 
                    4: 
                    5: Return
                    Please select (1-5)
                    """);

            int choice = inputHelper.getIntegerInput();

            if(choice == 1){
                mealService.addMeal();
//            } else if (choice == 2) {
//                ingredientService.addIngredient();
//            }else if(choice ==3) {
//                modifyIngredientMenu.runMenu();
//            }else if ( choice == 4){
//                ingredientService.deleteIngredient();
            }else if (choice == 5){
                tryAgain = false;
            }else{
                System.out.println("Incorrect input, please try again.");
            }
        }while( tryAgain );
    }

}
