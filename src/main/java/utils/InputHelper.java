package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
//Helper class for getting user input with basic validation
public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    //Get integer input from user with a prompt
    public static int getIntegerInput(String prompt){
        System.out.println(prompt + ": ");
        return getIntegerInput();
    }

    //Get integer input from the user
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

    //Validate that the input is positive
    public static int getPositiveIntegerInput(String prompt){
        int input = getIntegerInput(prompt);
        while (input<0){
            System.out.println( "Please enter a positive integer!" );
            input = getIntegerInput("Try again");
        }
        return input;
    }

    //Menu method which loops until a valid input is given
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

    //Get string input and display prompt to user
    public static String getStringInput(String prompt){
        System.out.println(prompt + ": ");
        return getStringInput();
    }

    //Get string input from user and validate that it is not blank
    public static String getStringInput(){
        String input = scanner.nextLine();
        if(input.isBlank()) {
            System.out.println("Input cannot be blank. Please try again.");
            getStringInput();
        }
        return input;
    }

    //Get comma separated input allowing the user to input multiple items at once
    public static ArrayList<String> getCommaSeparatedInput(String prompt){
        String input = getStringInput(prompt);
        return new ArrayList<>( Arrays.stream(input.split(",")).map(String::trim).toList()  );
    }

    public static void closeScanner(){
        scanner.close();
    }
}
