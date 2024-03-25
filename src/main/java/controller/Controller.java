package controller;

import utils.InputHelper;
import view.MainMenu;

public class Controller {
    private final InputHelper inputHelper;
    private final MainMenu mainMenu;

    public Controller(){
        this.inputHelper = new InputHelper();
        this.mainMenu = new MainMenu(inputHelper);
    }

}
