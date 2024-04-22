package view.menu;

import model.entity.MealPlan;
import utils.InputHelper;
import view.menu.mealPlan.AddNewMealPlan;
import view.service.MealPlanService;

public class MealPlanningMenu extends Menu {
    private final AddNewMealPlan addNewMealPlan;
    private final MealPlanService mealPlanService;

    public MealPlanningMenu(InputHelper inputHelper, MealPlanService mealPlanService) {
        super(inputHelper);
        this.addNewMealPlan = new AddNewMealPlan(inputHelper);
        this.mealPlanService = mealPlanService;

        menuName = "Meal Planning";
        options = new String[] {
                "Add new meal plan",
                "View meal plans"
        };
    }

    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain){
            if(choice ==1){
                addNewMealPlan.runMenu();
            }else if(choice ==2){

            }
            super.runMenu();
        }
    }
}
