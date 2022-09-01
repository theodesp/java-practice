package codeSignal.prep;

import java.util.HashMap;
import java.util.Map;

public class AreFollowingPatterns {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"cat", "dog", "dog"}, new String[]{"a", "b", "b"}));
    }

    static boolean solution(String[] strings, String[] patterns) {
        var strToPattern = new HashMap<String, String>();
        var patternToString = new HashMap<String, String>();
        for (var i = 0; i < strings.length; i++) {
            var str = strings[i];
            var pattern = patterns[i];
            if (!strToPattern.containsKey(str)) {
                strToPattern.put(str, pattern);
            }
            if (!patternToString.containsKey(pattern)) {
                patternToString.put(pattern, str);
            }
            if (strToPattern.get(str).equals(pattern) || patternToString.get(pattern).equals(str)) {
                return false;
            }
        }
        return true;
    }
    static String convertWithIteration(Map<String, ?> map) {
        StringBuilder mapAsString = new StringBuilder("{");
        for (String key : map.keySet()) {
            mapAsString.append(key + "=" + map.get(key) + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }
}
