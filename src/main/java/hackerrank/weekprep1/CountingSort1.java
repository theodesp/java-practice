package hackerrank.weekprep1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Another sorting method, the counting sort, does not require comparison.
 * Instead, you create an integer array whose index range covers the entire
 * range of values in your array to sort. Each time a value occurs in the
 * original array, you increment the counter at that index. At the end, run
 * through your counting array, printing the value of each non-zero valued index
 * that number of times.
 * 
 * Example
 * arr = [1,1,3,2,1]
 * 
 * i arr[i] result
 * 0 1 [0, 1, 0, 0]
 * 1 1 [0, 2, 0, 0]
 * 2 3 [0, 2, 0, 1]
 * 3 2 [0, 2, 1, 1]
 * 4 1 [0, 3, 1, 1]
 * 
 * The frequency array is [0, 3,1,1] so the array sorted is [1,1,1,2,3]
 * 
 * For this exercise, always return a frequency array with 100 elements.
 * The example above shows only the first 4 elements, the remainder being zeros.
 */
public class CountingSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = countingSort(arr);
        System.out.println(result);

        bufferedReader.close();
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        var counts = new int[100];
        Arrays.fill(counts, 0);
        for (var item: arr) {
            counts[item]+=1;
        }

        return Arrays.stream(counts)
            .boxed()        
            .collect(Collectors.toList());
    }
}
