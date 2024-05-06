package model.entity;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MealTest {

    private int id = 0;
    private String name = "Test";
    private HashMap<Ingredient, Integer> ingredients = new HashMap<>();
    Meal meal = new Meal(id, name, ingredients);

    //Test that constructor sets fields as expected
    @Test
    public void testMealConstructor() {
        assertEquals(meal.getMealName(), name);
        assertEquals(meal.getMealId(), id);
        assertEquals(meal.getIngredients(), ingredients);
    }

    //Test that an ingredient instance equals itself
    @Test
    public void testEqualsSameEntity() {
        assertEquals(meal, meal);
    }

    //Test that Meals with the same name are equal
    @Test
    public void testEqualsSameName() {
        Meal meal1 = new Meal(2, name, null);
        assertEquals(meal, meal1);
    }

    //Test that Meals with different names are not equal
    @Test
    public void testNotSameName() {
        Meal meal1 = new Meal(id, "Ginger", ingredients);
        assertNotEquals(meal, meal1);
    }

    //Test that a Meal isn't equal to null
    @Test
    public void testMealNotEqualToNull() {
        assertNotEquals(meal, null);
    }

    //Test that a Meal isn't equal to a different object type
    @Test
    public void testOtherObjectNotEqual() {
        String string = "Garlic";
        assertNotEquals(meal, string);
    }

    //Check toString non null
    @Test
    public void testToString(){
        assertNotNull(meal.toString());
    }

    //Check toCsv non null
    @Test
    public void testToCsv(){
        assertNotNull(meal.toCSV());
    }
}
