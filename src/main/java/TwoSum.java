import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    // Write a method that checks if there is at least on pair
    // of numbers which sum equals target.
    Boolean sumsToTarget(int[] arr, int target) {
//        for (int i = 0; i < arr.length; i += 1){
//            for (int j = i+1; j < arr.length; j += 1){
//                if (arr[i] + arr[j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
        Set<Integer> s = new HashSet<>();
        for (int j : arr) {
            if (s.contains(target - j)) {
                return true;
            }
            s.add(j);
        }
        return false;
    }
}
