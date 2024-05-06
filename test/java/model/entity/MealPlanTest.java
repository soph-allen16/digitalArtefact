package model.entity;

import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MealPlanTest {

    private int id = 0;
    private String name = "Test";
    private LinkedHashMap<String, Meal> mealList = new LinkedHashMap<>();
    MealPlan mealPlan = new MealPlan(id, name, mealList);

    //Test that constructor sets fields as expected
    @Test
    public void testMealPlanConstructor() {
        assertEquals(mealPlan.getMealPlanName(), name);
        assertEquals(mealPlan.getMealPlanId(), id);
        assertEquals(mealPlan.getMealPlanList(), mealList);
    }

    //Test that an ingredient instance equals itself
    @Test
    public void testEqualsSameEntity() {
        assertEquals(mealPlan, mealPlan);
    }

    //Test that MealPlans with the same name are equal
    @Test
    public void testEqualsSameId() {
        MealPlan mealPlan1 = new MealPlan(3, name, null);
        assertEquals(mealPlan, mealPlan1);
    }

    //Test that MealPlans with different names are not equal
    @Test
    public void testNotSameName() {
        MealPlan mealPlan1 = new MealPlan(id, "name2", mealList);
        assertNotEquals(mealPlan, mealPlan1);
    }

    //Test that a MealPlan isn't equal to null
    @Test
    public void testMealPlanNotEqualToNull() {
        assertNotEquals(mealPlan, null);
    }

    //Test that a MealPlan isn't equal to a different object type
    @Test
    public void testOtherObjectNotEqual() {
        String string = "Garlic";
        assertNotEquals(mealPlan, string);
    }

    //Check toString non null
    @Test
    public void testToString(){
        assertNotNull(mealPlan.toString());
    }

    //Check toCsv non null
    @Test
    public void testToCsv(){
        assertNotNull(mealPlan.toCSV());
    }
}