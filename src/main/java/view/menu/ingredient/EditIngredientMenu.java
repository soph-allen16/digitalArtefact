package view.menu.ingredient;

import utils.InputHelper;
import view.service.IngredientService;

public class EditIngredientMenu {

    private final IngredientService ingredientService;
    private final InputHelper inputHelper;

    private final ModifyIngredientMenu modifyIngredientMenu;

    public EditIngredientMenu(InputHelper inputHelper, IngredientService ingredientService){
        this.inputHelper = inputHelper;
        this.ingredientService = ingredientService;
        this.modifyIngredientMenu = new ModifyIngredientMenu(inputHelper, ingredientService);
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
                    4: Delete ingredient
                    5: Return
                    Please select (1-5)
                    """);

            int choice = inputHelper.getIntegerInput();

            if(choice == 1){
                ingredientService.viewIngredientList();
            } else if (choice == 2) {
                ingredientService.addIngredient();
            }else if(choice ==3) {
                modifyIngredientMenu.runMenu();
            }else if ( choice == 4){
                ingredientService.deleteIngredient();
            }else if (choice == 5){
                tryAgain = false;
            }else{
                System.out.println("Incorrect input, please try again.");
            }
        }while( tryAgain );
    }

}
