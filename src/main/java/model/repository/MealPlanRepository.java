package model.repository;

import model.entity.Meal;
import model.entity.MealPlan;
import utils.fileUtils.MealPlanFileUtil;
import model.service.MealService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MealPlanRepository {
    private int counter = 0;
    private List<MealPlan> mealPlans = new ArrayList<>();

    //Read meal plans from file when class is instantiated
    public MealPlanRepository(MealService mealService){
        mealPlans = MealPlanFileUtil.readMealPlansFromFile(mealService);
    }

    //return list of all meal plans
    public List<MealPlan> getMealPlans() {
        return mealPlans;
    }

    //add new meal plan to list
    public void addMealPlan(LinkedHashMap<String, Meal> weeklyMeals, String date){
        MealPlan mealPlan = new MealPlan(counter, date, weeklyMeals);

        if(mealPlans.contains(mealPlan) ){
            System.out.println("Meal plan already in the list!");
        }else{
            mealPlans.add(mealPlan);
            counter++;
        }
    }

    //Find meal plan from the repository using ID, else return null
    public MealPlan getMealPlanById(int id){
        for(MealPlan m : mealPlans){
            if(m.getMealPlanId() == id){
                return m;
            }
        }
        return null;
    }

    //delete meal plan
}
