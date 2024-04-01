package view.menu;

import utils.InputHelper;
import view.service.IngredientService;

public class EditMenu {
    private final InputHelper inputHelper;

    private final IngredientService ingredientService;
    private final EditIngredientMenu editIngredientMenu;

    public EditMenu(InputHelper inputHelper, IngredientService ingredientService){
        this.inputHelper = inputHelper;
        this.ingredientService = ingredientService;
        this.editIngredientMenu = new EditIngredientMenu(inputHelper, ingredientService);
    }

    public void runMenu(){

        boolean tryAgain = true;

        do{
            System.out.println("""
                    \r\n
                    ***** View & Edit *****
                    1: View/Edit Ingredients
                    2: View/Edit Meals
                    3: Return
                    Please select (1-3)
                    """);

            int choice = inputHelper.getIntegerInput();

            if(choice == 1){
                editIngredientMenu.runMenu();
            }if(choice == 2){

            }if(choice == 3){
                tryAgain = false;
            }

        }while(tryAgain);

    }
}
