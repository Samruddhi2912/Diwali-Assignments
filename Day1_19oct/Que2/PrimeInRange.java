import java.util.Scanner;

public class PrimeInRange {
	int num;
	public static boolean isPrime(int num) {
		if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    
	}

	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  String ans = null;
		do {    
		  System.out.println("Enter numbers first number");
		  int num =sc.nextInt();
		  System.out.println("Enter numbers second number");
		  int num1 =sc.nextInt();
		  for(int j=num; j<=num1; j++){
		  if(isPrime(num))
		  {System.out.println(num);
			  num++;}
		  System.out.println("Do you want to check another range (y/n)");
		  ans = sc.next();
		  }
			}while(ans.equals("y"));
		}
		
		}


