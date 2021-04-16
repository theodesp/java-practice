public class LinearSearch {
    // Write a method that returns the index of the first occurrence of given integer in a list.
    // If the number does not exist return -1.
    public int search(int n, int[] list) {
        for (int i = 0; i < list.length; i += 1) {
            if (list[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
