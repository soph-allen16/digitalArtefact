package model.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Meal {
    private int mealId;
    private String mealName;
    private String mealType;
    List<Ingredient> ingredients;

    public Meal(String mealName, String mealType){
        this.mealName = mealName;
        this.mealType = mealType;
    }
    public Meal(int mealId, String mealName, String mealType){
        this(mealName,mealType);
        this.mealId = mealId;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
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
}
