import java.util.Scanner;

public class CheckEvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  Scanner sc = new Scanner(System.in);
  String ans;
  do {
  System.out.println("Enter number to check it is even or odd");
  int num = sc.nextInt();
    if(num==0) {
    	System.out.println("number is zero");}
    else if(num%2==0) {
    	System.out.println("number is even");
    	}
    else {
    	System.out.println("number is odd");
    }
    System.out.println("do you want to check another number (y/n)");
    ans = sc.next();
    }while(ans.equals("y"));
  sc.close();
  System.out.println("Thank you");
  }
	
	}

