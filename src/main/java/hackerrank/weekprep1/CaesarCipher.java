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
 * Julius Caesar protected his confidential information by encrypting it using a
 * cipher.
 * Caesar's cipher shifts each letter by a number of letters.
 * If the shift takes you past the end of the alphabet, just rotate back to the
 * front of the
 * alphabet.
 * In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
 * 
 * Original alphabet: abcdefghijklmnopqrstuvwxyz
 * Alphabet rotated +3: defghijklmnopqrstuvwxyzabc
 */
public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = caesarCipher(s, k);
        System.out.println(result);

        bufferedReader.close();
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        var result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            boolean upperCase = Character.isUpperCase(temp);
            if (Character.isLetter(temp)) {
                temp += k%26;
                if (!Character.isLetter(temp) || (upperCase && !Character.isUpperCase(temp))) {
                    temp -= 26;
                }
            }
            result.append(temp);
        }
        return result.toString();
    }
}
