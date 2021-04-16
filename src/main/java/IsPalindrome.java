public class IsPalindrome {
    // Write a method that detects if a string is a palindrome.
    boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i += 1) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
