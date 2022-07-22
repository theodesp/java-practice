package problems;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import net.agkn.hll.HLL;

public class HllExample {
    public static void main(String[] args) {
        final int seed = 123456;
        HashFunction hash = Hashing.murmur3_128();
        Hasher hc = hash.newHasher();
        hc.putLong(1L/*value to hash*/);

        final long hashedValue = hc.hash().asLong();

        final HLL hll = new HLL(13/*log2m*/, 5/*registerWidth*/);
        hll.addRaw(hashedValue);
        System.out.println(hll.cardinality());
    }
}