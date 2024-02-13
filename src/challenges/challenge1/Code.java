package challenges.challenge1;

import javax.net.ssl.HandshakeCompletedEvent;
import java.util.*;
import java.util.stream.Collectors;

public class Code {
    private List<Integer> codedMessage;
    private HashMap<Integer, String> codex = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    Code(){
        getMessage();
    }

    private void getMessage(){
        System.out.println("What message would you like to decode?");
        String message = scanner.nextLine();
        codedMessage = Arrays.stream(message.split(" ")).map(s -> Integer.parseInt(s)).toList();
        menu();
    }

    private void menu(){
        System.out.println("""
                *** Menu Options ***
                1: Enter codex guesses
                2: View codex
                3: View decoded message 
                4: Exit
                """);

        int choice = scanner.nextInt();
        scanner.nextLine();

        if(choice == 1){
            addToCodex();
        }else if(choice ==2){
            viewCodex();
        }else if(choice == 3){
            viewMessage();
        }else if( choice == 4){
            System.exit(0);
        }

    }

    private void addToCodex(){
        System.out.println("Please enter codex guesses in the form: 1=x; 2=y");
        Scanner scanner = new Scanner(System.in);
        String inputCodex = scanner.nextLine();

        List<String> codexGuesses = Arrays.stream( inputCodex.split(";")).toList();
        for( String s : codexGuesses){
            String[] guess = s.split("=");
            codex.put( Integer.parseInt(guess[0]),guess[1]);
        }
        System.out.println("Codex Updated.");
        System.out.println(" ");
        menu();
    }

    private void viewCodex(){
        System.out.println("*** Codex ***");
        for(Map.Entry<Integer,String> e : codex.entrySet() ){
            System.out.println(e.getKey() + " = " + e.getValue());
        }
        System.out.println(" ");
        menu();
    }

    private void viewMessage(){
        String messageString = codedMessage.stream().map( i -> codex.get(i) == null ? String.valueOf(i) : codex.get(i) ).collect(Collectors.joining(" "));
        System.out.println(messageString);
        System.out.println(" ");
        menu();
    }
}
