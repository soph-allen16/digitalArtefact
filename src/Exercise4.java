import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a name for the main character:");
        String name = scanner.nextLine();

        System.out.println("Please enter a name for the second character");
        String friend = scanner.nextLine();

        System.out.println("please enter a murder weapon");
        String weapon = scanner.nextLine();

        System.out.println("Please choose a food:");
        String food = scanner.nextLine();

        System.out.println("Once upon a time there was a person called "
        + name +". "
        + name + " had an enemy called " + friend + ". "+
        friend + " tried to stab " + name + " with a " + weapon
        + " but " + name + " had a " + food + " in their pocket, which cushioned the blow and they all lived happily ever after."
        );

        scanner.close();
    }
}
