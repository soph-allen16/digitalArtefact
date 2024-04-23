package view.menu;

import view.service.MealPlanService;
import view.service.MealService;

public class MealPlanningMenu extends Menu {
    private final MealPlanService mealPlanService;

    public MealPlanningMenu(MealPlanService mealPlanService) {
        super();
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
                mealPlanService.addNewMeal();
            }else if(choice ==2){
                //TODO : VIEW MEAL PLANS
            }
            super.runMenu();
        }
    }
}