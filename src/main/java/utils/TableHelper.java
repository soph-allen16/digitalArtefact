package utils;

import model.entity.Ingredient;
import model.entity.Meal;
import model.entity.MealPlan;

import java.util.Arrays;
import java.util.List;

public class TableHelper {
    public static final int tableWidth = 40;

    //Width of the margin column to contain IDs
    private static final int marginWidth = 10;
    private static final int numberOfColumns = 2;

    //Prints a 2 column table with smaller ID column 1
    public static void printTwoColumnTable(String[][] table, String[] headers) {
        if(headers.length != 2){
            System.out.println("Number of columns must be two!");
            return;
        }

        //Remove any trailing spaces from headers
        String[] headerArray = Arrays.stream(headers).map(String::trim).toArray(String[]::new);

        //Builds the format for the table
        String format = twoColumnFormatBuilder();

        //Centers the headers in the column using the format created above
        System.out.format(format, headerArray);
        System.out.println(dividerBuilder(numberOfColumns));

        for (String[] row : table) {
            System.out.format(format, row);
        }
    }

    public static String[][] createIngredientTableFromList(List<Ingredient> ingredientList) {
        return ingredientList.stream().map( i -> new String[] { Integer.toString( i.getIngredientId() ) , i.getIngredientName()}).toArray(String[][]::new);
    }

    public static String[][] createMealTableFromList(List<Meal> mealList) {
        return mealList.stream().map( m -> new String[] { Integer.toString( m.getMealId() ), m.getMealName() } ).toArray(String[][]::new);
    }

    public static String[][] createMealPlanTableFromList(List<MealPlan> mealPlans){
        return mealPlans.stream().map( m -> new String[] {Integer.toString(m.getMealPlanId()), m.getMealPlanName()}).toArray(String[][]::new);
    }

    //Creates a format for a centered column
    private static String twoColumnFormatBuilder(){
        int columnWidth = tableWidth - marginWidth;
        StringBuilder str = new StringBuilder();

        str.append("|");
        //Format will be replaced with a centered string by System.out.format
        str.append("%-" + marginWidth + "s|");
        str.append("%-" + columnWidth + "s|");
        str.append("%n");

        return str.toString();
    }

    //Creates a long divider for between the headers and table content
    private static String dividerBuilder(int numberOfColumns) {
        StringBuilder str = new StringBuilder();
        str.append(new String(new char[tableWidth]).replace("\0", "_") );

        for(int i=0; i<=numberOfColumns;i++){
            str.append("_");
        }
        return str.toString();
    }


}