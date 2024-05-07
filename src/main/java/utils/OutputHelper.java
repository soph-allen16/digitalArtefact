package utils;

//Helper class containing string utilities for printing to console
public class OutputHelper {

    public static final int titleSize = TableHelper.tableWidth+3;

    //Prints a title surrounded by a box
    public static void printTitle(String string){
        System.out.println(createTitle(string));
    }

    //Creates a title in a box
    public static String createTitle(String string){
        StringBuilder s = new StringBuilder();
        s.append(createCharString('*', titleSize)).append("\r\n");
        s.append("*").append(centerString(string, titleSize - 2)).append("*").append("\r\n");
        s.append(createCharString('*', titleSize)).append("\r\n");
        return s.toString();
    }

    //Centers a string given a required size
    public static String centerString(String string, int size){
        int padding = (size - string.length())/2;
        StringBuilder s = new StringBuilder();
        s.append(createCharString(' ', padding));
        s.append(string);
        s.append(createCharString(' ', padding));
        return s.toString();
    }

    //Creates a string of fixed length with a single repeated char
    public static String createCharString(char c, int size){
        return new String(new char[size]).replace("\0", String.valueOf(c));
    }
}
