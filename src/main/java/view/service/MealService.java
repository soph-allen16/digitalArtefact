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
    public void viewMealDetails(int id){
        Meal meal = mealRepository.findMealById(id);
        System.out.println(meal.toString());
    }

    //add meal
    public void addMeal(){
        //Gather meal info
        String name = inputHelper.getStringInput("Please enter a meal name");
        String type = inputHelper.getStringInput("Please enter a type");

        // Get a list of the ingredients as strings
        ArrayList<String> inputIngredients = inputHelper.getCommaSeparatedInput("Please enter ingredients separated by commas (Quantities to be added after)");

        HashMap<Ingredient, Integer> ingredients = new HashMap<>();

        System.out.println("Please enter quantities for the following ingredients: ");
        //Gather quantities of each ingredient in the list
        for(String s : inputIngredients ){
            Ingredient ingredient;
            if( ingredientService.findIngredientByName(s)==null ){
                //If the ingredient isn't already in the list, add it
                ingredient = ingredientService.addIngredient(s);
            }else{
                //If it is already in the list, get it
                ingredient = ingredientService.findIngredientByName(s);
            }

            //Add to the quantity map the ingredient and the quantity the user enters
            ingredients.put(ingredient, inputHelper.getIntegerInput( ingredient.getIngredientName() ));
        }

        mealRepository.addMeal(name, type, ingredients);
    }

    //find by id
    //delete
    //update
}