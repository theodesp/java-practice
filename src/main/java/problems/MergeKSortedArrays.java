import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    /*
    Create a min Heap and insert the first element of all k arrays.
Run a loop until the size of MinHeap is greater than zero.
Remove the top element of the MinHeap and print the element.
Now insert the next element from the same array in which the removed element belonged.
If the array doesn’t have any more elements, then replace root with infinite.After replacing the root, heapify the tree.
     */
    public static int[] mergeKArrays(int[][] arr, int a, int k)
    {
        int c = 0;
        int[] output = new int[a*k];
        // traverse the matrix
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < k; j++)
                output[c++] = arr[i][j];
        }

        // sort the array
        Arrays.sort(output);
        return output;
    }
    public static void main(String[] args)
    {
        int[][] arr = { { 2, 6, 12, 34 },
                { 1, 9, 20, 1000 },
                { 23, 34, 90, 2000 } };
        int k = 4;
        int n = 3;

        mergeKArrays(arr, n, k);

        System.out.println(Arrays.toString( mergeKArrays(arr, n, k)));
    }
}
