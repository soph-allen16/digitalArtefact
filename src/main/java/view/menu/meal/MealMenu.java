package view.menu.meal;

import utils.InputHelper;
import view.service.MealService;

public class MealMenu {

    private final MealService mealService;
    private final InputHelper inputHelper;

    public MealMenu(InputHelper inputHelper, MealService mealService){
        this.inputHelper = inputHelper;
        this.mealService = mealService;
    }

    public void runMenu(){
        boolean tryAgain = true;

        do{
            System.out.println("""
                    \r\n
                    ***** View/Edit Ingredients *****
                    1: View list of meals
                    2: View meal details
                    3: Add meal
                    4: Edit meal
                    5: Delete meal
                    6: Return
                    Please select (1-6)
                    """);

            int choice = inputHelper.getIntegerInput();

            if(choice == 1){
                mealService.viewMealList();
            } else if (choice == 2) {
                mealService.viewMealDetails(inputHelper.getIntegerInput("Enter a meal ID"));
            }else if(choice == 3) {
                mealService.addMeal();
            }else if ( choice == 4){

            }else if (choice == 5){
                tryAgain = false;
            }else{
                System.out.println("Incorrect input, please try again.");
            }
        }while( tryAgain );
    }

}
