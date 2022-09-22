package crackingCodeInterview.math;

public class Logic {
    boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags= new boolean[max + 1];
        int count= 0;
        init(flags); // Set all flags to true other than 0 and 1
        int prime= 2;
        while (prime<= Math.sqrt(max)) {
            //* Cross off remaining multiples of prime •1
            cross0ff(flags, prime);
            prime= getNextPrime(flags, prime);
        }
    return flags;
    }
    void cross0ff(boolean[] flags, int prime) {
        for (inti= prime* prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }
    int getNextPrime(boolean[] flags, int prime) {
        int next = prime+1;
        while(next<flags.length && !flags[next]) {
            next = next + 1;
        }
        return next;
    }
}
