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
 * Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. 
 * Determine if the columns are also in ascending alphabetical order, top to bottom. 
 * Return YES if they are or NO if they are not.
 a b c
 a d e
 e f g

 The rows are already in alphabetical order. 
 The columns a a e, b d f and c e g are also in alphabetical order, 
 so the answer would be YES. Only elements within the same row can be rearranged. 
 They cannot be moved to a different row.
 */
public class GridChallenge {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = gridChallenge(grid);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        bufferedReader.close();
    }
    public static String gridChallenge(List<String> grid) {
        var sortedGrid = new ArrayList<Character>();
        var gridLen = grid.size();
        for (var str: grid) {
            var temp = str.toCharArray();
            Arrays.sort(temp);
            for (char ch : temp) {
                sortedGrid.add(ch);
            }
        }
        var sorted = "YES";
        var sortedText = sortedGrid.stream().map(Object::toString).collect(joining(""));
        for (var i = 0; i < sortedText.length() - gridLen; i+=1) {
            if (sortedText.charAt(i) <= sortedText.charAt(i + gridLen)) {
                continue;
            } else {
                sorted = "NO";
            }
        }
        return sorted;
    }
}
