package main.entity;

public class Ingredient {
    private String ingredientType;
    private String ingredientName;

    public Ingredient(String ingredientName, String ingredientType){
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == this){
            return true;
        }else if( !(obj instanceof Ingredient ) ){
            return false;
        }
        Ingredient i = (Ingredient) obj;
        return this.ingredientName.equals(i.getIngredientName());
    }
}
