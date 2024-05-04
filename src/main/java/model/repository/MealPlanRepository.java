package model.repository;

import model.entity.Ingredient;
import model.entity.Meal;
import model.entity.MealPlan;
import utils.fileUtils.MealPlanFileUtil;
import model.service.MealService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class MealPlanRepository {
    private int counter = 0;
    private List<MealPlan> mealPlans = new ArrayList<>();

    //Read meal plans from file when class is instantiated
    //Initialise the counter above the max ID from the list of meal plans
    public MealPlanRepository(MealService mealService){
        mealPlans = MealPlanFileUtil.readMealPlansFromFile(mealService);
        counter = mealPlans.stream().max(Comparator.comparing(MealPlan::getMealPlanId)).get().getMealPlanId() + 1;
    }

    //return list of all meal plans
    public List<MealPlan> getMealPlans() {
        return mealPlans;
    }

    //Check if meal plan exists and if not then add new meal plan to list
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

    //Delete meal plan from list
    public void deleteMealPlan(MealPlan mealPlan){
        if(mealPlan==null){
            System.out.println("Meal plan does not exist!");
        }else{
            mealPlans.remove(mealPlan);
        }
    }
}
