package model.repository;

import utils.InputHelper;
import model.entity.Ingredient;
import utils.fileUtils.IngredientFileUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
//Repository class for ingredients - stores the full list of saved ingredients and allows creation and deletion
public class IngredientRepository {
    private final List<Ingredient> ingredientList;

    private int counter = 0;

    //Read ingredients list from csv file
    //Initialise counter above the maximum ID value in the list - so all new entries get a unique ID.
    public IngredientRepository(){
        ingredientList = IngredientFileUtil.readIngredientsFromFile();
        counter = ingredientList.isEmpty() ? 0 : ingredientList.stream().max(Comparator.comparing(Ingredient::getIngredientId)).get().getIngredientId() + 1;
    }

    //Returns full list of ingredients
    public List<Ingredient> getAllIngredients(){
        return this.ingredientList;
    }

    //Checks if the ingredient already exists and adds it to the list
    public Ingredient addIngredient(String ingredientName, String unit){
        Ingredient ingredient = new Ingredient(counter, ingredientName, unit);

        if(ingredientList.contains(ingredient)){
            throw new UnsupportedOperationException("Ingredient already exists: cannot be created");
        }else{
            ingredientList.add(ingredient);
            counter++;
            return ingredient;
        }
    }

    //Checks if an ingredient exists and deletes it from the list
    public void removeIngredient( Ingredient ingredient ){
        if( ingredient == null ){
            throw new NoSuchElementException("Ingredient does not exist: cannot be deleted");
        }else{
            ingredientList.remove(ingredient);
        }
    }

    //Returns ingredient matching the string input if exists
    public Ingredient findIngredientByName(String name){
        for( Ingredient i : ingredientList ) {
            if (i.getIngredientName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }

    //Returns ingredient matching the ID input if exists
    public Ingredient findIngredientById(int id){
        for( Ingredient i : ingredientList ) {
            if ( i.getIngredientId() == id ) {
                return i;
            }
        }
        return null;
    }

}
