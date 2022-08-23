package hackerrank.weekprep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. 
 * Print the decimal value of each fraction on a new line with  places after the decimal.
 * 
 * Example:
STDIN           Function
-----           --------
6               arr[] size n = 6
-4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]

Sample Output
0.500000
0.333333
0.166667
 */
public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        PlusMinus.plusMinus(arr);

        bufferedReader.close();
    }

    /**
     * 
     *  Compute the ratio of each count
     */
    public static void plusMinus(List<Integer> arr) {
        int posCount = 0, negCount = 0, zeroCount = 0;
        for (Integer item: arr) {
            if (item > 0) {
                posCount += 1;
            } else if (item < 0) {
                negCount += 1;
            } else {
                zeroCount += 1;
            }
        }
        if (arr.size() == 0) {
            System.out.println(0.0);
            System.out.println(0.0);
            System.out.println(0.0);
        } else {
            System.out.println((double)posCount / arr.size());
            System.out.println((double)negCount / arr.size());
            System.out.println((double)zeroCount / arr.size());
        }
    }
}
