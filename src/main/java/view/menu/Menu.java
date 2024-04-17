package view.menu;

import utils.InputHelper;

public class Menu {

    protected final InputHelper inputHelper;
    protected String[] options;
    protected boolean tryAgain = true;
    protected String menuName;
    protected int choice;

    public Menu(InputHelper inputHelper){
        this.inputHelper = inputHelper;
    }

    public void runMenu(){
        StringBuilder str = new StringBuilder();

        str.append("\r\n***** ").append(menuName).append(" *****\r\n");

        for( int i = 0 ; i < options.length; i++ ){
            str.append( i+1 ).append(" : " ).append( options[i] ).append("\r\n");
        }

        str.append( options.length + 1 ).append(" : " ).append( "Return" ).append("\r\n");
        str.append("Please select: (1-").append(options.length + 1).append(")");
        System.out.println(str.toString());

        choice = inputHelper.getmenuInput(options.length + 1);

        if(choice == options.length + 1){
            tryAgain = false;
        }
    }
}
