package utils.fileUtils;

import model.entity.Ingredient;
import model.entity.Meal;
import model.service.IngredientService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

import static constants.FileConstants.MEAL_FILE;

public class MealsFileUtil {
    public static void saveMealsToFile(List<Meal> meals){
        File file = new File(MEAL_FILE);
        file.getParentFile().mkdirs();

        try{
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Meal i : meals) {
                bufferedWriter.write(i.toCSV() + "\n");
            }
            bufferedWriter.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    //Read meals from file and return entity
    public static List<Meal> readMealsFromFile(IngredientService ingredientService){
        File file = new File(MEAL_FILE);
        List<Meal> meals = new ArrayList<>();

        if(!file.exists()){
            return meals;
        }
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                meals.add( getMealFromRow( scanner.nextLine(), ingredientService) );
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return meals;
    }

    //Using a custom deserialization method due to issues importing libraries when switching between home and uni
    //Obtains meal from stored format
    public static Meal getMealFromRow(String row, IngredientService ingredientService){
        HashMap<Ingredient, Integer> ingredients = new HashMap<>();
        String[] rowValues = row.split(",");

        //Check that the row has exactly 3 elements: id, name and ingredients
        if(rowValues.length != 3 ){
            return null;
        }

        //Deserialize the stored hashmap, stored in the form: Ingredient1:qty1;ingredient2:qty2
        String[] hashMapValues = rowValues[2].split(";");

        for(String s : hashMapValues){
            //validate that the entry is not empty
            if(s.isBlank()){
                continue;
            }
            //Split by colon, stored in the form IngredientName:Qty
            String[] mapValues = s.split(":");
            //Find the ingredient with the corresponding name
            Ingredient ingredient = ingredientService.findIngredientByName(mapValues[0]);
            //Add the ingredient and value to the hashmap
            ingredients.put(ingredient,Integer.parseInt( mapValues[1] ) );
        }
        return new Meal(Integer.parseInt(rowValues[0]), rowValues[1], ingredients);
    }
}
