package hackerrank.competition.hackTheInterview4;

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
 * Array-Sum Operation
 */
public class ArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        var initial = IntStream.range(1, n + 1).boxed().collect(toList());
        String line;
        int i = 0;
        var ops = new ArrayList<Integer>();
        while ((line = bufferedReader.readLine()) != null && i < m)
        {
            if (i < m)
            {
                ops.add(Integer.parseInt(line));
                i++;
            }
        }

        arraySumOp(initial, ops);

        bufferedReader.close();
    }

    static void arraySumOp(List<Integer> initial, List<Integer> ops) {
        for (var op: ops) {
            if (initial.contains(op)) {
                var temp = initial.get(0);
                initial.set(0, initial.get(initial.size() - 1));
                initial.set(initial.size() - 1, temp);
            } else {
                initial.set(initial.size() - 1, op);
            }
            System.out.println(initial.stream().reduce(0, Integer::sum));
        }
    }
}
