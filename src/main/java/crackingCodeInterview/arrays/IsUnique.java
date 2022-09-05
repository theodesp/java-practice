package crackingCodeInterview.arrays;

import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */
public class IsUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("abcs"));
        System.out.println(isUnique("abvfdra"));
        System.out.println(isUnique("fgmikrmkermkspvskdc"));
    }

    static boolean isUnique(String s) {
        var sorted = s.toCharArray();
        Arrays.sort(sorted);
        for (var i = 1; i < sorted.length; i++) {
            if (sorted[i-1] == sorted[i]){
                return false;
            }
        }
        return true;
    }
}
