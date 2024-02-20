package session4;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("please choose a number");
        int x = s.nextInt();

        for(int i = 0; i<x; i++){
            StringBuilder str = new StringBuilder();

            for( int j=0; j<x-i; j++){
                str.append("*");
            }
            System.out.println(str.toString());
        }

        s.close();
    }
}
