public class CeasarCipher {
    // Ceasar Cipher
    static String encode(String code) {
        StringBuilder sb = new StringBuilder();
        var lastCharValue = 'z';
        var alphabetLength = 'z' - 'a' + 1;
        for (char character: code.toCharArray()) {
            var charNoRotation = character + 13;
            var charValue = charNoRotation < lastCharValue ? charNoRotation : charNoRotation - alphabetLength;
           sb.append((char)charValue);
        }
        return sb.toString();
    }

    public static void main(String[]args) {
        System.out.println(encode("ATTACKATONCE"));
    }
}
