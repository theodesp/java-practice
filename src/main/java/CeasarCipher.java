public class CeasarCipher {
    // Ceasar Cipher
    String decode(String code) {
        StringBuilder sb = new StringBuilder();
        int lastCharValue = 'z';
        int alphabetLength = 'z' - 'a' + 1;
        for (char character: code.toCharArray()) {
            int charNoRotation = character + 5;
            int charValue = charNoRotation < lastCharValue ? charNoRotation : charNoRotation - alphabetLength;
           sb.append((char)charValue);
        }
        return sb.toString();
    }
}
