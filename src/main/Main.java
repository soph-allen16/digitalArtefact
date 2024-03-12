package main;
import main.entity.ApplicationMenu;
import main.utils.InputHelper;

public class Main {
    public static void main(String[] args){
        InputHelper inputHelper = new InputHelper();
        ApplicationMenu controller = new ApplicationMenu(inputHelper);
    }
}
