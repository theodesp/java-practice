package crackingCodeInterview.arrays;

/**
 * There are three types of edits that can be performed on strings: insert a
 * character, remove a character, or replace a character. Given two strings,
 * write a function to check if they are one edit (or zero edits) away.
 * 
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class OneAway {
    public static void main(String[] args) {
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bake"));
        System.out.println(isOneAway("pale", "palezz"));
    }

    static boolean isOneAway(String s1, String s2) {
        // true if strings are same
        if (s1.equals(s2)) {
            return true;
        }
        if (Math.abs(s1.length() - s2.length()) > 1)
            return false;
        int i = 0, j = 0;
        int count = 0;
        while (i < s1.length() && j < s2.length()) {

            // If current characters don't match
            if (s1.charAt(i) != s2.charAt(j)) {
                if (count == 1)
                    return false;

                // If length of one string is
                // more, then only possible edit
                // is to remove a character
                if (s1.length() > s2.length())
                    i++;
                else if (s1.length() < s2.length())
                    j++;
                else // If lengths of both strings
                     // is same
                {
                    i++;
                    j++;
                }

                // Increment count of edits
                count++;
            } else {
                i++;
                j++;
            }
        }

        // If last character is extra
        // in any string
        if (i < s1.length() || j < s2.length())
            count++;

        return count == 1;
    }
}
