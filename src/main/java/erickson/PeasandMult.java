package erickson;

public class PeasandMult {
    public static void main(String[] args) {
        System.out.println(solution(123, 456));
    }

    static long solution(long a, long b) {
        var result = 0L;
        while (a > 0) {
            if (a % 2 == 1) {
                result += b;
            }
            a /= 2;
            b += b;
        }
        return result;
    }
}
