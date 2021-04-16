public class SumMulThreeAndFive {
    // Given a number n, write a method that sums all multiples of three and five up to n (inclusive).
    int sumMul3and5(int n) {
        int sum = 0;
        for (int i = 0; i < n ; i += 1) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
