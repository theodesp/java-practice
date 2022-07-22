public class EvenFibSum {
    /*
    Write a method that returns the sum of all even Fibonacci numbers.
    Consider all Fibonacci numbers that are less than or equal to n.
     */
    static int evenFibonacciSum(Integer n) {
        // Initialize the numbers
        int a = 0, b = 1, sum = 0;
        while (a <= n) {
            if (a % 2 == 0) {
                sum += a;
            }
            // shift b to a and advance b by a
            int t = b;
            b = a + b;
            a = t;
        }
        return sum;
    }
}
