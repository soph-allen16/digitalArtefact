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
        System.out.println("ID | Name | Type");
        for(Ingredient i : ingredientRepository.getAllIngredients()){
            System.out.println(i.getIngredientId() + "   " + i.getIngredientName() + "   " + i.getIngredientType());
        }
    }

    public void addIngredient(){
        String name = inputHelper.getStringInput("Please enter the name of the ingredient");
        String type = inputHelper.getStringInput("please enter an ingredient type");
        ingredientRepository.addIngredient(name,type);
    }

    public void modifyIngredient(){
        int id = inputHelper.getIntegerInput("Enter the ID of the ingredient you would like to modify");
        ingredientRepository.modifyIngredientMenu( ingredientRepository.findIngredientById(id) );
    }
}
