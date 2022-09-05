package crackingCodeInterview.ch2;

public class StringPermutations {
    public static void main(String[] args) {
        permute("Hello");
    }
    static void permute(String s) {
        permutation(s, "");
    }

    static void permutation(String s, String prefix) {
        if (s.length() == 0) {
            System.out.println(prefix);
        }
        for (int i = 0; i < s.length(); i++) {
           var rem = s.substring(0, i) + s.substring(i+1);
           permutation(rem, prefix + s.charAt(i));
        }
    }
}
