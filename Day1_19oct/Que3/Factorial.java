import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc =new Scanner(System.in);
    String ans;
    do {
    System.out.println("Enter number to find factorial");
    int num =sc.nextInt();
    int fact =1;
    for(int i = 1; i<=num;i++) {
    	fact = fact*i;
    }
    System.out.println("Factorial of "+num + "is "+fact);
    System.out.println("do you want to find factorial of another number? (y/n)");
    ans = sc.next();
	}while(ans.equals("y"));
	}

}
