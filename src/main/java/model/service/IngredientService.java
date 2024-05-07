package model.service;


import model.repository.IngredientRepository;
import utils.InputHelper;
import model.entity.Ingredient;
import utils.TableHelper;

import java.util.List;
import java.util.NoSuchElementException;

//Service class for ingredients providing interface between menu and repository, getting user input
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(){
        this.ingredientRepository = new IngredientRepository();
    }

    //View tabular list of all saved ingredients
    public void viewIngredientList(){
        TableHelper.printTwoColumnTable(TableHelper.createIngredientTableFromList(ingredientRepository.getAllIngredients()), new String[] {"ID", "Name"});
    }

    //Return list of ingredients for saving to file
    public List<Ingredient> getIngredientsList(){
        return ingredientRepository.getAllIngredients();
    }

    //Gathers all user inputs to create a new ingredient and passes to repository
    public void addIngredient(){
        addIngredient(InputHelper.getStringInput("Please enter the name of the ingredient"), InputHelper.getStringInput("Please enter a unit of measurement"));
    }

    //Allows creation of ingredient with values passed
    //Used when creating a meal with ingredients which do not already exist
    public Ingredient addIngredient(String name, String unit){
        try {
            return ingredientRepository.addIngredient(name, unit);
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    //Searches for ingredient using name
    public Ingredient findIngredientByName(String name){
         return ingredientRepository.findIngredientByName(name);
    }

    //Allows ingredient to be deleted
    //Verify that it exists, and prompts user to confirm deletion.
    public void deleteIngredient(int id) {
        Ingredient ingredient = ingredientRepository.findIngredientById(id);

        try {
            if (ingredient == null) {
                throw new NoSuchElementException("Element does not exist. Cannot be deleted.");
            } else {
                System.out.println("Delete " + ingredient.getIngredientName() + " ? Y/N ");
                String input = InputHelper.getStringInput();

                if (input.equalsIgnoreCase("y")) {
                    ingredientRepository.removeIngredient(ingredient);
                } else if (input.equalsIgnoreCase("n")) {
                    throw new UnsupportedOperationException("Not deleted. User cancelled.");
                } else {
                    throw new IllegalArgumentException("Input must be 'y' or 'n', ingredient not deleted.");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

