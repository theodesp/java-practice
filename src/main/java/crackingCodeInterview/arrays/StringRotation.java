package crackingCodeInterview.arrays;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s l and s2, write code to check if s2 is a rotation of sl using only 
 * one call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 */
public class StringRotation {
    public static void main(String[] args) {
        System.out.println(isRotation2("erbottlewat", "waterbottle"));
        System.out.println(isRotation2("terbottlewa", "waterbottle"));
        System.out.println(isRotation2("ewaterbottl", "waterbottle"));
        System.out.println(isRotation2("ewaterbottl", "waterbottle"));
    }

    static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) { return false; }
        for (var i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                if (isSubstring(s1.substring(i), s2.substring(0, s2.length() - i)) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isRotation2(String s1, String s2) {
        if (s1.length() != s2.length()) { return false; }
        var combined = s1+s1;

        return isSubstring(s1, combined) >= 0;
    }

    static int isSubstring(String s1, String s2) {
        return s2.indexOf(s1);
    }
}
