package model.repository;

import model.entity.Ingredient;
import model.entity.Meal;
import model.service.IngredientService;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MealRepositoryTest {
    private final MealRepository mealRepository = new MealRepository(new IngredientService());

    @DisplayName("Test get all meals returns non null")
    @Test
    public void testGetAllIngredients(){
        assertNotNull(mealRepository.getAllMeals());
    }

    @DisplayName("Test add and delete meal with success")
    @Test
    public void testAddAndDeleteIngredient(){
        Meal meal = mealRepository.addMeal("testMeal", null);
        assertNotNull(meal);
        assert(mealRepository.getAllMeals()).contains(meal);

        mealRepository.removeMeal(meal);
        assertFalse(mealRepository.getAllMeals().contains(meal));
    }

    @DisplayName("Test add ingredient with failure")
    @Test
    public void addIngredientWithFailure(){
        assertThrows(UnsupportedOperationException.class, ()-> mealRepository.addMeal("Chilli", null));
    }

    @DisplayName("Test delete ingredient with failure")
    @Test
    public void testDeleteWithFailure(){
        assertThrows(NoSuchElementException.class, ()-> mealRepository.removeMeal(null));
    }

    @DisplayName("Test find by name")
    @Test
    public void testFindByName(){
        assertNotNull(mealRepository.findMealByName("Chilli"));;
        assertNull(mealRepository.findMealByName("testName"));
    }

    @DisplayName("Test find by id")
    @Test
    public void testFindById(){
        assertNotNull(mealRepository.findMealById(0));;
        assertNull(mealRepository.findMealById(9999));
    }
}