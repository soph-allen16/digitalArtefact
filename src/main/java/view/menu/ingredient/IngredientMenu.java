package view.menu.ingredient;

import view.menu.Menu;
import model.service.IngredientService;

public class IngredientMenu extends Menu {
    private final IngredientService ingredientService;

    public IngredientMenu(IngredientService ingredientService){
        super();

        //Initialise dependencies
        this.ingredientService = ingredientService;

        //Initialise menu items
        menuName = "View/Edit Ingredients";
        menuOptions = new String[] {
                "View ingredients list",
                "Add ingredient",
                "Edit ingredient name",
                "Delete ingredient" };
    }

    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain){
            if(choice == 1){
                ingredientService.viewIngredientList();
            } else if (choice == 2) {
                ingredientService.addIngredient();
            }else if (choice == 3 ){
//                ingredientService.editIngredient();
            }else if(choice == 4) {
                ingredientService.deleteIngredient();
            }
            super.runMenu();
        }
    }

}
