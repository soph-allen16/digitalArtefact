package utils;

public class OutputHelper {

    public static final int titleSize = TableHelper.tableWidth+2;

    public static void printTitle(String string){
        System.out.println(createTitle(string));
    }

    public static String createTitle(String string){
        StringBuilder s = new StringBuilder();
        s.append(createCharString('*', titleSize)).append("\r\n");
        s.append("*").append(centerString(string, titleSize - 2)).append("*").append("\r\n");
        s.append(createCharString('*', titleSize)).append("\r\n");
        return s.toString();
    }

    public static String centerString(String string, int size){
        int padding = (size - string.length())/2;
        StringBuilder s = new StringBuilder();
        s.append(createCharString(' ', padding));
        s.append(string);
        s.append(createCharString(' ', padding));
        return s.toString();
    }

    public static String createCharString(char c, int size){
        return new String(new char[size]).replace("\0", String.valueOf(c));
    }
}
