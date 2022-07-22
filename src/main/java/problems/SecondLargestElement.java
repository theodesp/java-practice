import java.util.Arrays;

public class SecondLargestElement {
    // Find the second largest number in an integer array.
    // You can assume a minimum array length of two.
//    int find(int[] arr) {
//        Arrays.sort(arr);
//        return arr[arr.length - 2];
//    }

    // https://www.geeksforgeeks.org/find-second-largest-element-array/
    int find(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > max) {// found a new max. Update max and second max
                secondMax = max;
                max = j;
            }

            if (j < max && j > secondMax) {
                secondMax = j;
            }
        }
        return secondMax;
    }

}
