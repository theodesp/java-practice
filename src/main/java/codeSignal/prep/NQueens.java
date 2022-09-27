package codeSignal.prep;

import java.util.*;

/*
 * In chess, queens can move any number of squares vertically, horizontally, or diagonally. 
 * The n-queens puzzle is the problem of placing n queens on an n × n chessboard so that no 
 * two queens can attack each other.

Given an integer n, print all possible distinct solutions to the n-queens puzzle. 
Each solution contains distinct board configurations of the placement of the n queens, 
where the solutions are arrays that contain permutations of [1, 2, 3, .. n]. 
The number in the ith position of the results array indicates that the ith column queen 
is placed in the row with that number. In your solution, the board configurations should 
be returned in lexicographical order.

For n = 1, the output should be
solution(n) = [[1]];

For n = 4, the output should be

  solution(n) = [[2, 4, 1, 3],
                [3, 1, 4, 2]]
 */

 
public class NQueens {

    public static void main(String[] args) {
        for (var row: solution(1)) {
            System.out.println(Arrays.toString(row));
        }
        for (var row: solution(4)) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    static int[][] solution(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solveNQueensUtil(board, n, 0, ans);
        int[][] res = ans.stream().map(u->u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
        return res;
    }

    static void solveNQueensUtil(boolean[][] board, int n, int row,  List<List<Integer>> result){
        if (row == n){
            List<Integer> ans = new ArrayList<>();
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if (board[i][j]){
                        ans.add(j+1);
                    }
                }
            }
            result.add(ans);
            return;
        }
        
        for (int i=0; i<n; i++){
            if (isSafe(board, row, i ,n)){
                // make selection: place the Q
                board[row][i]=true;
                // traverse to the next row
                solveNQueensUtil(board, n, row+1, result);
                // withdraw the selection
                board[row][i]=false;
            } 
        }
    }
    static boolean isSafe(boolean[][] board, int row, int col, int n){
        //col
        for (int i=row-1;i>=0;i--){
            if (board[i][col]) return false;
        }
        //left-dia
        for (int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if (board[i][j]) return false;
        }
        //right-dia
        for (int i=row-1,j=col+1; i>=0 && j<n; i--,j++){
            if (board[i][j]) return false;
        }
        return true;
    }
}
