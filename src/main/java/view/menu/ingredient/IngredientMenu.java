package view.menu.ingredient;

import utils.InputHelper;
import view.menu.Menu;
import view.service.IngredientService;

public class IngredientMenu extends Menu {
    private final IngredientService ingredientService;

    public IngredientMenu(InputHelper inputHelper, IngredientService ingredientService){
        super(inputHelper);
        this.ingredientService = ingredientService;

        menuName = "View/Edit Ingredients";

        String[] list = {
                "View ingredients list",
                "Add ingredient",
                "Edit ingredient",
                "Delete ingredient",
                "Return"
        };

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
                ingredientService.editIngredient();
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
