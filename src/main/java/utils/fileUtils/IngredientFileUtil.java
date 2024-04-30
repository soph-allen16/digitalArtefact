package utils.fileUtils;

import model.entity.Ingredient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static constants.FileConstants.INGREDIENT_FILE;

public class IngredientFileUtil {

    public static void saveIngredientsToFile(List<Ingredient> ingredients){
        File file = new File(INGREDIENT_FILE);
        file.getParentFile().mkdirs();

        try{
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Ingredient i : ingredients) {
                bufferedWriter.write(i.toString() + "\n");
            }

            bufferedWriter.close();

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static List<Ingredient> readIngredientsFromFile(){
        File file = new File(INGREDIENT_FILE);
        List<Ingredient> ingredients = new ArrayList<>();

        if(!file.exists()){
        }

        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                ingredients.add( getIngredientFromRow( scanner.nextLine()) );
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ingredients;
    }

    public static Ingredient getIngredientFromRow(String row){
        String[] values = row.split(",");
        if(values.length != 3 ){
            return null;
        }
        return new Ingredient(Integer.parseInt(values[0]), values[1], values[2]);
    }
}
