package model.repository;

import model.entity.Ingredient;
import model.entity.Meal;
import utils.InputHelper;

import java.util.ArrayList;
import java.util.HashMap;
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

    public void addMeal(String mealName, HashMap<Ingredient, Integer> ingredients){
        Meal meal = new Meal(counter , mealName, ingredients);
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

    public Meal findMealByName(String name){
        for(Meal m : mealList){
            if(m.getMealName().equalsIgnoreCase(name)){
                return m;
            }
        }
        return null;
    }

    //edit meal
    public void editMealName(int id, String newName){
        Meal meal = findMealById(id);

        Meal alreadyExists = findMealByName(newName);

        if(meal == null){
            System.out.println("Operation cannot be performed: Meal with this ID does not exist.");
        }else if( (alreadyExists!=null) && (meal.getMealId() != alreadyExists.getMealId())){
            System.out.println("Operation cannot be performed: meal with this name already exists!");
        }else if(!newName.isBlank()){
            meal.setMealName(newName);
        }
    }
}
