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

        boolean tryAgain = true;
        while(tryAgain) {
            Ingredient newIngredient = ingredient ;

            System.out.println(  "\r\n Ingredient: " + ingredient.getIngredientName() + " Type: " + ingredient.getIngredientType());
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
                String newName = inputHelper.getStringInput("Please enter a name");
                newIngredient.setIngredientName( newName );
            }else if( choice == 2 ){
                String newType = inputHelper.getStringInput("Please enter a type");
                newIngredient.setIngredientType( newType );
            }else if( choice == 3 ){
                ingredientService.updateIngredient(newIngredient);
                tryAgain = false;
            }else if( choice == 4 ){
                tryAgain = false;
            }else{
                System.out.println("Invalid input. Please try again.");
            }

        }
    }
}
