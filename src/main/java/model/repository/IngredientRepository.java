package model.repository;

import utils.InputHelper;
import model.entity.Ingredient;
import java.util.ArrayList;
import java.util.List;

public class IngredientRepository {
    private final InputHelper inputHelper;
    private final List<Ingredient> ingredientList;

    private int counter = 0;

    public IngredientRepository(InputHelper inputHelper){
        this.inputHelper = inputHelper;
        ingredientList = new ArrayList<Ingredient>();
    }

    public List<Ingredient> getAllIngredients(){
        return this.ingredientList;
    }

    public void addIngredient(String ingredientName, String ingredientType){
        Ingredient ingredient = new Ingredient( ingredientName, ingredientType, counter + 1);
        if( ingredientList.contains(ingredient) ){
            System.out.println("This ingredient is already in the list");
        }else{
            ingredientList.add(ingredient);
            counter ++;
        }
    }

    public void removeIngredient( Ingredient ingredient ){
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

    public Ingredient findIngredientById(int id){
        for( Ingredient i : ingredientList ) {
            if ( i.getIngredientId() == id ) {
                return i;
            }
        }
        return null;
    }

    public void updateIngredient(Ingredient ingredient){
        Ingredient oldIngredient = findIngredientById(ingredient.getIngredientId());
        int index = ingredientList.indexOf(oldIngredient);
        ingredientList.set(index, ingredient);
    }

}
