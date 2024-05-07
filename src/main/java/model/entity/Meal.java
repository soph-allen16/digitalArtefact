package model.entity;

import utils.OutputHelper;

import java.util.HashMap;

//Entity for storing meals and their ingredients with quantities
public class Meal {
    private int mealId;
    private String mealName;
    private HashMap<Ingredient, Integer> ingredients;

    public Meal(int mealId, String mealName, HashMap<Ingredient, Integer> ingredients){
        this.mealName = mealName;
        this.mealId = mealId;
        this.ingredients = ingredients;
    }

    //getters and setters
    public int getMealId() {
        return mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public HashMap<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    //Override equals to use meal name for comparison
    @Override
    public boolean equals(Object obj) {
        if( obj == this){
            return true;
        }else if( !(obj instanceof Meal ) ){
            return false;
        }
        Meal m = (Meal) obj;
        return this.mealName.equalsIgnoreCase(m.getMealName());
    }

    //Override the toString method for easy printing to console
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(OutputHelper.createTitle(this.mealName));
        str.append("Ingredients:");

        for( Ingredient i : this.ingredients.keySet() ){
            str.append("\r\n").append("(Id: ")
                    .append(i.getIngredientId()).append(") ").append(i.getIngredientName())
                    .append(" x ")
                    .append(this.ingredients.get(i)).append(" ").append(i.getIngredientUnit());
        }

        return str.toString();
    }

    //Create custom CSV method to store the hashmap easily
    public String toCSV(){
        StringBuilder s = new StringBuilder();

        //Add ID and name in usual CSV format
        s.append(mealId).append(",").append(mealName).append(",");

        //Add ingredient in the form ingredient:qty;
        for(Ingredient i : ingredients.keySet()){
            s.append(i.getIngredientName()).append(":").append(ingredients.get(i)).append(";");
        }

        return s.toString();
    }
}
