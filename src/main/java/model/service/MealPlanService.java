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

    //Class to handle user input and validation for the Meal Plan repository, and interface between repository and menus
    //Summary of methods: add meal plan, View meal plan, get list of meal plans
public class MealPlanService {

        private final MealService mealService;
        private final MealPlanRepository mealPlanRepository;

        public MealPlanService(MealService mealService) {
            this.mealService = mealService;
            this.mealPlanRepository = new MealPlanRepository(mealService);
        }

        //Handles user input when creating a meal plan
        public void addNewMealPlan() {
            OutputHelper.printTitle("Create Meal Plan");

            //Get a name for the meal plan
            String planDate = InputHelper.getStringInput("Please enter a name");
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

            mealPlanRepository.addMealPlan(weeklyMeals, planDate);
            System.out.println("Meal plan successfully added.");
        }

        //Use table helper to view a list of saved meal plans
        public void viewMealPlanList() {
            TableHelper.printTwoColumnTable(TableHelper.createMealPlanTableFromList(mealPlanRepository.getMealPlans()), new String[]{"ID", "Name"});
            String input = InputHelper.getStringInput("Would you like to view a specific meal? (y/n)");

            if (input.equalsIgnoreCase("y")) {
                viewMealPlan();
            }
        }

        //Get user input when they wish to view a meal plan - handle incorrect input
        public void viewMealPlan() {
            MealPlan meal = mealPlanRepository.getMealPlanById(InputHelper.getPositiveIntegerInput("Enter the ID of the meal plan you would like to view"));
            if (meal != null) {
                System.out.println(meal.toString());
                if(InputHelper.getStringInput("Would you like to generate a shopping list for this meal plan? Y/N").equalsIgnoreCase("y")){
                    getShoppingList(meal.getMealPlanId());
                }
            } else {
                System.out.println("Meal plan with this ID does not exist");
            }
        }

        //Retrieve list of meal plans for saving to file
        public List<MealPlan> getMealPlans() {
            return mealPlanRepository.getMealPlans();
        }

        //Delete meal plan by ID
        public void deleteMealPlanById() {
            int id = InputHelper.getIntegerInput("Enter the ID of the meal plan to delete");
            MealPlan mealPlan = mealPlanRepository.getMealPlanById(id);

            if (mealPlan == null) {
                System.out.println("Meal plan with this ID could not be found");
            } else {
                System.out.println("Delete this meal plan? Y/N");
                String input = InputHelper.getStringInput();

                if (input.equalsIgnoreCase("Y")) {
                    mealPlanRepository.deleteMealPlan(mealPlan);
                } else if (input.equalsIgnoreCase("n")) {
                    System.out.println("Meal plan not deleted");
                } else {
                    System.out.println("Incorrect input. Please try again");
                }
            }
        }

        public void getShoppingList(int id) {
            MealPlan mealPlan = mealPlanRepository.getMealPlanById(id);

            if (mealPlan == null) {
                System.out.println("Meal plan with this ID cannot be found!");
            } else {
                StringBuilder str = new StringBuilder();
                str.append(OutputHelper.createTitle("Shopping List")).append("\r\n");
                str.append("Shopping list for: ").append(mealPlan.getMealPlanName()).append("\r\n");

                HashMap<Ingredient, Integer> shoppingList = mealPlanRepository.generateShoppingList(mealPlan);
                for (Ingredient i : shoppingList.keySet()) {
                    str.append(i.getIngredientName()).append(" x ").append(shoppingList.get(i)).append(" ").append(i.getUnit()).append("\r\n");
                }
                System.out.println(str.toString());
            }
        }
    }