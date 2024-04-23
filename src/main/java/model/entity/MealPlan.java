package model.entity;

import view.service.MealService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MealPlan {
    private HashMap<String, Meal> mealPlan;
    private String date;
    private int mealPlanId;
    Calendar calendar = Calendar.getInstance();

    public MealPlan(HashMap<String,Meal> mealPlan, String date, int mealPlanId) {
        this.mealPlan = mealPlan;
        this.mealPlanId = mealPlanId;
        this.date = date;
    }

    public HashMap<String, Meal> getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(HashMap<String, Meal> mealPlan) {
        this.mealPlan = mealPlan;
    }
}
