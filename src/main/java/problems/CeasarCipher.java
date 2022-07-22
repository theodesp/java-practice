public class CeasarCipher {
    /*
     * CeasarCipher: Each letter of a given text is replaced by a letter with a fixed number of positions down the alphabet.
     */
    static String encode(String code) {
        StringBuilder sb = new StringBuilder();
        var lastCharValue = 'z';
        var alphabetLength = 'z' - 'a' + 1;
        for (char character: code.toCharArray()) {
            // Rotate numbers by +13 steps taking care of overlap
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
