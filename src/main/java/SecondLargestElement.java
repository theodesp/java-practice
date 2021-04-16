import java.util.Arrays;

public class SecondLargestElement {
    // Find the second largest number in an integer array.
    // You can assume a minimum array length of two.
    int find(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    // https://www.geeksforgeeks.org/find-second-largest-element-array/
    /*
    int max = Integer.MIN_VALUE;
int secondMax = Integer.MIN_VALUE;

for (int i = 0; i < arr.length; i++) {
  if (arr[i] > max) {
    secondMax = max;
    max = arr[i];
  }

  if (arr[i] < max && arr[i] > secondMax) {
    secondMax = arr[i];
  }
}
return secondMax;
     */
}
