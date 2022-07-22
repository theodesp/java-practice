public class GCD {
    /*
     * Write a method that returns the Greatest Common Divisor of p and q.
     * https://www.baeldung.com/java-greatest-common-divisor
     */
    int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(p, q % p);
    }
}
