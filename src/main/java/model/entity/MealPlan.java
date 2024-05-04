package model.entity;

import java.util.*;

public class MealPlan {

    private int mealPlanId;
    private String name;
    private LinkedHashMap<String, Meal> mealPlan;

    public MealPlan(int mealPlanId, String name, LinkedHashMap<String,Meal> mealPlan) {
        this.mealPlanId = mealPlanId;
        this.name = name;
        this.mealPlan = mealPlan;
    }

    //getters and setters
    public HashMap<String, Meal> getMealPlan() {
        return mealPlan;
    }
    public void setMealPlan(LinkedHashMap<String, Meal> mealPlan) {
        this.mealPlan = mealPlan;
    }

    public int getMealPlanId() {
        return mealPlanId;
    }

    public String getMealPlanName() {
        return name;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Meal Plan ID: ").append(mealPlanId).append("\r\n");
        str.append("Meal Plan Name: ").append(name).append("\r\n\r\n");
        for(String day : mealPlan.keySet() ){
            str.append( day ).append(" : ").append(mealPlan.get(day).getMealName()).append("\r\n");
        }
        return str.toString();
    }

    public String toCSV(){
        StringBuilder s = new StringBuilder();

        //Add ID and Name in usual CSV format
        s.append(mealPlanId).append(",").append(name).append(",");

        //Add day to string in the form day:meal;
        for(String date : mealPlan.keySet() ){
            s.append(date).append(":").append(mealPlan.get(date).getMealId()).append(";");
        }
        return s.toString();
    }
}
