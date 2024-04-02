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
