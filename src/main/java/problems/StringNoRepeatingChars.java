import java.util.HashMap;
import java.util.HashSet;

public class StringNoRepeatingChars {
    static int findLengthNoRepeatingChars(String input) {
        var seen = new HashSet<Character>();
        var maxLegth = 0;
        var length = 0;
        for (var i = 0; i < input.length(); i++) {
            if (seen.contains(input.charAt(i))) { // we have seen this char before
                length += 1;
                if (length > maxLegth) {
                    maxLegth = length;
                }
                length = 1;
            } else { // we have not seen this char before
                seen.add(input.charAt(i));
                length += 1;
            }
        }
        return maxLegth;
    }

    static int longestUniqueSubsttr(String s)
    {

        // Creating a set to store the last positions of occurrence
        HashMap<Character, Integer> seen = new HashMap<>();
        int maximum_length = 0;

        // starting the initial point of window to index 0
        int start = 0;

        for(int end = 0; end < s.length(); end++)
        {
            // Checking if we have already seen the element or not
            if(seen.containsKey(s.charAt(end)))
            {
                // If we have seen the number, move the start pointer
                // to position after the last occurrence
                start = Math.max(start, seen.get(s.charAt(end)) + 1);
            }

            // Updating the last seen value of the character
            seen.put(s.charAt(end), end);
            maximum_length = Math.max(maximum_length, end-start + 1);
        }
        return maximum_length;
    }

    public static void main(String []args) {
        System.out.println(findLengthNoRepeatingChars("geeksforgeeks"));
        System.out.println(longestUniqueSubsttr("geeksforgeeks"));
    }
}
