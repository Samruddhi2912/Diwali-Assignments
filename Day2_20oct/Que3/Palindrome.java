
import java.util.Scanner;

public class Palindrome
{
  public static void main (String[]args)
  {
    Scanner sc = new Scanner(System.in);
    //variables initialization
    int num = sc.nextInt();
    int reverse = 0, rem, temp;

    // palindrome if num and reverse are equal
    if (getReverse(num, reverse) == num)
     System.out.println ( "True");
    else
      System.out.println ("false");
  }
  
  static int getReverse(int num, int rev){
    if(num == 0)
        return rev;
    
    int rem = num % 10;
    rev = rev * 10 + rem;
    
    return getReverse(num / 10, rev);
}
}