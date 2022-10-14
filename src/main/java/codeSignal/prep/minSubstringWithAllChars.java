package codeSignal.prep;

import java.util.*;
import java.util.stream.*;
/**
 * You have two strings, s and t. The string t contains only unique elements. 
 * Find and return the minimum consecutive substring of s that contains all of the elements from t.

It's guaranteed that the answer exists. If there are several answers, return the one which starts from the smallest index.
For s = "adobecodebanc" and t = "abc", the output should be
solution(s, t) = "banc".
 */
public class minSubstringWithAllChars {
    public static void main(String[] args) {
        System.out.println(solution("adobecodebanc", "abc"));
    }

    static String solution(String s, String t) {
        int count[] = new int[26];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']++;
        }
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char charIndexTracker[] = s.substring(i, j).toCharArray();
                int temp[] = new int[26];
                for (int k = 0; k < charIndexTracker.length; k++) {
                    temp[charIndexTracker[k] - 'a']++;
                }
                boolean ok = true;
                for (int k = 0; k < 26; k++) {
                    if (count[k] != 0 && temp[k] < count[k]) {
                        ok = false;
                        break;
                    }
                }
                if (ok && (result == "" || result.length() > j - i))
                    result = s.substring(i, j);
            }
        }
        return result;
    }

    
}
