package model.entity;

import org.apache.commons.lang3.StringUtils;

public class Ingredient {
    private int ingredientId;
    private String ingredientName;

    public Ingredient(String ingredientName){
        this.ingredientName = ingredientName;
    }

    public Ingredient(String ingredientName, int ingredientId){
        this(ingredientName);
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == this){
            return true;
        }else if( !(obj instanceof Ingredient ) ){
            return false;
        }
        Ingredient i = (Ingredient) obj;
        return this.ingredientName.equalsIgnoreCase(i.getIngredientName());
    }

}
