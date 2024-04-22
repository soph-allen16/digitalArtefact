package model.entity;

import view.service.MealService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MealPlan {
    private HashMap<Integer, Meal> mealPlan;
    private int mealPlanId;
    Calendar calendar = Calendar.getInstance();

    public MealPlan(HashMap<Integer,Meal> mealPlan, int mealPlanId, String date) {
        this.mealPlan = mealPlan;
        this.mealPlanId = mealPlanId;
    }

    public HashMap<Integer, Meal> getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(HashMap<Integer, Meal> mealPlan) {
        this.mealPlan = mealPlan;
    }
}
