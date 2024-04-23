package utils;

import model.entity.Ingredient;
import model.entity.Meal;

import java.util.Arrays;
import java.util.List;

public class TableHelper {
    private final int tableWidth = 60;

    public void printTable(String[][] table, String[] headers, String title) {
        int numberOfColumns = headers.length;
         int columnWidth = tableWidth/numberOfColumns;

        String[] headerArray = Arrays.stream(headers).map(String::trim).toArray(String[]::new);
        String format = formatBuilder(numberOfColumns);

        //System.out.println(StringUtils.center("***** "+ title +" *****", tableWidth + numberOfColumns + 1 ));
        System.out.format(format, headerArray);
        System.out.println(dividerBuilder(numberOfColumns));

        for (String[] row : table) {
            System.out.format(format, row);
        }
    }

    public String[][] createIngredientTableFromList(List<Ingredient> ingredientList) {
        return ingredientList.stream().map( i -> new String[] { Integer.toString( i.getIngredientId() ) , i.getIngredientName()}).toArray(String[][]::new);
    }

    public String[][] createMealTableFromList(List<Meal> mealList) {
        return mealList.stream().map( m -> new String[] { Integer.toString( m.getMealId() ), m.getMealName() } ).toArray(String[][]::new);
    }

    private String formatBuilder(int numberOfColumns) {
        int columnWidth = tableWidth / numberOfColumns;
        StringBuilder str = new StringBuilder();
        str.append("|");
        for (int i = 0; i < numberOfColumns; i++) {
            str.append("%-" + columnWidth + "s|");
        }
        str.append("%n");
        return str.toString();
    }

    private String dividerBuilder(int numberOfColumns) {
        StringBuilder str = new StringBuilder();
        str.append(new String(new char[60]).replace("\0", "_") );

        for(int i=0; i<=numberOfColumns;i++){
            str.append("_");
        }
        return str.toString();
    }


}