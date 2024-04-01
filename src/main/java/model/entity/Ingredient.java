package model.entity;

public class Ingredient {
    private int ingredientId;
    private String ingredientType;
    private String ingredientName;

    public Ingredient(String ingredientName, String ingredientType){
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }
    public Ingredient(String ingredientName, String ingredientType, int ingredientId){
        this(ingredientName, ingredientType);
        this.ingredientId = ingredientId;
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