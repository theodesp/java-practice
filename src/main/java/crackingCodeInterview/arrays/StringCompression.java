package crackingCodeInterview.arrays;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed"string would not become smaller than the original string, your
 * method shouId return the original string. You can assume the string has only
 * uppercase and lowercase letters (a - z).
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(encode("aabcccccaaa"));
        System.out.println(encode("hfqjedfffkkqjffmvvvvxzaaqqq"));

    }

    static String encode(String s) {
        // stores output string
        var encoding = new StringBuilder();

        // base case
        if (s == null) {
            return encoding.toString();
        }

        int count;

        for (int i = 0; i < s.length(); i++) {
            // count occurrences of character at index `i`
            count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }

            // append current character and its count to the result
            encoding.append(String.valueOf(count) + s.charAt(i));
        }

        return encoding.toString();
    }
}
