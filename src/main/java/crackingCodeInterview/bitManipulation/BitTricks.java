package crackingCodeInterview.bitManipulation;

public class BitTricks {
    static boolean getBit(int num, int i) {
        // Take ith bit of number and check if it is set
        return ((num & (1 << i)) != 0);
    }

    static int setBit(int num, int i) {
        // use binary OR operator to raise ith bit of number
        return num | (1 << i);
    }
    /**
     * This method operates in almost the reverseof setBit. First, 
     * wecreatea numberlike 11101111 bycreating the reverse of it (00010000) and negating it. 
     * Then, we perform an AND with num. 
     * This will clear the ith bit and leave the remainder unchanged.
     */
    static int clearBit(int num, int i) {
        int mask= ~(1 << i);
        return num & mask;
    }

    static int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    static int clearBitsithrough0(int num, int i) {
        int mask= (-1 << (i + 1));
        return num & mask;
    }

    static int updateBit(int num, int i, boolean bitlsl) {
        int value= bitlsl ? 1: 0;
        int mask= ~(l << i);
        return (num & mask) | (value<< i);
    }
}
