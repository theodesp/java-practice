package erickson;

import java.util.Arrays;

public class NQeens {
    public static void main(String[] args) {
        var Q = new int[4];
        PlaceQueens(Q, 0);
    }
    static void PlaceQueens(int[] Q, int r) {
        // We've found a solution. Print it!
        if (r == Q.length) {
            System.out.println(Arrays.toString(Q));
        } else {
            // For each Queen
            for (int j = 0; j < Q.length; j++) {
                 // Flag to check if move is legal
                var legal = true;
                 // Check each other queen
                for (int i = 0; i < r-1; i++) {
                    // Check same line or diagonals
                    if (Q[i] == j || (Q[i] == (j  + r - i)) || (Q[i] == (j  + r + i))) {
                        legal = false;
                    }
                }
                // Found a legal move
                if (legal) {
                    // Place queen j at index r
                    Q[r] = j;
                    PlaceQueens(Q, r+1);
                }
            }
        }

    }
}
