package model.service;

import model.entity.Meal;
import model.entity.MealPlan;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class MealServiceTest {
    private MealService mealService = new MealService(new IngredientService());

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void testViewMealList() {
        systemIn.provideLines("n");
        mealService.viewMealList();
        assertNotNull(systemOutRule.getLog());
    }

    @Test
    public void testViewMeal(){
        mealService.viewMealDetails(0);
        assertNotNull(systemOutRule.getLog());
    }

    @Test public void testAddAndDeleteMeal(){
        systemIn.provideLines("test", "ingredient", "g", "0");
        Meal meal = mealService.addMeal();
        assertNotNull(meal);
        assertDoesNotThrow(()-> mealService.deleteMealById(meal.getMealId()));
    }

    @Test public void testDeleteMealWrongId(){
        mealService.deleteMealById(-1);
        assertNotNull(systemOutRule.getLog());
    }

    @Test public void testDeleteMealUserCancelled(){
        systemIn.provideLines("n");
        mealService.deleteMealById(0);
        assertNotNull(systemOutRule.getLog());
    }

    @Test public void testDeleteMealWrongInput(){
        systemIn.provideLines("z");
        mealService.deleteMealById(0);
        assertNotNull(systemOutRule.getLog());
    }

    @Test
    public void testGetMealPlans(){
        assertNotNull(mealService.getMeals());
    }


}