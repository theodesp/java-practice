package ocp17.Ch4;

public class MultiDimensional {
    public static void main(String[] args) {
        int[][] vars1;
        int vars2[][];
        int[] vars3[];
        int[] vars4[], space[][]; // a 2D AND a 3D array

        String[][] rectangle = new String[3][2];
        int[][] differentSizes = { { 1, 4 }, { 3 }, { 9, 8, 7 } };

        int[][] args = new int[4][];
        args[0] = new int[5];
        args[1] = new int[3];

        var twoD = new int[3][2];
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++)
                System.out.print(twoD[i][j] + " "); // print element
            System.out.println(); // time for a new row
        }

        for (int[] inner : twoD) {
            for (int num : inner)
                System.out.print(num + " ");
            System.out.println();
        }

    }
}
