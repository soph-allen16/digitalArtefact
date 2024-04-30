package utils.fileUtils;

import model.entity.Ingredient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import static constants.FileConstants.INGREDIENT_FILE;

public class WriteIngredients {

    public static void writeIngredientsToFile(Ingredient ingredient){
        File file = new File(INGREDIENT_FILE);
        file.getParentFile().mkdirs();

        try{
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(ingredient.toCsvString() + "\n");

            bufferedWriter.close();

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }


}
