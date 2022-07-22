public class EvenFibSum {
    /*
    Write a method that returns the sum of all even Fibonacci numbers.
    Consider all Fibonacci numbers that are less than or equal to n.
     */

    static int evenFibonacciSum(Integer n) {
        int a = 0, b = 1, sum = 0;
        while (a <= n) {
            if (a % 2 == 0) {
                sum += a;
            }
            int t = b;
            b = a + b;
            a = t;
        }
        return sum;
    }
}
