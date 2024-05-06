package model.entity;



import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {
    private int id = 0;
    private String name = "Test";
    private String unit = "g";

    //Test that constructor sets fields as expected
    @Test
    public void testIngredientConstructor(){
        Ingredient ingredient = new Ingredient(id, name,unit);
        assertEquals(ingredient.getIngredientName(), name);
        assertEquals(ingredient.getIngredientId(), id);
        assertEquals(ingredient.getIngredientUnit(), unit);
    }

    //Test that an ingredient instance equals itself
    @Test
    public void testEqualsSameEntity(){
        Ingredient ingredient = new Ingredient( id, name, unit);
        assertEquals(ingredient, ingredient);
    }

    //Test that ingredients with the same name are equal
    @Test
    public void testEqualsSameName(){
        Ingredient ingredient = new Ingredient(id, name,unit);
        Ingredient ingredient1 = new Ingredient(1, name, "gram");
        assertEquals(ingredient, ingredient1);
    }

    //Test that ingredients with different names are not equal
    @Test
    public void testNotSameName(){
        Ingredient ingredient = new Ingredient(id, name, unit);
        Ingredient ingredient1 = new Ingredient(id, "Ginger", unit);
        assertNotEquals(ingredient, ingredient1);
    }

    //Test that an ingredient isn't equal to null
    @Test
    public void testIngredientNotEqualToNull(){
        Ingredient ingredient = new Ingredient(id, name, unit);
        assertNotEquals(ingredient, null );
    }

    //Test that an ingredient isn't equal to a different object type
    @Test
    public void testOtherObjectNotEqual(){
        Ingredient ingredient = new Ingredient(id, name, unit);
        String string = "Garlic";
        assertNotEquals(ingredient, string);
    }

    //Check toString method reutrns non null
    @Test
    public void testToString(){
        Ingredient ingredient = new Ingredient(id, name,unit);
        assertNotNull(ingredient.toString());
    }
}
