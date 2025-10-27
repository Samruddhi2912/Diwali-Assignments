public class GcdLcm {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int num1 = 36, num2 = 60;
        System.out.println("GCD: " + gcd(num1, num2));
        System.out.println("LCM: " + lcm(num1, num2));
    }
}
