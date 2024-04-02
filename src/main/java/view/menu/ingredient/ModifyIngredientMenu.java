package view.menu.ingredient;

import model.entity.Ingredient;
import utils.InputHelper;
import view.service.IngredientService;

public class ModifyIngredientMenu {

    private final InputHelper inputHelper;
    private final IngredientService ingredientService;

    public ModifyIngredientMenu(InputHelper inputHelper, IngredientService ingredientService){
        this.inputHelper = inputHelper;
        this.ingredientService = ingredientService;
    }

    public void runMenu(){
        Ingredient ingredient = ingredientService.findIngredientById();

        if(ingredient == null){
            System.out.println("The ingredient you entered does not exist.");
            return;
        }

        String newName = ingredient.getIngredientName();
        String newType = ingredient.getIngredientType();

        boolean tryAgain = true;
        while(tryAgain) {

            System.out.println( "\r\nIngredient: " + newName);
            System.out.println("Type: " + newType);
            System.out.println("""
                        \r\n
                        1: Modify name
                        2: Modify type
                        3: Save
                        4: Cancel
                        Please select (1-4)
                        """);
            int choice = inputHelper.getIntegerInput();

            if( choice == 1 ){
                newName = inputHelper.getStringInput("Please enter a name");
            }else if( choice == 2 ){
                newType = inputHelper.getStringInput("Please enter a type");
            }else if( choice == 3 ){
                ingredientService.updateIngredient(ingredient, newName, newType);
                tryAgain = false;
            }else if( choice == 4 ){
                tryAgain = false;
            }else{
                System.out.println("Invalid input. Please try again.");
            }

        }
    }
}
