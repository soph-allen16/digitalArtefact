package model.repository;

import utils.InputHelper;
import model.entity.Ingredient;
import java.util.ArrayList;
import java.util.List;

public class IngredientRepository {
    private final InputHelper inputHelper;
    private final List<Ingredient> ingredientList;

    public IngredientRepository(InputHelper inputHelper){
        this.inputHelper = inputHelper;
        ingredientList = new ArrayList<Ingredient>();
    }

    public List<Ingredient> getAllIngredients(){
        return this.ingredientList;
    }

    public void addIngredient(String ingredientName, String ingredientType){
        Ingredient ingredient = new Ingredient( ingredientName, ingredientType,ingredientList.size()+1 );
        if( ingredientList.contains(ingredient) ){
            System.out.println("This ingredient is already in the list");
        }else{
            ingredientList.add(ingredient);
        }
    }

    public void removeIngredient( String name ){
        Ingredient ingredient = findIngredientByName( name );

        if( ingredient == null ){
            System.out.println("The ingredient you entered does not exist.");
        }else{
            ingredientList.remove(ingredient);
        }
    }

    public Ingredient findIngredientByName(String name){
        for( Ingredient i : ingredientList ) {
            if (i.getIngredientName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public Ingredient findIngredientById(int id){
        for( Ingredient i : ingredientList ) {
            if ( i.getIngredientId() == id ) {
                return i;
            }
        }
        return null;
    }

    public void modifyIngredientMenu(Ingredient ingredient){
        if (  ingredient == null ){
            System.out.println("The ingredient you entered does not exist.");
        }else{
            boolean tryAgain = true;

            while(tryAgain) {
                Ingredient newIngredient = ingredient ;

                System.out.println("Ingredient: " + ingredient.getIngredientName() + " Type: " + ingredient.getIngredientType());
                System.out.println("""
                        \r\n
                        1: Modify name
                        2: Modify type
                        3: Save
                        4: Cancel
                        """);
                int choice = inputHelper.getIntegerInput();

                if( choice == 1 ){
                    String newName = inputHelper.getStringInput("Please enter a name");
                    newIngredient.setIngredientName( newName );
                }else if( choice == 2 ){
                    String newType = inputHelper.getStringInput("Please enter a type");
                    newIngredient.setIngredientType( newType );
                }else if( choice == 3 ){
                    int index = ingredientList.indexOf(ingredient);
                    ingredientList.set(index, newIngredient);
                    tryAgain = false;
                }else if( choice == 4 ){
                    tryAgain = false;
                }else{
                    System.out.println("Invalid input. Please try again.");
                }

            }
        }
    }

}
