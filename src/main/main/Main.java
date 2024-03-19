import entity.ApplicationMenu;
import utils.InputHelper;

public class Main {
    public static void main(String[] args){
        InputHelper inputHelper = new InputHelper();
        ApplicationMenu controller = new ApplicationMenu(inputHelper);
    }
}
