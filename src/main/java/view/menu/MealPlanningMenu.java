package view.menu;

import model.service.MealPlanService;

public class MealPlanningMenu extends Menu {
    private final MealPlanService mealPlanService;

    public MealPlanningMenu(MealPlanService mealPlanService) {
        super();
        this.mealPlanService = mealPlanService;
        menuName = "Meal Planning";

        menuOptions = new String[] {
                "Add new meal plan",
                "View meal plans"
        };
    }

    @Override
    public void runMenu(){
        super.runMenu();
        while(tryAgain){
            if(choice == 1){
                mealPlanService.addNewMealPlan();
            }else if(choice == 2){
                mealPlanService.viewMealPlanList();
            }
            super.runMenu();
        }
    }
}
