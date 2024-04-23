package view.service;

import constants.Weekdays;
import model.entity.Meal;
import model.repository.MealPlanRepository;
import utils.InputHelper;

import java.util.HashMap;

public class MealPlanService {

    private final MealService mealService;
    private final MealPlanRepository mealPlanRepository;

    public MealPlanService(MealService mealService) {
        this.mealService = mealService;
        this.mealPlanRepository = new MealPlanRepository();
    }

    public void addNewMeal(){
        System.out.println("***** Create Meal Plan *****");
        String planDate = InputHelper.getStringInput("Please enter a date (dd/mm/yy)");
        HashMap<String, Meal> weeklyMeals = new HashMap<>();

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



}
