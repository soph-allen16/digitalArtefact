package digitalArtefact;
import digitalArtefact.entity.ApplicationMenu;
import digitalArtefact.entity.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ApplicationMenu controller = new ApplicationMenu(new User(scanner), scanner);
    }
}
