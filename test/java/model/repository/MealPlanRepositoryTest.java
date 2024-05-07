package model.repository;

import model.entity.Meal;
import model.entity.MealPlan;
import model.service.IngredientService;
import model.service.MealService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MealPlanRepositoryTest {
    private final MealPlanRepository mealPlanRepository = new MealPlanRepository(new MealService(new IngredientService()));

    @DisplayName("Test get all meals returns non null")
    @Test
    public void testGetAllMealPlans(){
        assertNotNull(mealPlanRepository.getMealPlans());
    }

    @DisplayName("Test add and delete meal plan with success")
    @Test
    public void testAddAndDeleteMealPlan(){
        MealPlan mealPlan = mealPlanRepository.addMealPlan("Meal plan", null);
        assertNotNull(mealPlan);
        assert(mealPlanRepository.getMealPlans()).contains(mealPlan);

        mealPlanRepository.deleteMealPlan(mealPlan);
        assertFalse(mealPlanRepository.getMealPlans().contains(mealPlan));
    }

    @DisplayName("Test add Meal plan with failure")
    @Test
    public void addMealPlanWithFailure(){
        assertThrows(UnsupportedOperationException.class, ()-> mealPlanRepository.addMealPlan("First Meal Plan", null));
    }

    @DisplayName("Test delete ingredient with failure")
    @Test
    public void testDeleteMealPlanWithFailure(){
        assertThrows(NoSuchElementException.class, ()-> mealPlanRepository.deleteMealPlan(null));
    }

    @DisplayName("Test find by id")
    @Test
    public void testFindById(){
        assertNotNull(mealPlanRepository.getMealPlanById(0));;
        assertNull(mealPlanRepository.getMealPlanById(9999));
    }

    @DisplayName("Test generate shopping list not null")
    @Test
    public void testGenerateShoppingList(){
        assertNotNull(mealPlanRepository.generateShoppingList(mealPlanRepository.getMealPlanById(0)));
    }
}