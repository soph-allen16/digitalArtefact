package model.entity;

import utils.OutputHelper;
import java.util.*;

//Entity to store meal plans
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
    public int getMealPlanId() {
        return mealPlanId;
    }

    public String getMealPlanName() {
        return name;
    }

    //Override toString method for easy printing to console
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(OutputHelper.createTitle(mealPlanId + " : " + name));
        for(String day : mealPlan.keySet() ){
            str.append( day ).append(" : ").append(mealPlan.get(day).getMealName()).append("\r\n");
        }
        return str.toString();
    }

    //Create CSV method to store the hashmap easily
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
