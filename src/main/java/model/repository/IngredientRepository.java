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

    public boolean modifyIngredient(String name){
        if (  findIngredient(name) == null ){
            System.out.println("The ingredient you entered does not exist.");
            return false;
        }else{
            Ingredient old = findIngredient(name);
            Ingredient newIngredient = new Ingredient( name, old.getIngredientType() );
            return true;
        }
    }

    public Ingredient findIngredient(String name){
        for( Ingredient i : ingredientList ) {
            if (i.getIngredientName().equals(name)) {
                return i;
            }
        }
        return null;
    }
}
