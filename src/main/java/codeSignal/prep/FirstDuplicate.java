package codeSignal.prep;

import java.util.HashMap;

public class FirstDuplicate {
    public static void main(String[] args) {
        var a = new int[]{2, 1, 3, 5, 3, 2};
        System.out.println(new FirstDuplicate().solution(a));
    }
    int solution(int[] a) {
        var seen = new HashMap<Integer, Integer>();
        for (var i = 0; i < a.length; i++) {
            if (seen.containsKey(a[i])) {
                return a[i];
            } else {
                seen.put(a[i], i);
            }
        }
        return -1;
    }
}
