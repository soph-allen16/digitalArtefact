package model.repository;

import utils.InputHelper;
import model.entity.Ingredient;
import utils.fileUtils.IngredientFileUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class IngredientRepository {
    private final List<Ingredient> ingredientList;

    private int counter = 0;

    public IngredientRepository(){
        ingredientList = IngredientFileUtil.readIngredientsFromFile();
        counter = ingredientList.stream().max(Comparator.comparing(Ingredient::getIngredientId)).orElseThrow(NoSuchElementException::new    );
    }

    public List<Ingredient> getAllIngredients(){
        return this.ingredientList;
    }


    public Ingredient addIngredient(String ingredientName, String unit){
        Ingredient ingredient = addIngredient(ingredientName);

        if(ingredient != null){
            ingredient.setUnit(unit);
        }

        return ingredient;
    }

    public Ingredient addIngredient(String ingredientName){
        Ingredient ingredient = new Ingredient(counter, ingredientName);

        if(ingredientList.contains(ingredient)){
            System.out.println("This ingredient is already in the list");
            return null;
        }else{
            ingredientList.add(ingredient);
            counter++;
            return ingredient;
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
            if (i.getIngredientName().equalsIgnoreCase(name)) {
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

//    public void updateIngredient(int id, String newName){
//        Ingredient ingredient = findIngredientById(id);
//
//        //null if ingredient doesn't already exist - can't be found
//        Ingredient alreadyExists = findIngredientByName(newName);
//
//        if(ingredient == null ){
//            System.out.println("This operation cannot be performed: Ingredient with the id: " + id + " does not exist.");
//        }else if( (alreadyExists != null) && (ingredient.getIngredientId() != alreadyExists.getIngredientId()) ){
//            System.out.println("This operation cannot be performed: ingredient with this name already exists");
//        }else if( ! newName.isBlank() ) {
//            ingredient.setIngredientName(newName);
//        }
//    }
}
