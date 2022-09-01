package erickson;

import java.util.Arrays;
import java.util.Collections;

public class LatticeMult {
    public static void main(String[] args) {
        var a = new long[]{1,1,7,2};
        var b = new long[]{1,1,7,2};
        System.out.println(Arrays.toString(solution(a,b)));
    }
    // Fibonacci Multiplication
    static long[] solution(long[] a, long[] b) {
        long hold = 0;
        int n = a.length + b.length - 1;
        var res = new long[n];
        var aTemp = reverse(a);
        var bTemp = reverse(b);
        for (var k = 0; k < n; k +=1) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (j + i == k) {
                        hold += (aTemp[i] * bTemp[j]);
                    }
                }
            }
            res[k] = hold % 10; 
            hold = hold / 10;
        }
        return res;
    }

    public static long[] reverse(long[] x) {

        long[] d = new long[x.length];

        for (int i = 0; i < x.length; i++) {
            d[i] = x[x.length - 1 -i];
        }
        return d;
    }
}
