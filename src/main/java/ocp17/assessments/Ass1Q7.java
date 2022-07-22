package ocp17.assessments;
import java.util.Arrays;

public class Ass1Q7 {
    public static void main(String[] args) {
        int[] array = {6,9,8};
        System.out.println("B" + Arrays.binarySearch(array,9));// B1
        System.out.println("C" + Arrays.compare(array, new int[] {6, 9, 8})); // C0
        System.out.println("M" + Arrays.mismatch(array, new int[] {6, 9, 8})); // M-1
    }
}
