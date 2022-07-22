public class RunLengthEncoding {
    static String encode(String input) {
        var s = new StringBuilder();
        for (int i = 0; i < input.length(); i += 1) {
            int count = 1;
            while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count += 1;
                i += 1;
            }
            s.append(input.charAt(i));
            s.append(count);
        }

        return s.toString();
    }

    static String decode(String input) {
        var s = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i += 2) {
            char c = input.charAt(i);
            int count = input.charAt(i + 1) - '0';
            s.append(String.valueOf(c).repeat(count));
        }
        return s.toString();
    }

    public static void  main(String []args) {
        System.out.println(encode("wwwwaaadexxxxxxywww"));
        System.out.println(decode(encode("wwwwaaadexxxxxxywww")));
    }
}
