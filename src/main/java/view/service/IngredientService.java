package view.service;


import model.repository.IngredientRepository;
import org.apache.commons.lang3.StringUtils;
import utils.InputHelper;
import model.entity.Ingredient;
import utils.TableHelper;

import java.util.stream.Stream;

public class IngredientService {
    private final InputHelper inputHelper;
    private final IngredientRepository ingredientRepository;
    private final TableHelper tableHelper;

    public IngredientService(InputHelper inputHelper){
        this.tableHelper = new TableHelper( new String[] {"ID", "Name"} );
        this.inputHelper = inputHelper;
        this.ingredientRepository = new IngredientRepository(this.inputHelper);
    }

    public void viewIngredientList(){
        System.out.println(StringUtils.center("***** Ingredients *****", 49));
        //tableHelper.printIngredients(ingredientRepository.getAllIngredients());
        for(Ingredient i : ingredientRepository.getAllIngredients()){
            System.out.println(i.getIngredientId() + " "+ i.getIngredientName());
        }
    }


    public void addIngredient(){
        String name = inputHelper.getStringInput("Please enter the name of the ingredient");
        ingredientRepository.addIngredient( name );
    }

    public Ingredient addIngredient(String name){
        return ingredientRepository.addIngredient(name);
    }

    public Ingredient findIngredientById(){
        int id = inputHelper.getIntegerInput("Enter the ID of the ingredient you would like to modify");
        return ingredientRepository.findIngredientById(id);
    }

    public Ingredient findIngredientByName(String name){
         return ingredientRepository.findIngredientByName(name);
    }

    public void deleteIngredient(){
        int id = inputHelper.getIntegerInput("Enter the ID of the ingredient you would like to delete");
        Ingredient ingredient = ingredientRepository.findIngredientById(id);

        System.out.println("Delete " + ingredient.getIngredientName() + " ? Y/N ");
        String input = inputHelper.getStringInput();

        if( input.equalsIgnoreCase("y") ){
            ingredientRepository.removeIngredient(ingredient);
        }else if( input.equalsIgnoreCase("n")){
            System.out.println( "Ingredient not deleted.");
        }else{
            System.out.println("Invalid input - please try again.");
        }
    }

    public void editIngredient(){
        int choice = inputHelper.getIntegerInput("Please enter the ID of the ingredient you would like to rename"   );
        ingredientRepository.updateIngredient(choice, inputHelper.getStringInput("Enter a new name"));
    }
}
