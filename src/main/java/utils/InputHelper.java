package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputHelper {
    private final Scanner scanner = new Scanner(System.in);

    public int getIntegerInput(String prompt){
        System.out.println(prompt + ": ");
        return getIntegerInput();
    }

    public int getIntegerInput(){
        int input = -1;

        try {
            input = scanner.nextInt();
        }catch (Exception ignored){}

        scanner.nextLine();

        return input;
    }

    public int getPositiveIntegerInput(String prompt){
        int input = getIntegerInput(prompt);

        while (input<0){
            System.out.println( "Please enter a positive integer!" );
            input = getIntegerInput("Try again");
        }
        return input;
    }

    public String getStringInput(String prompt){
        System.out.println(prompt + ": ");
        return getStringInput();
    }
    public String getStringInput(){
        String input = scanner.nextLine();
        if(input.isBlank()) {
            System.out.println("Input cannot be blank. Please try again.");
            getStringInput();
        }
        return input;
    }

    public ArrayList<String> getListInput(){
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

    public ArrayList<String> getCommaSeparatedInput(String prompt){
        String input = getStringInput(prompt);
        ArrayList<String> list = new ArrayList<>( Arrays.stream(input.split(",")).map(String::trim).toList()  );
        return list;
    }

    public void closeScanner(){
        scanner.close();
    }
}
