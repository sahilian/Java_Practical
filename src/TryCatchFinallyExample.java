public class TryCatchFinallyExample {
    public static void main(String[] args) {
        try {
            // Perform some operations that might throw an exception
            int result = divide(10, 0);
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            // Catch the specific exception
            System.out.println("Error: Division by zero");
        } finally {
            // This block is always executed, regardless of whether an exception occurred or not
            System.out.println("Finally block executed");
        }
    }

    public static int divide(int dividend, int divisor) {
        // Perform division
        return dividend / divisor;
    }
}
