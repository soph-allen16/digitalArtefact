package model.repository;

import model.entity.Ingredient;
import model.entity.Meal;
import utils.fileUtils.MealsFileUtil;
import model.service.IngredientService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
//Class to hold meals while application is running, with methods for CRUD features

public class MealRepository {

    private final List<Meal> mealList;
    private int counter;

    //Read meals from CSV file on class instantiation
    //Initialise counter above max value of all IDs already in the list
    public MealRepository(IngredientService ingredientService){
        mealList = MealsFileUtil.readMealsFromFile(ingredientService);
        counter = mealList.isEmpty() ? 0 : mealList.stream().max(Comparator.comparing(Meal::getMealId)).get().getMealId() + 1;
    }

    //Return full list of meals
    public List<Meal> getAllMeals(){
        return this.mealList;
    }

    //Add new meal if it doesn't already exist
    public Meal addMeal(String mealName, HashMap<Ingredient, Integer> ingredients){
        Meal meal = new Meal(counter , mealName, ingredients);
        if( mealList.contains(meal) ){
            throw new UnsupportedOperationException("Cannot be performed: meal already exists.");
        }else{
            mealList.add(meal);
            counter++;
        }
        return meal;
    }

    //Delete meal if not null
    public void removeMeal(Meal meal){
        if( meal == null ){
            throw new NoSuchElementException("Cannot be performed: no such meal exists.");
        }else{
            mealList.remove(meal);
        }
    }

    //Return meal based on ID
    public Meal findMealById(int id){
        for( Meal m : mealList ){
            if( m.getMealId() == id ){
                return m;
            }
        }
        return null;
    }

    //return meal based on name
    public Meal findMealByName(String name){
        for(Meal m : mealList){
            if(m.getMealName().equalsIgnoreCase(name)){
                return m;
            }
        }
        return null;
    }
}
