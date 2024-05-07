package model.service;

import constants.Weekdays;
import model.entity.Ingredient;
import model.entity.Meal;
import model.entity.MealPlan;
import model.repository.MealPlanRepository;
import utils.InputHelper;
import utils.OutputHelper;
import utils.TableHelper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;

//Class to handle user input and validation for the Meal Plan repository, and interface between repository and menus

public class MealPlanService {

    private final MealService mealService;
    private final MealPlanRepository mealPlanRepository;

    public MealPlanService(MealService mealService) {
        this.mealService = mealService;
        this.mealPlanRepository = new MealPlanRepository(mealService);
    }

    //Handles user input when creating a meal plan
    public MealPlan addNewMealPlan() {
        OutputHelper.printTitle("Create Meal Plan");

        //Get a name for the meal plan
        String planName = InputHelper.getStringInput("Please enter a name");
        LinkedHashMap<String, Meal> weeklyMeals = new LinkedHashMap<>();

        if (InputHelper.getStringInput("Would you like to view saved meals? (y/n)").equalsIgnoreCase("y")) {
            mealService.viewMealList();
        }

        //Loop through the days of the week and get a meal for each
        for (String weekday : Weekdays.DAYS_OF_WEEK) {
            String input = InputHelper.getStringInput("Enter a meal name or meal ID for " + weekday);
            Meal dayMeal = mealService.findMeal(input);

            //Check that meal exists
            while (dayMeal == null) {
                System.out.println("Meal cannot be found. Please try again.");
                dayMeal = mealService.findMeal(input);
            }
            weeklyMeals.put(weekday, dayMeal);
        }

        try {
            return mealPlanRepository.addMealPlan(planName, weeklyMeals);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    //Use table helper to view a list of saved meal plans
    public void viewMealPlanList() {
        TableHelper.printTwoColumnTable(TableHelper.createMealPlanTableFromList(mealPlanRepository.getMealPlans()), new String[]{"ID", "Name"});
        String input = InputHelper.getStringInput("Would you like to view a specific meal plan? (y/n)");

        if (input.equalsIgnoreCase("y")) {
            viewMealPlan(InputHelper.getPositiveIntegerInput("Enter the ID of the meal plan you would like to view"));
        }
    }

    //Get user input when they wish to view a meal plan - handle incorrect input
    public void viewMealPlan(int id) {
        MealPlan meal = mealPlanRepository.getMealPlanById(id);

        try {
            if (meal != null) {
                System.out.println(meal.toString());
                if (InputHelper.getStringInput("Would you like to generate a shopping list for this meal plan? Y/N").equalsIgnoreCase("y")) {
                    getShoppingList(meal.getMealPlanId());
                }
            } else {
                throw new NoSuchElementException("Meal plan with this ID does not exist");
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    //Retrieve list of meal plans for saving to file
    public List<MealPlan> getMealPlans() {
        return mealPlanRepository.getMealPlans();
    }

    //Delete meal plan by ID
    public void deleteMealPlanById(int id) {
        MealPlan mealPlan = mealPlanRepository.getMealPlanById(id);

        try {
            if (mealPlan == null) {
                throw new NoSuchElementException("Meal plan with this ID cannot be found.");
            } else {
                System.out.println("Delete this meal plan? Y/N");
                String input = InputHelper.getStringInput();

                if (input.equalsIgnoreCase("Y")) {
                    mealPlanRepository.removeMealPlan(mealPlan);
                }else if (input.equalsIgnoreCase("n")) {
                    throw new Exception("User cancelled: meal plan not deleted.");
                }else {
                    throw new IllegalArgumentException("Input must be 'y' or 'n'. Meal plan not deleted");
                }
            }
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void getShoppingList(int id) {
        MealPlan mealPlan = mealPlanRepository.getMealPlanById(id);

        try {
            if (mealPlan == null) {
                throw new NoSuchElementException("Meal plan with this ID cannot be found");
            } else {
                StringBuilder str = new StringBuilder();
                str.append(OutputHelper.createTitle("Shopping List")).append("\r\n");
                str.append("Shopping list for: ").append(mealPlan.getMealPlanName()).append("\r\n");

                HashMap<Ingredient, Integer> shoppingList = mealPlanRepository.generateShoppingList(mealPlan);
                for (Ingredient i : shoppingList.keySet()) {
                    str.append(i.getIngredientName()).append(" x ").append(shoppingList.get(i)).append(" ").append(i.getIngredientUnit()).append("\r\n");
                }
                System.out.println(str.toString());
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}