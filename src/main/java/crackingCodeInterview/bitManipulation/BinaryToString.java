package crackingCodeInterview.bitManipulation;

/**
 * Given a real number between O and 1 (e.g., 0.72) that is passed in as a double, 
 * print the binary representation. If number the number cannot be represented accurately 
 * in binary with at most 32 characters, print"ERROR'
 */
public class BinaryToString {
    public static void main(String[] args) {
        System.out.println(binToStr(0.55));
    }

    public static String binToStr(double num) {
        if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while (num > 0 || frac != 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() >= 32) {
				return binary.toString();
			}
			if (num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
    }
}
