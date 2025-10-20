import java.util.*;
public class ReverseNo{

    static int reversDigits(int n) {
        // converting number to string
        StringBuffer s
            = new StringBuffer(String.valueOf(n));

        // reversing the string
        s.reverse();

        // converting string to integer
        n = Integer.parseInt(String.valueOf(s));

        // returning integer
        return n;
    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println(reversDigits(n));
    }
}

