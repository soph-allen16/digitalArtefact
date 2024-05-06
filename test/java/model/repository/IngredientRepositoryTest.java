package model.repository;

import model.entity.Ingredient;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientRepositoryTest {
    private final IngredientRepository ingredientRepository = new IngredientRepository();

    @DisplayName("Test get all ingredients returns non null")
    @Test
    public void testGetAllIngredients(){
        assertNotNull(ingredientRepository.getAllIngredients());
    }

    @DisplayName("Test add and delete ingredient with success")
    @Test
    public void testAddAndDeleteIngredient(){
        Ingredient ingredient = ingredientRepository.addIngredient("Mushroom", "g");
        assertNotNull(ingredient);
        assert(ingredientRepository.getAllIngredients()).contains(ingredient);

        ingredientRepository.removeIngredient(ingredient);
        assertFalse(ingredientRepository.getAllIngredients().contains(ingredient));
    }

    @DisplayName("Test add ingredient with failure")
    @Test
    public void addIngredientWithFailure(){
        assertThrows(UnsupportedOperationException.class, ()-> ingredientRepository.addIngredient("Garlic", "g"));
    }

    @DisplayName("Test delete ingredient with failure")
    @Test
    public void testDeleteWithFailure(){
        assertThrows(NoSuchElementException.class, ()-> ingredientRepository.removeIngredient(null));
    }

    @DisplayName("Test find by name")
    @Test
    public void testFindByName(){
        assertNotNull(ingredientRepository.findIngredientByName("Garlic"));;
        assertNull(ingredientRepository.findIngredientByName("testName"));
    }

    @DisplayName("Test find by id")
    @Test
    public void testFindById(){
        assertNotNull(ingredientRepository.findIngredientById(0));;
        assertNull(ingredientRepository.findIngredientById(9999));
    }
}