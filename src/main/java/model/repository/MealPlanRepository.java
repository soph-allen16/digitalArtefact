package model.repository;

import model.entity.Ingredient;
import model.entity.Meal;
import model.entity.MealPlan;
import utils.fileUtils.MealPlanFileUtil;
import model.service.MealService;

import java.util.*;

//Stores list of meal plans, allowing for creation and deletion
//Methods: get all, get by ID, add, remove, generate shopping list

public class MealPlanRepository {
    private int counter;
    private List<MealPlan> mealPlans = new ArrayList<>();

    //Read meal plans from file when class is instantiated
    //Initialise the counter above the max ID from the list of meal plans
    public MealPlanRepository(MealService mealService){
        mealPlans = MealPlanFileUtil.readMealPlansFromFile(mealService);
        counter = mealPlans.isEmpty() ? 0 : mealPlans.stream().max(Comparator.comparing(MealPlan::getMealPlanId)).get().getMealPlanId() + 1;
    }

    //return list of all meal plans
    public List<MealPlan> getMealPlans() {
        return mealPlans;
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

    //Check if meal plan exists and if not then add new meal plan to list
    public MealPlan addMealPlan(String name,LinkedHashMap<String, Meal> weeklyMeals){
        MealPlan mealPlan = new MealPlan(counter, name, weeklyMeals);
        if(mealPlans.contains(mealPlan) ){
            throw new UnsupportedOperationException("Cannot be performed: meal plan already exists");
        }else{
            mealPlans.add(mealPlan);
            counter++;
        }
        return mealPlan;
    }

    //Delete meal plan from list
    public void removeMealPlan(MealPlan mealPlan){
        if(mealPlan==null){
            throw new NoSuchElementException("Cannot be performed: Meal plan does not exist.");
        }else{
            mealPlans.remove(mealPlan);
        }
    }

    //Generate shopping list of all ingredients
    public HashMap<Ingredient, Integer> generateShoppingList(MealPlan mealPlan){
        HashMap<Ingredient, Integer> shoppingList = new HashMap<>();

        //Loop through each meal in the week
        for(Meal m : mealPlan.getMealPlanList().values()){
            HashMap<Ingredient, Integer> mealIngredients = m.getIngredients();

            //Loop through ingredients of the meal and add to shopping list
            for(Ingredient i : mealIngredients.keySet()){

                //If ingredient in the list, add to qty, if not then add it to the list
                shoppingList.put(i, shoppingList.getOrDefault(i, 0)+ mealIngredients.get(i));
            }
        }

        return shoppingList;
    }
}
