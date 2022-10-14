package codeSignal.prep;
import java.util.*;

/**
 * You have an unsorted array arr of non-negative integers and a number s. 
 * Find a longest contiguous subarray in arr that has a sum equal to s. 
 * Return two integers that represent its inclusive bounds. 
 * If there are several possible answers, return the one with the smallest left bound. 
 * If there are no answers, return [-1].
 * 
 * For s = 12 and arr = [1, 2, 3, 7, 5], the output should be
solution(s, arr) = [2, 4].

The sum of elements from the 2nd position to the 4th position (1-based) is equal to 12: 2 + 3 + 7.

Your answer should be 1-based, meaning that the first position of the array is 1 instead of 0.
 */
public class FindLongestSubArraySum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(15, new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 6, 7, 8, 9, 10})));
    }
    static int[] solution(int s, int[] arr) {
        int sum = 0;
        int start = 0;
        int[] res = new int[] {-1};
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // We exceeded sum
            while (start < i && sum > s) {
                // update sum by sliding the starting window one position to the right
                sum -= arr[start++];
            }
            // If we reach the sum and the new gap is either size 1 or less than the previous gap
            if (sum == s && (res.length == 1 || res[1] - res[0] < i - start)) {
                // update new gap
                res = new int[] {start + 1, i + 1};
            }
        }
        return res;
    }
}
