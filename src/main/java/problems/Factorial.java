public class Factorial {
    // Write a method that calculates the factorial of a given number.
    int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return factorial(n-1) * n;
        }
    }
    /*
     * int factorial = n;
     * for (int j = n - 1; j > 0; j--) {
     *     factorial = factorial * j;
     * }
     * return factorial;
     */
}
