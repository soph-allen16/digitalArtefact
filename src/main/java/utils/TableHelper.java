package utils;

import model.entity.Ingredient;
import model.entity.Meal;
import model.entity.MealPlan;

import java.util.Arrays;
import java.util.List;

//Helper class allowing printing of tabular data to console
public class TableHelper {
    public static final int tableWidth = 40;

    //Width of the margin column to contain IDs
    private static final int marginWidth = 5;

    //Prints a 2 column table with smaller ID column 1
    public static void printTwoColumnTable(String[][] table, String[] headers) {
        if(headers.length != 2){
            throw new IllegalArgumentException("Number of headers must be 2");
        }
        //Remove any trailing spaces from headers
        String[] headerArray = Arrays.stream(headers).map(String::trim).toArray(String[]::new);

        //Builds the format for the table
        String format = twoColumnFormatBuilder();

        //Centers the headers in the column using the format created above
        System.out.format(format, headerArray);

        //Prints a long divider for the headers
        System.out.println(OutputHelper.createCharString('_', tableWidth+3));
        //Prints each row in the table if there are any
        if(table!=null) {
            for (String[] row : table) {
                System.out.format(format, row);
            }
        }
    }

    //Creates a format for a columns
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

    //Methods for translating entity lists into string arrays for processing
    public static String[][] createIngredientTableFromList(List<Ingredient> ingredientList) {
        return ingredientList.stream().map( i -> new String[] { Integer.toString( i.getIngredientId() ) , i.getIngredientName()}).toArray(String[][]::new);
    }
    public static String[][] createMealTableFromList(List<Meal> mealList) {
        return mealList.stream().map( m -> new String[] { Integer.toString( m.getMealId() ), m.getMealName() } ).toArray(String[][]::new);
    }
    public static String[][] createMealPlanTableFromList(List<MealPlan> mealPlans){
        return mealPlans.stream().map( m -> new String[] {Integer.toString(m.getMealPlanId()), m.getMealPlanName()}).toArray(String[][]::new);
    }
}