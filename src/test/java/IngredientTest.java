import service.Ingredient;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IngredientTest{

    @Test
    public void testIngredientConstructor(){
        String name = "ingredient";
        String type = "type";
        Ingredient ingredient = new Ingredient(name,type);

        assertEquals(ingredient.getIngredientName(), name);
        assertEquals(ingredient.getIngredientType(), type);
    }

    @Test
    public void testIngredientGettersAndSetters(){
        String newName = "new";
        Ingredient ingredient = new Ingredient("ingredient","type");
        ingredient.setIngredientName(newName);
        ingredient.setIngredientType(newName);

        assertEquals(ingredient.getIngredientName(), newName);
        assertEquals(ingredient.getIngredientType(), newName);
    }

    @Test
    public void testIngredientEquals(){
        String name = "ingredient";
        String type = "type";
        Ingredient ingredient = new Ingredient(name,type);

        Object object = new Object();
        Assert.assertFalse(ingredient.equals(object));

    }
}