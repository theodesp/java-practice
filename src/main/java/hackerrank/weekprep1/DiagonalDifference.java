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
 * Given a square matrix, calculate the absolute difference between the sums of
 * its diagonals.
 * 
 * Example
 * 
 * 1 2 3
 * 4 5 6
 * 9 8 9
 * 
 * The left-to-right diagonal 15. The right to left diagonal 17. Their absolute
 * difference is 2
 */
public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        System.out.println(result);

        bufferedReader.close();
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftDiag = 0, rightDiag = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (i == j) {
                    leftDiag += arr.get(i).get(i); 
                }
                if (j == arr.size() - i - 1) {
                    rightDiag += arr.get(i).get(j); 
                }
            }
        }
        return Math.abs(leftDiag - rightDiag);
    }
}
