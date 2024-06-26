package view.levelTwoMenu;

import model.service.IngredientService;
import utils.InputHelper;
import view.Menu;

public class IngredientMenu extends Menu {
    private final IngredientService ingredientService;

    public IngredientMenu(IngredientService ingredientService){
        super();
        //Initialise fields
        this.ingredientService = ingredientService;
        //Initialise menu items
        menuName = "View/Edit Ingredients";
        menuOptions = new String[] {
                "View ingredients list",
                "Add ingredient",
                "Delete ingredient" };
    }

    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain){
            if(choice == 1){
                //View ingredient list
                ingredientService.viewIngredientList();
            } else if (choice == 2) {
                //Add new ingredient
                ingredientService.addIngredient();
            }else if (choice==3){
                //delete ingredient
                ingredientService.deleteIngredient(InputHelper.getIntegerInput("Enter the ID of an ingredient"));
            }else if(choice == 4) {
                //Delete ingredient
                ingredientService.deleteIngredient(InputHelper.getIntegerInput("Enter the ID of the ingredient you would like to delete"));
            }
            super.runMenu();
        }
    }

}
