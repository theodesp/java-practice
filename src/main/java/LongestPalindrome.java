public class LongestPalindrome {
    /*
    A palindrome is a word which reads the same backward or forward.
'abcba' is a palindrome.
Write a method that returns the longest palindrome substring of a given string.
     */
    static String findLongestPalindrome(String word) {
        int x = 0, y = word.length() - 1;
        return lps(word, x, y);
    }

    static String lps(String word, int x, int y) {
        // Base Case 1: If there is only 1 character
        if (x == y) {
            return word;
        }
        // Base Case 2: If there are only 2 characters and both are same
        if (word.charAt(x) == word.charAt(y) && (y + 1 == 2)) {
            return word;
        }
        // If the first and last characters match
        if (word.charAt(x) == word.charAt(y)) {
            return lps(word, x + 1, y - 1) + 2;
        }

        // If the first and last characters do not match
        return Math.max(lps(word, x, y - 1), lps(word, x + 1, y));
    }
}
