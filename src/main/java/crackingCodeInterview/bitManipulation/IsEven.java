package crackingCodeInterview.bitManipulation;

public class IsEven {
    public static boolean isPowerOfTwo(int n) {
        return n != 0 && ((n & (n - 1)) == 0);
    }
}
