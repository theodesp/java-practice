package ocp17.Ch4;

import java.util.*; // import whole package including Arrays 
import java.util.Arrays; // import just Arrays

public class Comparing {
    public static void main(String[] args) {
        System.out.println(Arrays.compare(new int[] {1}, new int[] {2})); // -1
        System.out.println(Arrays.compare(new int[] {1}, new int[] {1})); // 0
        System.out.println(Arrays.compare(new int[] {2}, new int[] {1})); // 1
        System.out.println(Arrays.compare(new int[] {2}, new int[] {1})); // 1
        System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"A"})); // 1 Uppercase is smaller than lowercase.
        System.out.println(Arrays.compare(new int[] {1}, new String[] {"a"})); // DOES NOT COMPILE

        System.out.println(Arrays.mismatch(new int[] {1}, new int[] {1})); // -1
        System.out.println(Arrays.mismatch(new String[] {"a"},new String[] {"A"})); // 0
        System.out.println(Arrays.mismatch(new int[] {1, 2}, new int[] {1})); // 1 they differ at the first index of the first array
    }
}
