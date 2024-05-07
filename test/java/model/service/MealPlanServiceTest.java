package model.service;

import model.entity.MealPlan;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class MealPlanServiceTest {

    private MealPlanService mealPlanService = new MealPlanService(new MealService(new IngredientService()));

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void testViewMealPlanList() {
        systemIn.provideLines("n");
        mealPlanService.viewMealPlanList();
        assertNotNull(systemOutRule.getLog());
    }

    @Test
    public void testGetShoppingList() {
        mealPlanService.getShoppingList(0);
        assertNotNull(systemOutRule.getLog());
    }

    @Test public void testAddAndDeleteMealPlan(){
        systemIn.provideLines("test", "y", "0", "0", "0", "0", "0", "0", "0", "y");
        MealPlan mealPlan = mealPlanService.addNewMealPlan();
        assertNotNull(mealPlan);
        assertDoesNotThrow(()-> mealPlanService.deleteMealPlanById(mealPlan.getMealPlanId()));
    }

    @Test public void testDeleteMealPlanWrongId(){
        mealPlanService.deleteMealPlanById(-1);
        assertNotNull(systemOutRule.getLog());
    }

    @Test public void testDeleteMealPlanUserCancelled(){
        systemIn.provideLines("n");
        mealPlanService.deleteMealPlanById(0);
        assertNotNull(systemOutRule.getLog());
    }

    @Test public void testDeleteMealPlanWrongInput(){
        systemIn.provideLines("z");
        mealPlanService.deleteMealPlanById(0);
        assertNotNull(systemOutRule.getLog());
    }

    @Test
    public void testGetMealPlans(){
        assertNotNull(mealPlanService.getMealPlans());
    }

    @Test
    public void testViewMealPlan(){
        mealPlanService.viewMealPlan(0);
        assertNotNull(systemOutRule.getLog());
    }
}