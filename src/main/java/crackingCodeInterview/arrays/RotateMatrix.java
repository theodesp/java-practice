package crackingCodeInterview.arrays;

import java.util.Arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * 
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. 
 * Can you do this in place?
 */
public class RotateMatrix {
    public static void main(String[] args) {
        var image = new int[][]{
            new int[]{ 1, 2, 3, 4},
            new int[]{ 5, 6, 7, 8},
            new int[]{ 9,10,11,12},
            new int[]{ 13,14,15,16},
        };

        for (var line: rotate(image)) {
            System.out.println(Arrays.toString(line));
        }
    }

    static int [][] rotate(int [][] image) {
        var N = image.length;

        for (var i = 0; i < image.length / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                // Save current element
                var temp = image[i][j];
                // rotate current with bottom left
                image[i][j] = image[N - i - 1][i];
                // rotate bottom left with bottom right
                image[N - i - 1][i] = image[N - i - 1][N - j - 1];
                // rotate bottom right with top right
                image[N - i - 1][N - j - 1] = image[j][N - i - 1];
                // rotate top right with temp
                image[j][N - 1 - i] = temp;
            }
        }
        return image;
    }
}
