package utils.fileUtils;

import model.entity.Meal;
import model.entity.MealPlan;
import model.service.MealService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import static constants.FileConstants.MEAL_PLAN_FILE;

//Class to handle loading and saving of meal plans to csv-style file
public class MealPlanFileUtil {

    //save all meal plans to file on application ending
    public static void saveMealPlansToFile(List<MealPlan> mealPlanList){
        File file = new File(MEAL_PLAN_FILE);
        file.getParentFile().mkdirs();

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(MealPlan m : mealPlanList){
                bufferedWriter.write(m.toCSV()+ "\n");
            }
            bufferedWriter.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    //load meal plans from file when application starts
    public static List<MealPlan> readMealPlansFromFile(MealService mealService){
        File file = new File(MEAL_PLAN_FILE);
        List<MealPlan> mealPlans = new ArrayList<>();

        if (!file.exists()){
            return mealPlans;
        }
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                mealPlans.add( getMealPlanFromRow(scanner.nextLine(), mealService) );
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return mealPlans;
    }

    //Using a custom deserialization method due to issues importing libraries when switching between home and uni
    public static MealPlan getMealPlanFromRow(String row, MealService mealService){
        LinkedHashMap<String, Meal> meals = new LinkedHashMap<>();
        String[] rowValues = row.split(",");

        //Verify that there are 3 elements: ID, name and meal list
        if(rowValues.length!=3){
            return null;
        }

        //Deserialize the hashmap, stored in form: Day1:MealId;Day2:MealId
        String[] hashMapEntries = rowValues[2].split(";");

        for(String s : hashMapEntries){
            //Validate that it is non-empty
            if (s.isBlank()) {
                continue;
            }
            //Split using the colon to get day and meal values
            String[] mapValues = s.split(":");
            //Find meal by ID using service
            Meal meal = mealService.findMealById(Integer.parseInt(mapValues[1]));
            //Add the day and the meal back into the LinkedHashMap
            meals.put(mapValues[0], meal);
        }
        return new MealPlan(Integer.parseInt(rowValues[0]), rowValues[1], meals);
    }
}
