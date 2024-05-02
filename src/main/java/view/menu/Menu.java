package view.menu;

import utils.InputHelper;
import utils.OutputHelper;

/*
    Superclass providing shared menu functionality including printing out options.
 */
public class Menu {
    //Defines the unique options for the menu
    protected String[] menuOptions;

    //Controls looping behaviour of the menu
    protected boolean tryAgain = true;

    //Name of the menu to be printed
    protected String menuName;

    //User inputted choice
    protected int choice;

    public Menu(){
    }

    public void runMenu(){
        StringBuilder str = new StringBuilder();

        str.append(OutputHelper.createTitle(menuName));

        for(int i = 0; i < menuOptions.length; i++ ){
            str.append( i+1 ).append(" : " ).append( menuOptions[i] ).append("\r\n");
        }

        str.append( menuOptions.length + 1 ).append(" : " ).append( "Return" ).append("\r\n");
        str.append("Please select: (1-").append(menuOptions.length + 1).append(")");
        System.out.println(str.toString());

        choice = InputHelper.getMenuInput(menuOptions.length + 1);

        if(choice == menuOptions.length + 1){
            tryAgain = false;
        }
    }
}
