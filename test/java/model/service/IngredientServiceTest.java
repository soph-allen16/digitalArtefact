package model.service;

import model.entity.Ingredient;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientServiceTest {

    private IngredientService ingredientService = new IngredientService();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void testViewIngredientList() {
        ingredientService.viewIngredientList();
        assertNotNull(systemOutRule.getLog());
    }

    @Test
    public void testGetIngredientList() {
        assertNotNull(ingredientService.getIngredientsList());
    }

    @Test public void testAddAndDeleteIngredient(){
        assertDoesNotThrow( ()-> ingredientService.addIngredient("test","test"));
        Ingredient ingredient = ingredientService.findIngredientByName("test");
        assertNotNull(ingredient);
        systemIn.provideLines("y");
        assertDoesNotThrow(()-> ingredientService.deleteIngredient(ingredient.getIngredientId()));
    }

    @Test public void testDeleteIngredentWrongId(){
        ingredientService.deleteIngredient(-1);
        assertNotNull(systemOutRule.getLog());
    }

    @Test public void testDeleteIngredientUserCancelled(){
        systemIn.provideLines("n");
        ingredientService.deleteIngredient(0);
        assertNotNull(systemOutRule.getLog());
    }

    @Test public void testDeleteIngredientWrongInput(){
        systemIn.provideLines("z");
        ingredientService.deleteIngredient(0);
        assertNotNull(systemOutRule.getLog());
    }
}