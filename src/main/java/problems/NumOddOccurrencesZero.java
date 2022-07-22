package problems;
/* Given an array of positive integers, return the number of integers that contain an odd number of zeros.
 * 
 * Example: a = [5, 10, 200, 10070, 56]
 * Output: 2 (because 10 has one zero and 10070 has three zeros). The other numbers have an even number of zeroes. 
 * */

public class NumOddOccurrencesZero {

    public static int countNumZeros(int i) {
        var count = 0;
        while (i != 0) {
            var digit = i % 10;
            if (digit == 0) {
                count++;
            }
            i /= 10;
        }
        return count;
    }

    public static int numOddOccurrencesZero(int[] a) {
        var result = 0;
        for (var i: a) { 
            if (countNumZeros(i) % 2 == 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {5, 10, 200, 10070, 56};
        System.out.println(numOddOccurrencesZero(a));
    }
}
