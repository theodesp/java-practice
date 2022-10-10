package codeSignal.prep;
import java.util.*;
/*
 * You have two integer arrays, a and b, and an integer target value v. 
 * Determine whether there is a pair of numbers, where one number is 
 * taken from a and the other from b, that can be added together to get a sum of v. 
 * Return true if such a pair exists, otherwise return false.

Example

For a = [1, 2, 3], b = [10, 20, 30, 40], and v = 42, the output should be
solution(a, b, v) = true.

 */
public class SumOfTwo {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, new int[]{10, 20, 30, 40}, 42));
    }

    static boolean solution(int[] a, int[] b, int v) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            map.put(v-a[i], a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if(map.containsKey(b[i])) {
                return true;
            }
        }
        return false;
    }
    
}
