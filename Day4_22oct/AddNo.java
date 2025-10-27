
import java.util.Scanner;

//Addition of numbers

public class AddNo{
    
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
     System.out.println("Enter number");
     int x = sc.nextInt();
     System.out.println("Enter another number");
     int y = sc.nextInt();

     System.out.println("Addition of numbers:" + (x+y));

    }
}