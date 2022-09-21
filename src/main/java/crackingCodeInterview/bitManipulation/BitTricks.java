package crackingCodeInterview.bitManipulation;

public class BitTricks {
    static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    static int setBit(int num, int i) {
        return num | (1 << i);
    }

    static int clearBit(int num, int i) {
        int mask= ~(1 << i);
        return num & mask;
    }

    static int clearBitsMSBthroughI(int num, int i) {
        int mask= (1 << i) - 1;
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
