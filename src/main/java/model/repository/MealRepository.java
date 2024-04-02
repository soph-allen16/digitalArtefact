package model.repository;

import model.entity.Ingredient;
import model.entity.Meal;
import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class MealRepository {

    private final InputHelper inputHelper;
    private final List<Meal> mealList;
    private int counter = 0 ;

    public MealRepository(InputHelper inputHelper){
        this.inputHelper = inputHelper;
        this.mealList = new ArrayList<Meal>();
    }

    public List<Meal> getAllMeals(){
        return this.mealList;
    }

    public void addMeal(String mealName, String mealType){
        Meal meal = new Meal(counter+1, mealName, mealType);
        if( mealList.contains(meal) ){
            System.out.println("This meal already exists!");
        }else{
            mealList.add(meal);
            counter++;
        }
    }


    public void removeMeal(Meal meal){
        if( meal == null ){
            System.out.println("The meal you entered does not exist!");
        }else{
            mealList.remove(meal);
        }
    }

    public Meal findMealById(int id){
        for( Meal m : mealList ){
            if( m.getMealId() == id ){
                return m;
            }
        }
        return null;
    }

    //edit meal

}
