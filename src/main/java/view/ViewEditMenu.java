package view;

import model.repository.IngredientRepository;
import utils.InputHelper;

public class ViewEditMenu {
    private final InputHelper inputHelper;

    public ViewEditMenu(InputHelper inputHelper){
        this.inputHelper = inputHelper;
    }

    public void runMenu(){
        boolean tryAgain = false;

        do{
            System.out.println("""
                    \r\n
                    What would you like to do?
                    1: View/Edit Ingredients
                    2: View/Edit Meals
                    3: Return
                    Please select (1-3)
                    """);

            int choice = inputHelper.getIntegerInput();

            if(choice == 1){

            }if(choice == 2){

            }if(choice == 3){
                return;
            }
        }while(tryAgain);
    }
}
