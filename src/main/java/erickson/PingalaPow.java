package erickson;

public class PingalaPow {
    public static void main(String[] args) {
        System.out.println(solution(2, 4));
    }

    static long solution(long a, long n) {
        if (n == 1) {
            return a;
        }

        var res = solution(a, n/2);
        if (n % 2== 0) {
            return res * res;
        }
        return res * res * a;
    }
}
