package view.service;

import model.repository.MealRepository;
import org.apache.commons.lang3.StringUtils;
import utils.InputHelper;
import utils.TableHelper;

public class MealService {

    private final InputHelper inputHelper;
    private final MealRepository mealRepository;
    private final TableHelper tableHelper;

    public MealService(InputHelper inputHelper){
        this.tableHelper = new TableHelper(new String[] {"ID", "Name", "Type"});
        this.inputHelper = inputHelper;
        this.mealRepository = new MealRepository(this.inputHelper);
    }

    //view list
    public void viewMealList(){
        System.out.println(StringUtils.center("***** Meals *****", 49));
        tableHelper.printMeals(mealRepository.getAllMeals());
    }

    //view single

    //find by id
    //delete
    //update
}
