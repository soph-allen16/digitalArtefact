package model.entity;

import view.service.MealService;

import java.util.*;

public class MealPlan {
    private LinkedHashMap<String, Meal> mealPlan;
    private String date;
    private int mealPlanId;
    Calendar calendar = Calendar.getInstance();

    public MealPlan(LinkedHashMap<String,Meal> mealPlan, String date, int mealPlanId) {
        this.mealPlan = mealPlan;
        this.mealPlanId = mealPlanId;
        this.date = date;
    }

    public HashMap<String, Meal> getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(LinkedHashMap<String, Meal> mealPlan) {
        this.mealPlan = mealPlan;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Meal Plan ID: ").append(mealPlanId).append("\r\n");
        str.append("Meal Plan Date: ").append(date).append("\r\n\r\n");
        for(String day : mealPlan.keySet() ){
            str.append( day ).append(" : ").append(mealPlan.get(day).getMealName()).append("\r\n");
        }
        return str.toString();
    }

    public int getMealPlanId() {
        return mealPlanId;
    }
}
