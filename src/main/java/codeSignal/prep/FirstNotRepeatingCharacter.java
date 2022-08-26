package codeSignal.prep;

import java.util.HashMap;

public class FirstNotRepeatingCharacter {
    public static void main(String[] args) {
        var s = "abacabad";
        System.out.println(new FirstNotRepeatingCharacter().solution(s));
    }
    char solution(String s) {
        var freq = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            freq.merge(c, 1, (a, b) -> a + b);
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return '_';
    }
}
