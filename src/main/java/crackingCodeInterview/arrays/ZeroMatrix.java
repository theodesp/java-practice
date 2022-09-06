package crackingCodeInterview.arrays;

import java.util.*;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column are set to 0.
 * https://www.geeksforgeeks.org/a-boolean-matrix-question/
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        var image = new int[][]{
            new int[]{ 1, 2, 3, 4},
            new int[]{ 5, 0, 7, 8},
            new int[]{ 9,10,11,12},
            new int[]{ 13,14,15,16},
        };

        for (var line: zero(image)) {
            System.out.println(Arrays.toString(line));
        }
    }
    static int [][] zero(int [][] matrix) {
        var columns = new HashMap<Integer, Boolean>();
        for (var i=0;i<matrix.length;i++) {
            var flag = false;
            for (var j=0;j<matrix[i].length;j++) {
                if (matrix[i][j] == 0) {
                    flag=true;
                    columns.put(j, true);
                }
            }
            if (flag == true) {
                for (var j=0;j<matrix[i].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (var j: columns.keySet()) {
            for (var i=0; i<matrix.length;i++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }
}
