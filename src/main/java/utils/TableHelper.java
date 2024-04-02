package utils;

import model.entity.Ingredient;
import model.entity.Meal;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class TableHelper {

    private String[] headers;
    private int width;

    public TableHelper(String[] headers){
        this.headers = headers;
        this.width = headers.length;
    }

    //Remove if not necessary?
    public TableHelper(){

    }

    public void printIngredients(List<Ingredient> ingredientList){
        String[][] table =  ingredientList.stream().map(Ingredient::toArray).toArray(String[][]::new);
        headers = Arrays.stream(headers).map(s -> StringUtils.center(s, 15)).toArray(String[] ::new);

        System.out.format("|%-15s|%-15s|%-15s|%n",headers);
        System.out.println("_________________________________________________");
        for( String[] row : table){
            System.out.format("|%-15s|%-15s|%-15s|%n", row);
        }
    }

    public void printMeals(List<Meal> mealList){
        String[][] table =  mealList.stream().map(Meal::toArray).toArray(String[][]::new);
        headers = Arrays.stream(headers).map(s -> StringUtils.center(s, 15)).toArray(String[] ::new);

        System.out.format("|%-15s|%-15s|%-15s|%n",headers);
        System.out.println("_________________________________________________");
        for( String[] row : table){
            System.out.format("|%-15s|%-15s|%-15s|%n", row);
        }
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
        this.width = headers.length;
    }
}

