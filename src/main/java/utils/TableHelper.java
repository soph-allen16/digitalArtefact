package utils;

import model.entity.Ingredient;

import java.util.List;

public class TableHelper {

    private String[] headers;
    int width;

    public TableHelper(String[] headers){
        this.headers = headers;
        this.width = headers.length;
    }

    public void print(List<Ingredient> ingredientList){
        String[][] table =  ingredientList.stream().map(i -> i.toArray()).toArray(String[][]::new);

        System.out.format("%-15s%-15s%-15s%n",headers);
        System.out.println("_____________________________________________");
        for( String[] row : table){
            System.out.format("%-15s%-15s%-15s%n", row);
        }
    }
}

