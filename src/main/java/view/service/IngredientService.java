package view.service;


import model.entity.Ingredient;
import model.repository.IngredientRepository;
import utils.InputHelper;

public class IngredientService {
    private final InputHelper inputHelper;
    private final IngredientRepository ingredientRepository;

    public IngredientService(InputHelper inputHelper){
        this.inputHelper = inputHelper;
        this.ingredientRepository = new IngredientRepository(this.inputHelper);
    }

    public void viewIngredientList(){
        for(Ingredient i : ingredientRepository.getAllIngredients()){
            System.out.println("name: " + i.getIngredientName() + " type: " + i.getIngredientType());
        }
    }

    public void addIngredient(){
        String name = inputHelper.getStringInput("Please enter the name of the ingredient");
        String type = inputHelper.getStringInput("please enter an ingredient type");
        ingredientRepository.addIngredient(name,type);
    }
}
