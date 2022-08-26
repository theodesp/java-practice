package codeSignal.prep;

public class RotateImage {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };
        displayMatrix(new RotateImage().solution(a));
    }

    int[][] solution(int[][] a) {
        var N = a.length;
        // there are N/2 squares
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {

                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
        return a;
    }

    static void displayMatrix(int a[][]) {
        var N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + a[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
