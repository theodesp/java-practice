package codeSignal.prep;

import java.util.*;
/**
 * Given a sorted array of integers arr and an integer num, 
 * find all possible unique subsets of arr that add up to num. 
 * Both the array of subsets and the subsets themselves should be sorted in lexicographical order.

Example

For arr = [1, 2, 3, 4, 5] and num = 5, the output should be
solution(arr, num) = [[1, 4], [2, 3], [5]].
 */
public class SumSubsets {
    public static void main(String[] args) {
        for (var row: solution(new int[]{1, 2, 2, 3, 4, 5}, 5)) {
            System.out.println(Arrays.toString(row));
        }

    }
    static int[][] solution(int[] arr, int num) {
        var set = new LinkedHashSet<String>();
    
        DFS(arr, num, 0, set, "");
    
        var output = new int[set.size()][];
        var j = 0;
    
        for (String s : set) {
            String[] strArr = s.split(",");
            var intArr = new int[strArr.length - 1];
    
            for (int i = 1; i < strArr.length; i++) {
                intArr[i-1] = Integer.parseInt(strArr[i]);
            }
            output[j] = intArr;
            j++;
        }
    
        return output;
    }
    
    static void DFS(int[] arr, int num, int index, Set<String> set, String path) {
        if (num == 0) {
            set.add(path);
            return;
        }
    
        for (int i = index; i < arr.length; i++) {
            if (num - arr[i] >= 0) {
                DFS(arr, num - arr[i], i + 1, set, path + "," + arr[i]);
            }
        }
    } 
}
