package constants;

import java.io.File;
//Constants for writing/reading entities to csv
public class FileConstants {
    public static String DIRECTORY = "src" + File.separator + "files";
    public static String INGREDIENT_FILE = DIRECTORY + File.separator + "ingredients.csv";
    public static String MEAL_FILE = DIRECTORY + File.separator + "meals.csv";
    public static String MEAL_PLAN_FILE = DIRECTORY + File.separator + "mealplans.csv";
}
