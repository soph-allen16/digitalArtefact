package model.repository;

import model.entity.Ingredient;
import model.entity.Meal;
import model.entity.MealPlan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MealPlanRepository {
    private int counter = 0;

    private List<MealPlan> mealPlans = new ArrayList<>();

    public List<MealPlan> getMealPlans() {
        return mealPlans;
    }

    //add meal plan
    public void addMealPlan(LinkedHashMap<String, Meal> weeklyMeals, String date){
        MealPlan mealPlan = new MealPlan(weeklyMeals, date, counter);

        if(mealPlans.contains(mealPlan) ){
            System.out.println("Meal plan already in the list!");
        }else{
            mealPlans.add(mealPlan);
            counter++;
        }
    }

    public MealPlan getMealPlanById(int id){
        for(MealPlan m : mealPlans){
            if(m.getMealPlanId() == id){
                return m;
            }
        }
        return null;
    }
    //edit meal plan

    //delete meal plan
}
