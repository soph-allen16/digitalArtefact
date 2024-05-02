package view.service;

import constants.Weekdays;
import model.entity.Meal;
import model.entity.MealPlan;
import model.repository.MealPlanRepository;
import utils.InputHelper;
import utils.OutputHelper;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MealPlanService {

    private final MealService mealService;
    private final MealPlanRepository mealPlanRepository;

    public MealPlanService(MealService mealService) {
        this.mealService = mealService;
        this.mealPlanRepository = new MealPlanRepository();
    }

    public void addNewMeal(){
        OutputHelper.printTitle("Create Meal Plan");
        String planDate = InputHelper.getStringInput("Please enter a date (dd/mm/yy)");
        LinkedHashMap<String, Meal> weeklyMeals = new LinkedHashMap<>();

        if( InputHelper.getStringInput("Would you like to view saved meals? (y/n)").equalsIgnoreCase("y") ){
            mealService.viewMealList();
        }

        for(String weekday : Weekdays.DAYS_OF_WEEK ){
            String input = InputHelper.getStringInput("Enter a meal name or meal ID for " + weekday );

            Meal dayMeal = mealService.findMeal(input);

            while (dayMeal == null){
                System.out.println("Meal cannot be found. Please try again.");
                dayMeal = mealService.findMeal(input);
            }

            weeklyMeals.put(weekday, dayMeal);
        }

        mealPlanRepository.addMealPlan(weeklyMeals, planDate);
        System.out.println("Meal plan successfully added.");
    }

    public void viewMealPlan(){
        MealPlan meal = mealPlanRepository.getMealPlanById( InputHelper.getPositiveIntegerInput("Enter the ID of the meal plan you would like to view") );

        if(meal != null){
            System.out.println(meal.toString());
        }else{
            System.out.println("Meal plan with this ID does not exist");
        }
    }


}
