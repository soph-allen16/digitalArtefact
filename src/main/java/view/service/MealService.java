package view.service;

import model.entity.Ingredient;
import model.entity.Meal;
import model.repository.MealRepository;
import org.apache.commons.lang3.StringUtils;
import utils.InputHelper;
import utils.TableHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class MealService {

    private final InputHelper inputHelper;
    private final MealRepository mealRepository;
    private final TableHelper tableHelper;
    private final IngredientService ingredientService;

    public MealService(InputHelper inputHelper, IngredientService ingredientService){
        this.ingredientService = ingredientService;
        this.tableHelper = new TableHelper(new String[] {"ID", "Name", "Type"});
        this.inputHelper = inputHelper;
        this.mealRepository = new MealRepository(this.inputHelper);
    }

    //view list
    public void viewMealList(){
        System.out.println(StringUtils.center("***** Meals *****", 49));
        tableHelper.printMeals(mealRepository.getAllMeals());
    }

    //view single
    public void viewSingleMeal(int id){
        Meal meal = mealRepository.findMealById(id);
    }

    public void addMeal(){
        String name = inputHelper.getStringInput("Please enter a meal name");
        String type = inputHelper.getStringInput("Please enter a type");

        ArrayList<String> ingredients = inputHelper.getCommaSeparatedInput("Please enter ingredients separated by commas (Quantities to be added after)");

        HashMap<Ingredient, Integer> quantities = new HashMap<>();

        System.out.println("Please enter quantities for the following ingredients: ");
        for(String s : ingredients ){
            Ingredient ingredient;
            if( ingredientService.findIngredientByName(s)==null ){
                ingredient = ingredientService.addIngredient(s);
            }else{
                ingredient = ingredientService.findIngredientByName(s);
            }
            quantities.put(ingredient, inputHelper.getIntegerInput( ingredient.getIngredientName() ));
        }
        System.out.println(quantities);
    }
    //add meal
    //find by id
    //delete
    //update
}
