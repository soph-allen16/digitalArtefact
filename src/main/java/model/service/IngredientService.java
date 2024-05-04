package model.service;


import model.repository.IngredientRepository;
import utils.InputHelper;
import model.entity.Ingredient;
import utils.TableHelper;

import java.util.List;
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
        String name = InputHelper.getStringInput("Please enter the name of the ingredient");
        String unit = InputHelper.getStringInput("Please enter a unit of measurement");
        ingredientRepository.addIngredient( name, unit );
    }

    //Allows creation of ingredient with values passed
    //Used when creating a meal with ingredients which do not already exist
    public Ingredient addIngredient(String name, String unit){
        return ingredientRepository.addIngredient(name, unit);
    }

    //Searches for ingredient using name
    public Ingredient findIngredientByName(String name){
         return ingredientRepository.findIngredientByName(name);
    }

    //Allows ingredient to be deleted
    //Verify that it exists, and prompts user to confirm deletion.
    public void deleteIngredient() {
        int id = InputHelper.getIntegerInput("Enter the ID of the ingredient you would like to delete");
        Ingredient ingredient = ingredientRepository.findIngredientById(id);

        if (ingredient == null) {
            System.out.println("No ingredient found with the ID you entered.");
        } else {
            System.out.println("Delete " + ingredient.getIngredientName() + " ? Y/N ");
            String input = InputHelper.getStringInput();

            if (input.equalsIgnoreCase("y")) {
                ingredientRepository.removeIngredient(ingredient);
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("Ingredient not deleted.");
            } else {
                System.out.println("Invalid input - please try again.");
            }
        }
    }
}

