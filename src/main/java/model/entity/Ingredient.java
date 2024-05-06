package model.entity;

//Ingredient entity storing basic information: name, unit of measurement and ID.

public class Ingredient {
    private int ingredientId;
    private String ingredientName;
    private String unit;

    public Ingredient(int ingredientId, String ingredientName,  String unit){
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.unit = unit;
    }

    public String getIngredientUnit() {
        return unit;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getIngredientId() {
        return ingredientId;
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
