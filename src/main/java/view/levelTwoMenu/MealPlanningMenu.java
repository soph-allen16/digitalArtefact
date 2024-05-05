package view.levelTwoMenu;

import model.service.MealPlanService;
import utils.InputHelper;
import view.Menu;

public class MealPlanningMenu extends Menu {
    private final MealPlanService mealPlanService;

    public MealPlanningMenu(MealPlanService mealPlanService) {
        super();
        this.mealPlanService = mealPlanService;
        menuName = "Meal Planning";

        menuOptions = new String[] {
                "Add new meal plan",
                "View list of meal plans",
                "View meal plan details",
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
            }else if(choice == 2){
                //View list of meal plans
                mealPlanService.viewMealPlanList();
            }else if(choice == 3){
                //View specific meal plan
                mealPlanService.viewMealPlan();
            }else if(choice==4){
                //generate shopping list
                mealPlanService.getShoppingList(InputHelper.getIntegerInput("Enter the ID of a meal plan"));
            }
            super.runMenu();
        }
    }
}
