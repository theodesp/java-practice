package codeSignal.prep;

import java.util.ArrayList;
import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] a = {
                { '.', '.', '.', '1', '4', '.', '.', '2', '.' },
                { '.', '.', '6', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '1', '.', '.', '.', '.', '.', '.' },
                { '.', '6', '7', '.', '.', '.', '.', '.', '9' },
                { '.', '.', '.', '.', '.', '.', '8', '1', '.' },
                { '.', '3', '.', '.', '.', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '7', '.', '.', '.' },
                { '.', '.', '.', '5', '.', '.', '.', '7', '.' },
        };
        System.out.println(new ValidSudoku().solution(a));
    }

    boolean solution(char[][] a) {
        for (var row : a) {
            if (!isValid(row)) {
                return false;
            }
        }
        for (int i = 0; i < a.length; i++) {
            var col = getColumn(a, i);
            if (!isValid(col)) {
                return false;
            }
        }

        for (var i = 0; i < a.length - 2; i+=3) {
            for (var j = 0; j < a.length - 2; j+=3) {
                var col = new ArrayList<Character>();
                for (var item: Arrays.copyOfRange(a[i], j, j+3)) {
                    col.add(item);
                }
                for (var item: Arrays.copyOfRange(a[i+1], j, j+3)) {
                    col.add(item);
                }
                for (var item: Arrays.copyOfRange(a[i+2], j, j+3)) {
                    col.add(item);
                }
                char[] array = new char[col.size()];
                for(int k = 0; k < col.size(); k++) {
                    array[k] = col.get(k);
                }
                if (!isValid(array)) {
                    return false;
                }
            }
        }

        return true;
    }

    char[] getColumn(char[][] matrix, int index) {
        char[] column = new char[matrix[0].length];
        for (int i = 0; i < column.length; i++) {
            column[i] = matrix[i][index];
        }
        return column;
    }

    boolean isValid(char[] a) {
        var uniques = new HashSet<Character>();
        for (var c : a) {
            if (Character.isDigit(c)) {
                if (uniques.contains(c)) {
                    return false;
                }
                uniques.add(c);
            }
        }
        return true;
    }

    static void displayMatrix(char a[][]) {
        var N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + a[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
