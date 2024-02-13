package Session3;

public class Exercise1 {
    public static void main( String[] args){
        boolean b = false;
        int x = 0;

        System.out.println( "b && (x==0) = " + ( b && (x==0) ));
        System.out.println( "b || (x==0) = " + ( b || (x==0) ));
        System.out.println( "!b && (X==0) = " + ( !b && (x==0) ));
        System.out.println( "!b || (x==0) = " + (!b || (x==0)));
        System.out.println( "b && (x != 0) = " + (b && (x != 0 )));
        System.out.println( "b || (x != 0 ) = " + (b || (x != 0)));
        System.out.println("!b && (x !=0) =" + (!b && (x!=0)));
        System.out.println( "!b || (x!=0) = " + (!b || (x!=0)));
    }
}
