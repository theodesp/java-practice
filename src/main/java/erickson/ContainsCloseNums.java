package erickson;
import java.util.HashMap;

public class ContainsCloseNums {
    public static void main(String[] args) {
        var X = new int[]{0, 1, 2, 3, 5, 2};
        System.out.println(solution(X, 3));
    }

    static boolean solution(int[] arr, int target) {
        var index = new HashMap<Integer, Integer>();
        for (var i = 0; i < arr.length;i++) {
            if (index.containsKey(arr[i])) {
                if (i - index.get(arr[i]) <= target) {
                    return true;
                }
            }
            index.put(arr[i], i);
        }
        return false;
    }
    
}
