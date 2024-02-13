package Session3;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a month number:");
        int monthNumber = scanner.nextInt();

        switch (monthNumber){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println("31 Days");
                break;
            case 2:
                System.out.println("28 Days");
                break;
            default:
                System.out.println("30 Days");
                break;
        }

        scanner.close();
    }
}
