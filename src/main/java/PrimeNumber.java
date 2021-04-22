public class PrimeNumber {
    // A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
    // Write a method that checks if a number is a prime number.
    boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i += 1) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
