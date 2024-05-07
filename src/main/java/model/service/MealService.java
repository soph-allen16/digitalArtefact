package model.service;

import model.entity.Ingredient;
import model.entity.Meal;
import model.repository.MealRepository;
import utils.InputHelper;
import utils.TableHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

//Gathers user input for passing to meal repository.
public class MealService {
    private final MealRepository mealRepository;
    private final IngredientService ingredientService;

    public MealService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
        this.mealRepository = new MealRepository(ingredientService);
    }

    //view list - prints all meals to the console
    public void viewMealList() {
        TableHelper.printTwoColumnTable(TableHelper.createMealTableFromList(mealRepository.getAllMeals()), new String[]{"ID", " Name"});
    }

    //view single - prints details about a single meals to console
    public void viewMealDetails(int id) {
        Meal meal = mealRepository.findMealById(id);
        System.out.println(meal.toString());
    }

    //delete meal by id
    // Verifies the meal exists and prompts user for confirmation
    public void deleteMealById(int id) {
        Meal meal = mealRepository.findMealById(id);

        try {
            if (meal == null) {
                throw new NoSuchElementException("Meal with this ID could not be found.");
            } else {
                System.out.println("Delete " + meal.getMealName() + " ? Y/N ");
                String input = InputHelper.getStringInput();

                if (input.equalsIgnoreCase("y")) {
                    mealRepository.removeMeal(meal);
                } else if (input.equalsIgnoreCase("n")) {
                    throw new Exception("User cancelled. Meal not deleted.");
                } else {
                    throw new IllegalArgumentException("Invalid input - please try again");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //add meal
    public Meal addMeal() {
        //Gather meal info
        String name = InputHelper.getStringInput("Please enter a meal name");

        // Get a list of the ingredients as strings
        ArrayList<String> inputIngredients = InputHelper.getCommaSeparatedInput("Please enter ingredients separated by commas (Quantities to be added after)");

        HashMap<Ingredient, Integer> ingredients = new HashMap<>();

        System.out.println("Quantities: ");
        //Gather quantities of each ingredient in the list
        for (String s : inputIngredients) {
            if (s.isBlank()) {
                continue;
            }
            Ingredient ingredient;
            //If the ingredient isn't already in the list, add it
            if (ingredientService.findIngredientByName(s) == null) {
                ingredient = ingredientService.addIngredient(s, InputHelper.getStringInput("Please enter a unit for " + s));
            } else {
                //If it is already in the list, get it
                ingredient = ingredientService.findIngredientByName(s);
            }
            //Add to the quantity map the ingredient and the quantity the user enters
            ingredients.put(ingredient, InputHelper.getPositiveIntegerInput("Quantity of " + ingredient.getIngredientName() + " (" + ingredient.getIngredientUnit() + ") "));
        }

        try {
            return mealRepository.addMeal(name, ingredients);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    //find meal by ID
    public Meal findMealById(int id) {
        return mealRepository.findMealById(id);
    }

    //Find meal based on any user input - id or name
    public Meal findMeal(String input) {
        if (mealRepository.findMealById(Integer.parseInt(input)) != null) {
            return mealRepository.findMealById(Integer.parseInt(input));
        } else {
            return mealRepository.findMealByName(input);
        }
    }

    //Return all meals for saving
    public List<Meal> getMeals() {
        return mealRepository.getAllMeals();
    }
}