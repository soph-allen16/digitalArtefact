package model.entity;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;

import java.util.HashMap;
import java.util.List;

public class Meal {
    private int mealId;
    private String mealName;
    private String mealType;
    private HashMap<Ingredient, Integer> ingredients;

    public Meal(String mealName, String mealType){
        this.mealName = mealName;
        this.mealType = mealType;
    }
    public Meal(int mealId, String mealName, String mealType){
        this(mealName,mealType);
        this.mealId = mealId;
    }

    public Meal(int mealId, String mealName, String mealType, HashMap<Ingredient, Integer> ingredients){
        this(mealId, mealName, mealType);
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

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
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
    public String[] toArray(){
        String[] array = new String[] {StringUtils.center(Integer.toString(this.mealId), 15), StringUtils.center(this.mealName,15) , StringUtils.center(this.mealType,15) };
        return array;
    }

    @Override
    public String toString(){
        StrBuilder str = new StrBuilder();
        str.append("Name: ").append(this.mealName);
        str.appendNewLine();
        str.append("Type: ").append(this.mealType);
        str.appendNewLine();
        str.append("Ingredients:");

        for( Ingredient i : ingredients.keySet() ){
            str.appendNewLine();
            str.append( ingredients.get(i) ).append(" x ").append(i.getIngredientName());
        }

        return str.build();
    }
}
