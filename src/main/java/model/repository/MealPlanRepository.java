package model.repository;

import model.entity.Meal;
import model.entity.MealPlan;

import java.util.List;

public class MealPlanRepository {

    private List<MealPlan> mealPlans;

    public List<MealPlan> getMealPlans() {
        return mealPlans;
    }

    //add meal plan
    public void addMealPlan( MealPlan mealPlan ){
        this.mealPlans.add(mealPlan);
    }

    //edit meal plan

    //delete meal plan

    //get meal plan
}
