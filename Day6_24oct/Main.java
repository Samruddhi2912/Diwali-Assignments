package study;

// Demonstration in main method
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("10 + 5 = " + Calculator.calculate(10, 5, "+"));
            System.out.println("10 - 5 = " + Calculator.calculate(10, 5, "-"));
            System.out.println("10 * 5 = " + Calculator.calculate(10, 5, "*"));
            System.out.println("10 / 5 = " + Calculator.calculate(10, 5, "/"));
            System.out.println("10 % 5 = " + Calculator.calculate(10, 5, "%"));
            // Example of invalid operator
            System.out.println("10 ^ 5 = " + Calculator.calculate(10, 5, "^"));
        } catch (WrongOperatorException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Math Error: " + e.getMessage());
        }
    }
}
