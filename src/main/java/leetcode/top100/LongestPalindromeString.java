package leetcode.top100;
import java.util.ArrayList;
/**
 * Given a string s, return the longest palindromic substring in s.
 * 
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
 */
public class LongestPalindromeString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2)
            return s;
        int maxLength = 1, start=0;
        int i = 1;
        int lo = 0, hi = 0;
        for (;i < n; i++) {
            lo = i - 1;
            hi = i;
            while(lo >= 0 && hi < n && s.charAt(lo) == s.charAt(hi)) {
                if (hi - lo + 1 > maxLength) {
                    start = lo;
                    maxLength = hi - lo + 1;
                }
                lo -= 1;
                hi += 1;

            }
            lo = i - 1;
            hi = i + 1;
            while(lo >= 0 && hi < n && s.charAt(lo) == s.charAt(hi)) {
                if (hi - lo + 1 > maxLength) {
                    start = lo;
                    maxLength = hi - lo + 1;
                }
                lo -= 1;
                hi += 1;

            }
        }
        return s.substring(start, start + maxLength );
    }
}
