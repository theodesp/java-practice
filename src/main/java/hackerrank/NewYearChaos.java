package hackerrank;

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
 * It is New Year's Day and people are in line for the Wonderland rollercoaster
 * ride.
 * Each person wears a sticker indicating their initial position in the queue
 * from 1 to n.
 * Any person can bribe the person directly in front of them to swap positions,
 * but they still wear their original sticker. One person can bribe at most two
 * others.
 * 
 * Determine the minimum number of bribes that took place to get to a given
 * queue order.
 * Print the number of bribes, or, if anyone has bribed more than two people,
 * print Too chaotic.
 * 
 * q = [1,2,3,4,5,6,7,8]
 * If person 5 bribes person 4, the queue will look like this: 1,2,3,5,4,6,7,8.
 * Only bribe is required. Print 1.
 * 
 * q=[4,1,2,3]
 * Person 4 had to bribe 3 people to get to the current position. Print Too
 * chaotic.
 */
public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        int swaps = 0;
        int i = q.size()-2;
        while ( i >= 0 ) {
            int increase = q.get(i) - (i+1);
            if ( increase > 2 ) break;
            if ( increase > 0 ) swaps += increase;
            if ( q.get(i) > q.get(i+1) ) {
                if ( increase <= 0 ) swaps++;
                q.set(i,q.get(i+1));
            }
            i--;
        }
        System.out.println( i > -1 ? "Too chaotic" : swaps );
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
