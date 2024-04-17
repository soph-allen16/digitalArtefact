package view.menu.meal;

import model.entity.Ingredient;
import model.entity.Meal;
import utils.InputHelper;
import view.menu.Menu;
import view.service.MealService;
import java.util.HashMap;

public class EditMealMenu extends Menu {
    private final MealService mealService;
    private String mealName;
    private HashMap<Ingredient, Integer> ingredients;

    public EditMealMenu(InputHelper inputHelper, MealService mealService) {
        super(inputHelper);
        this.mealService = mealService;

        menuName = "Edit meal";
        options = new String[] {
                "Edit meal name",
                "Edit ingredients",
                "Save changes" };
    }
    public void runMenu(Meal meal){
        if(meal == null){
            System.out.println("Cannot be performed.");
            return;
        }

        this.mealName = meal.getMealName();
        this.ingredients = meal.getIngredients();

        printMeal();
        super.runMenu();
        while (tryAgain){
            if(choice == 1){
                this.mealName = inputHelper.getStringInput("Enter a new name for this meal");
            }else if(choice == 2){
                System.out.println("This is not possible.");
            }else if( choice == 3){
                mealService.editMealName(meal.getMealId(), mealName);
                tryAgain = false;
            }
            printMeal();
            super.runMenu();
        }
}

    private void printMeal(){
        StringBuilder str = new StringBuilder();
        str.append("\r\nName: ").append(this.mealName);
        str.append("\r\nIngredients:");

        for( Ingredient i : this.ingredients.keySet() ){
            str.append("\r\n(Id: ")
                    .append(i.getIngredientId()).append(") ").append(i.getIngredientName())
                    .append(" x ")
                    .append(this.ingredients.get(i)).append(" ").append(i.getUnit());
        }
        System.out.println(str.toString());
    }

//    private void changeIngredients(int id){
//        if( this.ingredients.keySet().contains(id) ){
//            String name = inputHelper.getStringInput("Please enter   ")
//        }else{
//            System.out.println("No ingredient with id: "+ id + " in the list.");
//        }
//    }
}
