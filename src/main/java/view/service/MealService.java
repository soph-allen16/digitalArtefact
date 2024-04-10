package view.service;

import model.entity.Ingredient;
import model.entity.Meal;
import model.repository.MealRepository;
import utils.InputHelper;
import utils.TableHelper;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class MealService {

    private final InputHelper inputHelper;
    private final MealRepository mealRepository;
    private final TableHelper tableHelper;
    private final IngredientService ingredientService;

    public MealService(InputHelper inputHelper, IngredientService ingredientService){
        this.ingredientService = ingredientService;
        this.tableHelper = new TableHelper();
        this.inputHelper = inputHelper;
        this.mealRepository = new MealRepository(this.inputHelper);
    }

    //view list - prints all meals to the console
    public void viewMealList(){
        tableHelper.printTable( tableHelper.createMealTableFromList(mealRepository.getAllMeals()), new String[] {"ID", " Name"}, "Meals" );
    }

    //view single - prints details about a single meals to console
    public void viewMealDetails(int id){
        Meal meal = mealRepository.findMealById(id);
        System.out.println(meal.toString());
    }

    //delete
    public void deleteMealById(){
        int id = inputHelper.getIntegerInput("Enter the ID of the meal you would like to delete");
        Meal meal = mealRepository.findMealById(id);

        if( meal == null ){
            System.out.println("Meal with this ID could not be found.");
        }else{
            System.out.println("Delete " + meal.getMealName() + " ? Y/N ");
            String input = inputHelper.getStringInput();

            if(input.equalsIgnoreCase("y")){
                mealRepository.removeMeal(meal);
            }else if(input.equalsIgnoreCase("n")){
                System.out.println("Meal not deleted.");
            }else{
                System.out.println("Invalid input - please try again");
            }
        }
    }

    //add meal
    public void addMeal(){
        //Gather meal info
        String name = inputHelper.getStringInput("Please enter a meal name");
        String type = inputHelper.getStringInput("Please enter a type");

        // Get a list of the ingredients as strings
        ArrayList<String> inputIngredients = inputHelper.getCommaSeparatedInput("Please enter ingredients separated by commas (Quantities to be added after)");

        HashMap<Ingredient, Integer> ingredients = new HashMap<>();

        System.out.println("Quantities: ");
        //Gather quantities of each ingredient in the list
        for(String s : inputIngredients ){
            if(s.isBlank()){
                continue;
            }

            Ingredient ingredient;
            if( ingredientService.findIngredientByName(s)==null ){
                //If the ingredient isn't already in the list, add it
                ingredient = ingredientService.addIngredient(s, inputHelper.getStringInput("Please enter a unit for "  + s));
            }else{
                //If it is already in the list, get it
                ingredient = ingredientService.findIngredientByName(s);
            }

            //Add to the quantity map the ingredient and the quantity the user enters

            ingredients.put(ingredient, inputHelper.getPositiveIntegerInput( "Quantity of "+ ingredient.getIngredientName() + " ("+ingredient.getUnit()+") "));
        }

        mealRepository.addMeal(name, ingredients);
    }

    //find by id ????

    //update meal
    public void editMealMenu(){

    }
}