package erickson;

import java.util.Arrays;

public class SubSetSum {
    public static void main(String[] args) {
        var X = new int[]{5,8,10,2,7};
        System.out.println(solution(X, 5, X.length-1));
    }

    static boolean solution(int[] arr, int target, int i) {
        if (target == 0) {
            return true;
        }
        if (target <0 || i == 0) {
            return false;
        }
        var with = solution(arr, target-arr[i], i-1);
        var without = solution(arr, target, i-1);

        return with || without;
    }
}
