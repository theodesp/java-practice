public class SpiralForm {
    static void printSpiralForm(int[][] matrix) {
        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
        int m = matrix.length, n = matrix[0].length;
        while (k < m && l < n) { //while we do not cross indexes
            // Print the first row from the remaining rows -->
            for (i = l; i < n; ++i) {
                System.out.print(matrix[k][i] + " ");
            }
            k++; // Add one to starting row index

            // Print the last column from the remaining \/
            // columns
            for (i = k; i < m; ++i) {
                System.out.print(matrix[i][n - 1] + " ");
            }
            n--; // Remove one from ending column index
            // Print the last row from the remaining rows */ <--
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(matrix[m - 1][i] + " ");
                }
                m--; // Remove one from ending row index
            }

            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++; // Add one to starting column index
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printSpiralForm(arr);
    }
}
