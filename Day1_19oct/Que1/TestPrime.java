	import java.util.Scanner;
	
		
public class TestPrime {

public static void main(String[] args) {
		
			
	
	CheckPrime prime = new CheckPrime();
	  Scanner sc = new Scanner(System.in);
	  String ans;
	do {    
	  System.out.println("Enter number");
	  int num =sc.nextInt();
	  boolean status = prime.checkPrime(num);
	  if(status) {
		  System.out.println(num +" is a prime number");
	  }
	  else {
		  System.out.println(num +" is not a prime number");
	  }
	  System.out.println("Do you want to check number is prime or not (y/n)");
	  ans = sc.next();

		}while(ans.equals("y"));
	}


		private static boolean checkPrime(int num) {
			// TODO Auto-generated method stub
			return false;
		}
	}

