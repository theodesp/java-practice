public class ReverseString {
    // Write a method that reverses a string.
    String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i -= 1) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
