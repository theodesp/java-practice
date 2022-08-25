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
 * We define super digit of an integer using the following rules:
 * 
 * Given an integer, we need to find the super digit of the integer.
 * 
 * If has only 1 digit, then its super digit is x.
 * Otherwise, the super digit of x is equal to the super digit of the sum of the
 * digits of x.
 * For example, the super digit of 9875 will be calculated as:
 * 
 * super_digit(9875) 9+8+7+5 = 29
 * super_digit(29) 2 + 9 = 11
 * super_digit(11) 1 + 1 = 2
 * super_digit(2) = 2
 */
public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = superDigit(n, k);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }

    public static int superDigit(String n, int k) {
        var sb = new StringBuilder("");
        for (int i = 0; i < k; i++) {
            sb.append(n);
        }
        var current = sb.toString();
        while(current.length() > 1) {
            var sum = 0;
            for (char c : current.toCharArray()) {
                sum += (c - '0');
            }
            current = String.valueOf(sum);
        }
         
        return Integer.parseInt(current);
    }
}
