import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");

        String name = scanner.nextLine();

        System.out.println("Hello "+ name);
        System.out.println(name + ", it's great to meet you.");
        System.out.println("Good day, " + name+ ". Hoe are you today?");

        scanner.close();
    }
}