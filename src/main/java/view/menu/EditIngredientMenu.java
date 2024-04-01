package view.menu;

import utils.InputHelper;
import view.service.IngredientService;

public class EditIngredientMenu {

    private final IngredientService ingredientService;
    private final InputHelper inputHelper;

    public EditIngredientMenu(InputHelper inputHelper, IngredientService ingredientService){
        this.inputHelper = inputHelper;
        this.ingredientService = ingredientService;
    }

    public void runMenu(){
        boolean tryAgain = true;

        do{
            System.out.println("""
                    \r\n
                    ***** View/Edit Ingredients *****
                    1: View ingredients list
                    2: Add ingredient
                    3: Edit ingredient
                    4: Return
                    Please select (1-4)
                    """);

            int choice = inputHelper.getIntegerInput();

            if(choice == 1){
                ingredientService.viewIngredientList();
            } else if (choice == 2) {
                ingredientService.addIngredient();
            } else if (choice ==4){
                tryAgain = false;
            }else{
                System.out.println("Incorrect input, please try again.");
            }
        }while( tryAgain );
    }

}
