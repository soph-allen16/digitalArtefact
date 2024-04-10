package view.menu.meal;

import model.entity.Ingredient;
import model.entity.Meal;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.text.TextStringBuilder;
import utils.InputHelper;
import view.service.MealService;

import java.util.HashMap;

public class EditMealMenu{
    private final MealService mealService;
    private final InputHelper inputHelper;
    private String mealName;
    private HashMap<Ingredient, Integer> ingredients;

    public EditMealMenu(InputHelper inputHelper, MealService mealService){
        this.inputHelper = inputHelper;
        this.mealService = mealService;
    }
    public void runMenu(Meal meal){
        if(meal == null){
            System.out.println("Cannot be performed.");
            return;
        }

        this.mealName = meal.getMealName();
        this.ingredients = meal.getIngredients();

        boolean tryAgain = true;

        do{
            printMeal();

            System.out.println("""
                    \r\n
                    ***** Edit meal *****
                    1: Edit meal name
                    2: Edit ingredients
                    3: Save
                    4: Cancel
                    Please select (1-4)
                    """);
            int input = inputHelper.getIntegerInput();

            if(input == 1){
                this.mealName = inputHelper.getStringInput("Enter a new name for this meal");
            }else if(input == 2){

            }else if( input == 3){

            }else if( input == 4){
                tryAgain = false;
            }else{

            }

        }while(tryAgain);
    }

    private void printMeal(){
        TextStringBuilder str = new TextStringBuilder();
        str.append("Name: ").append(this.mealName);
        str.appendNewLine();
        str.append("Ingredients:");

        for( Ingredient i : this.ingredients.keySet() ){
            str.appendNewLine();
            str.append("(Id: ")
                    .append(String.valueOf(i.getIngredientId())).append(") ").append(i.getIngredientName())
                    .append(" x ")
                    .append(String.valueOf(this.ingredients.get(i))).append(" ").append(i.getUnit());
        }
        System.out.println(str.build());
    }
}
