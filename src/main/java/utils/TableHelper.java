package utils;

import model.entity.Ingredient;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class TableHelper {

    private String[] headers;
    int width;

    public TableHelper(String[] headers){
        this.headers = headers;
        this.width = headers.length;
    }

    public void print(List<Ingredient> ingredientList){
        String[][] table =  ingredientList.stream().map(Ingredient::toArray).toArray(String[][]::new);
        headers = Arrays.stream(headers).map(s -> StringUtils.center(s, 15)).toArray(String[] ::new);

        System.out.format("|%-15s|%-15s|%-15s|%n",headers);
        System.out.println("_________________________________________________");
        for( String[] row : table){
            System.out.format("|%-15s|%-15s|%-15s|%n", row);
        }
    }
}

