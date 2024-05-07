package view.levelTwoMenu;

import model.service.MealPlanService;
import utils.InputHelper;
import view.Menu;

public class MealPlanningMenu extends Menu {
    private final MealPlanService mealPlanService;

    public MealPlanningMenu(MealPlanService mealPlanService) {
        super();
        //Initialise fields
        this.mealPlanService = mealPlanService;
        //Set menu options and name
        menuName = "Meal Planning";
        menuOptions = new String[] {
                "Add new meal plan",
                "View list of meal plans",
                "View meal plan details",
                "Delete meal plan",
                "Generate shopping list"
        };
    }

    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain){
            if(choice == 1){
                //Add new meal plan
                mealPlanService.addNewMealPlan();
                System.out.println("Meal plan successfully added.");
            }else if(choice == 2){
                //View list of meal plans
                mealPlanService.viewMealPlanList();
            }else if(choice == 3){
                //View specific meal plan
                mealPlanService.viewMealPlan(InputHelper.getPositiveIntegerInput("Enter the ID of the meal plan you would like to view"));
            }else if(choice==4){
                //delete meal plan
                mealPlanService.deleteMealPlanById(InputHelper.getIntegerInput("Enter the ID of a meal plan"));
            }else if(choice==5){
                //generate shopping list
                mealPlanService.getShoppingList(InputHelper.getIntegerInput("Enter the ID of a meal plan"));

            }
            super.runMenu();
        }
    }
}
