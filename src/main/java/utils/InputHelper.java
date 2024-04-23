package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntegerInput(String prompt){
        System.out.println(prompt + ": ");
        return getIntegerInput();
    }

    public static int getIntegerInput(){
        int input = -1;

        try {
            input = scanner.nextInt();
        }catch (Exception ignored){
            System.out.println("Incorrect input. Please enter an integer.");
        }

        scanner.nextLine();

        return input;
    }

    public static int getPositiveIntegerInput(String prompt){
        int input = getIntegerInput(prompt);

        while (input<0){
            System.out.println( "Please enter a positive integer!" );
            input = getIntegerInput("Try again");
        }
        return input;
    }

    public static int getMenuInput(int size){
        boolean valid = false;
        int input = getIntegerInput();

        while (!valid){
            if( (input < 1) || (input > size)){
                System.out.println( "Input must be a positive integer between 1 and " + size + ". Please try again:");
                valid = false;
                input = getIntegerInput();
            }else{
                valid = true;
            }
        }
        return input;
    }

    public static String getStringInput(String prompt){
        System.out.println(prompt + ": ");
        return getStringInput();
    }
    public static String getStringInput(){
        String input = scanner.nextLine();
        if(input.isBlank()) {
            System.out.println("Input cannot be blank. Please try again.");
            getStringInput();
        }
        return input;
    }

    public static ArrayList<String> getListInput(){
        ArrayList<String> list = new ArrayList<>();
        String line;

        while(true){
            line = scanner.nextLine();
            if(line.equalsIgnoreCase("")){
                break;
            }else{
                list.add(line);
            }
        }

        return list;
    }

    public static ArrayList<String> getCommaSeparatedInput(String prompt){
        String input = getStringInput(prompt);
        ArrayList<String> list = new ArrayList<>( Arrays.stream(input.split(",")).map(String::trim).toList()  );
        return list;
    }

    public static void closeScanner(){
        scanner.close();
    }
}
