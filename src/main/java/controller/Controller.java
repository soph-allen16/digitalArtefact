package controller;

import utils.InputHelper;
import view.menu.MainMenu;
import view.service.IngredientService;

public class Controller {
    private final InputHelper inputHelper;
    private final MainMenu mainMenu;

    private final IngredientService ingredientService;

    public Controller(){
        this.inputHelper = new InputHelper();
        this.ingredientService = new IngredientService(inputHelper);
        this.mainMenu = new MainMenu(inputHelper, ingredientService);
    }

}
