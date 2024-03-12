package main.utils;

import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner = new Scanner(System.in);

    public int getIntegerInput(String prompt){
        System.out.println(prompt + ": ");
        return getIntegerInput();
    }

    public int getIntegerInput(){
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public String getStringInput(String prompt){
        System.out.println(prompt + ": ");
        return getStringInput();
    }
    public String getStringInput(){
        return scanner.nextLine();
    }

    public void closeScanner(){
        scanner.close();
    }
}
