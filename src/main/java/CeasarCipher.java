public class CeasarCipher {
    // Ceasar Cipher
    String decode(String code) {
        StringBuilder sb = new StringBuilder();
        var lastCharValue = 'z';
        var alphabetLength = 'z' - 'a' + 1;
        for (char character: code.toCharArray()) {
            var charNoRotation = character + 5;
            var charValue = charNoRotation < lastCharValue ? charNoRotation : charNoRotation - alphabetLength;
           sb.append((char)charValue);
        }
        return sb.toString();
    }
}
