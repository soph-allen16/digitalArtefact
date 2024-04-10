//package model.entity;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class IngredientTest {
//
//    //Test that constructor sets fields as expected
//    @Test
//    void testIngredientConstructor(){
//        Ingredient ingredient = new Ingredient("Garlic", "Herb", 1);
//        assertEquals(ingredient.getIngredientName(), "Garlic");
//        assertEquals(ingredient.getIngredientType(), "Herb");
//        assertEquals(ingredient.getIngredientId(), 1);
//    }
//
//    //Test that an ingredient instance equals itself
//    @Test
//    void testEqualsSameEntity(){
//        Ingredient ingredient = new Ingredient("Garlic", "Herb", 1);
//
//        assertEquals(ingredient, ingredient);
//    }
//
//    //Test that ingredients with the same name are equal
//    @Test
//    void testEqualsSameName(){
//        Ingredient ingredient = new Ingredient("Garlic", "Herb", 1);
//        Ingredient ingredient1 = new Ingredient("Garlic", "Spice", 2);
//
//        assertEquals(ingredient, ingredient1);
//    }
//
//    //Test that ingredients with different names are not equal
//    @Test
//    void testNotSameName(){
//        Ingredient ingredient = new Ingredient("Garlic", "Herb", 1);
//        Ingredient ingredient1 = new Ingredient("Ginger", "Herb", 2);
//
//        assertNotEquals(ingredient, ingredient1);
//    }
//
//    //Test that an ingredient isn't equal to null
//    @Test
//    void testIngredientNotEqualToNull(){
//        Ingredient ingredient = new Ingredient("Garlic", "Herb", 1);
//
//        assertNotEquals(ingredient, null );
//    }
//
//    //Test that an ingredient isn't equal to a different object type
//    @Test
//    void testOtherObjectNotEqual(){
//        Ingredient ingredient = new Ingredient("Garlic", "Herb", 1);
//        String string = "Garlic";
//
//        assertNotEquals(ingredient, string);
//    }
//}
