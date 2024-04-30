package model.entity;

public class Ingredient {
    private int ingredientId;
    private String ingredientName;
    private String unit;

    public Ingredient(String ingredientName){
        this.ingredientName = ingredientName;
    }

    public Ingredient(int ingredientId, String ingredientName){
        this(ingredientName);
        this.ingredientId = ingredientId;
    }

    public Ingredient(int ingredientId, String ingredientName,  String unit){
        this(ingredientId, ingredientName);
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    @Override
    public String toString(){
        return ingredientId + "," + ingredientName + "," + unit;
    }
}
