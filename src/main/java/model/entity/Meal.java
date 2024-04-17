package model.entity;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.text.TextStringBuilder;

import java.util.HashMap;
import java.util.List;

public class Meal {
    private int mealId;
    private String mealName;
    private HashMap<Ingredient, Integer> ingredients;

    public Meal(String mealName){
        this.mealName = mealName;
    }
    public Meal(int mealId, String mealName){
        this(mealName);
        this.mealId = mealId;
    }

    public Meal(int mealId, String mealName, HashMap<Ingredient, Integer> ingredients){
        this(mealId, mealName);
        this.ingredients = ingredients;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public HashMap<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }

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

    @Override
    public String toString(){
        TextStringBuilder str = new TextStringBuilder();
        str.append("Name: ").append(this.mealName);
        str.appendNewLine();
        str.append("Ingredients:");

        for( Ingredient i : this.ingredients.keySet() ){
            str.appendNewLine();
            str.append("(Id: ")
                    .append(String.valueOf(i.getIngredientId())).append(") ").append(i.getIngredientName())
                    .append(" x ")
                    .append(String.valueOf(this.ingredients.get(i))).append(" ").append(i.getUnit());
        }

        return str.build();
    }
}
