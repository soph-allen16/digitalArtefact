package view.service;


import model.repository.IngredientRepository;
import utils.InputHelper;
import model.entity.Ingredient;
import utils.TableHelper;


public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final TableHelper tableHelper;

    public IngredientService(){
        this.tableHelper = new TableHelper();
        this.ingredientRepository = new IngredientRepository();
    }

    public void viewIngredientList(){
        tableHelper.printTable(tableHelper.createIngredientTableFromList(ingredientRepository.getAllIngredients()), new String[] {"ID", "Name"}, "Ingredients" );
    }


    public void addIngredient(){
        String name = InputHelper.getStringInput("Please enter the name of the ingredient");
        String unit = InputHelper.getStringInput("Please enter a unit of measurement");
        ingredientRepository.addIngredient( name, unit );
    }

    public Ingredient addIngredient(String name, String unit){
        return ingredientRepository.addIngredient(name, unit);
    }


    public Ingredient findIngredientById(){
        int id = InputHelper.getIntegerInput("Enter the ID of the ingredient you would like to modify");
        return ingredientRepository.findIngredientById(id);
    }

    public Ingredient findIngredientByName(String name){
         return ingredientRepository.findIngredientByName(name);
    }

    public void deleteIngredient(){
        int id = InputHelper.getIntegerInput("Enter the ID of the ingredient you would like to delete");
        Ingredient ingredient = ingredientRepository.findIngredientById(id);

        if(ingredient == null){
            System.out.println("No ingredient found with the ID you entered.");
        }else {
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

    public void editIngredient(){
        int choice = InputHelper.getIntegerInput("Please enter the ID of the ingredient you would like to rename"   );
        ingredientRepository.updateIngredient(choice, InputHelper.getStringInput("Enter a new name"));
    }
}
