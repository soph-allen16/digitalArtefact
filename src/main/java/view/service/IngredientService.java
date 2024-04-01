package view.service;


import model.repository.IngredientRepository;
import utils.InputHelper;
import model.entity.Ingredient;

public class IngredientService {
    private final InputHelper inputHelper;
    private final IngredientRepository ingredientRepository;

    public IngredientService(InputHelper inputHelper){
        this.inputHelper = inputHelper;
        this.ingredientRepository = new IngredientRepository(this.inputHelper);
    }

    public void viewIngredientList(){
        System.out.println("\r\n ID | Name | Type");
        for(Ingredient i : ingredientRepository.getAllIngredients()){
            System.out.println(i.getIngredientId() + "   " + i.getIngredientName() + "   " + i.getIngredientType());
        }
    }

    public void addIngredient(){
        String name = inputHelper.getStringInput("Please enter the name of the ingredient");
        String type = inputHelper.getStringInput("please enter an ingredient type");
        ingredientRepository.addIngredient( name, type );
    }

    public void modifyIngredient(){
        int id = inputHelper.getIntegerInput("Enter the ID of the ingredient you would like to modify");
        ingredientRepository.modifyIngredientMenu( ingredientRepository.findIngredientById(id) );
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
}
