package model.repository;

import model.entity.Ingredient;
import utils.InputHelper;


import java.util.ArrayList;
import java.util.List;

public class IngredientRepository {
    private final InputHelper inputHelper;
    private final List<Ingredient> ingredientList;

    public IngredientRepository(InputHelper inputHelper){
        this.inputHelper = inputHelper;
        ingredientList = new ArrayList<Ingredient>();
    }

    public List<Ingredient> getAllIngredients(){
        return this.ingredientList;
    }

    public void addIngredient(String ingredientName, String ingredientType){
        Ingredient ingredient = new Ingredient(ingredientName, ingredientType);
        if( ingredientList.contains(ingredient) ){
            System.out.println("This ingredient is already in the list");
        }else{
            ingredientList.add(ingredient);
        }
    }

    public void removeIngredient( String name ){
        Ingredient ingredient = findIngredientByName( name );

        if( ingredient == null ){
            System.out.println("The ingredient you entered does not exist.");
        }else{
            ingredientList.remove(ingredient);
        }
    }

    public Ingredient findIngredientByName(String name){
        for( Ingredient i : ingredientList ) {
            if (i.getIngredientName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public void modifyIngredientMenu(Ingredient ingredient){
        if (  ingredient == null ){
            System.out.println("The ingredient you entered does not exist.");
        }else{
            boolean tryAgain = true;

            while(tryAgain) {
                System.out.println("Ingredient: " + ingredient.getIngredientName() + " Type: " + ingredient.getIngredientType());
                System.out.println("""
                        1: Modify name
                        2: Modify type
                        3: Save
                        4: Cancel
                        """);
                int choice = inputHelper.getIntegerInput();

                if( choice == 1 ){

                }else if( choice == 2 ){

                }else if( choice == 3 ){

                }else if( choice == 4 ){

                }else{
                    System.out.println("Invalid input. Please try again.");
                }
            }

        }
    }

}
