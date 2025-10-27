
import java.util.Scanner;

public class CodingChallenge{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
  int arr[] = {0,1,3,4,5};
  int n = sc.nextInt();

    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    for (int num : arr) actualSum += num;
    System.err.println(expectedSum - actualSum);

    }
}
