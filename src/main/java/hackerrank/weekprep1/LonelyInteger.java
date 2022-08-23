package hackerrank.weekprep1;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
/**
 * Given an array of integers, where all elements but one occur twice, find the unique element.
 * Example: 
 * a = 
 * The unique element is 4
 */
public class LonelyInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = lonelyinteger(a);

        System.out.println(result);

        bufferedReader.close();

    }

    public static int lonelyinteger(List<Integer> a) {
        var seen = new HashSet<Integer>();
        for (var item: a) {
            if (seen.contains(item)) {
                seen.remove(item);
            } else {
                seen.add(item);
            }
        }
        return seen.iterator().next();
    }
}
