package digitalArtefact.entity;

import digitalArtefact.constants.IngredientType;

public class Ingredient {
    private IngredientType ingredientType;
    private String ingredientName;

    public Ingredient(IngredientType ingredientType, String ingredientName){
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
