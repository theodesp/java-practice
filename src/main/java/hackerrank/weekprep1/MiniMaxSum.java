package hackerrank.weekprep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.*;
import static java.util.Collections.sort;
import static java.util.stream.Collectors.toList;

/**
 * Given five positive integers, find the minimum and maximum values that can be
 * calculated by
 * summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of
 * two space-separated long integers.
 * Sample Input
 * 
 * 1 2 3 4 5
 * Sample Output
 * 
 * 10 14
 */
public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
        sort(arr);
        long longSum = arr.stream().mapToLong(Integer::longValue).sum();
        if (arr.size() > 0) {
            System.out.printf("%d %d", longSum - arr.get(arr.size()-1), longSum - arr.get(0));
        }
    }
}
