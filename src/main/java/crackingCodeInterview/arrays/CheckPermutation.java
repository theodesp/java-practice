package crackingCodeInterview.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(check("Hello", "Hlloe"));
        System.out.println(check("Hello", "Hllae"));
        System.out.println(check("Hello", "elloH"));
    }

    static boolean check(String a, String b) {
        var histA = countChars(a);
        var histB = countChars(b);
        if (histA.equals(histB)) {
            return true;
        }
        return false;
    }

    static Map<Character, Integer> countChars(String s) {
        var res = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (res.containsKey(c)) {
                res.put(c, res.get(c) + 1);
            } else {
                res.put(c, + 1);
            }
        }
        return res;
    }
}
