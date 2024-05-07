package model.entity;

import utils.OutputHelper;
import java.util.*;

//Entity to store meal plan data
public class MealPlan {

    private int mealPlanId;
    private String mealPlanName;
    private LinkedHashMap<String, Meal> mealPlanList;

    //Constructor
    public MealPlan(int mealPlanId, String mealPlanName, LinkedHashMap<String,Meal> mealPlanList) {
        this.mealPlanId = mealPlanId;
        this.mealPlanName = mealPlanName;
        this.mealPlanList = mealPlanList;
    }

    //getters and setters
    public int getMealPlanId() {
        return mealPlanId;
    }
    public String getMealPlanName() {
        return mealPlanName;
    }
    public LinkedHashMap<String, Meal> getMealPlanList() {
        return mealPlanList;
    }

    //Override equals to use name for comparison
    @Override
    public boolean equals(Object o){
        if( o == this){
            return true;
        }else if(!(o instanceof  MealPlan)){
            return false;
        }
        MealPlan m  = (MealPlan) o;
        return this.getMealPlanName().equalsIgnoreCase((m.getMealPlanName()));
    }

    //Override toString method for easy printing to console
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(OutputHelper.createTitle(mealPlanId + " : " + mealPlanName));

        if(this.mealPlanList != null) {
            for (String day : mealPlanList.keySet()) {
                str.append(day).append(" : ").append(mealPlanList.get(day).getMealName()).append("\r\n");
            }
        }

        return str.toString();
    }

    //Create CSV method to store the hashmap easily
    public String toCSV(){
        StringBuilder s = new StringBuilder();

        //Add ID and Name in usual CSV format
        s.append(mealPlanId).append(",").append(mealPlanName).append(",");

        //Add day to string in the form day:meal;
        for(String date : mealPlanList.keySet() ){
            s.append(date).append(":").append(mealPlanList.get(date).getMealId()).append(";");
        }
        return s.toString();
    }
}
