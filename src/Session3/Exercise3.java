package Session3;

public class Exercise3 {
    public static void main(String[] args){
        int randomNumber = (int)(Math.random() *10) +1;

        if(randomNumber < 5){
            System.out.println("heads!");
        }else{
            System.out.println("Tails!");
        }
    }
}
