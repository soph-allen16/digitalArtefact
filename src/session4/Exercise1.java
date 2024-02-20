package session4;

public class Exercise1 {
    public static void main(String[] args){
        int total = 0;
        for(int i = 1; i<21; i++){
            if(i%2==0){
                System.out.println(i);
                total += i;
            }
        }
        System.out.println(total);
    }
}
