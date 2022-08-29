package leetcode.top100;
/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.


Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
import java.util.HashMap;

import org.checkerframework.checker.units.qual.s;
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        // System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        // System.out.println(lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    static int lengthOfLongestSubstring(String s) {
        var seen = new HashMap<Character, Integer>();
        var result = 0;
        var start = 0;
        for (var i=0; i<s.length();i+=1) {
            if (seen.containsKey(s.charAt(i))) {
                start = Math.max(start, seen.get(s.charAt(i)) + 1);
            }
            seen.put(s.charAt(i), i);
            result = Math.max(result, i-start + 1);
        }

        return result;
    }
}
