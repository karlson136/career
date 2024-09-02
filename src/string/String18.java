package string;/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class String18 {

    /*
        есть матрица NxN. Если элемент равен 0, то обнулись столбец и строку

        [0, 0, 0, 0, 0]         [4, 3, 2, 1, 0]
        [1, 1, 1, 1, 1]         [4, 3, 2, 1, 0]
        [2, 2, 2, 2, 2]  -- >   [4, 3, 2, 1, 0]
        [3, 3, 3, 3, 3]         [4, 3, 2, 1, 0]
        [4, 4, 4, 4, 4]         [4, 3, 2, 1, 0]

     */
    public static void main(String[] args) {
        long[][] original = generateMatrix(5);
        print(original, solution1(cloneMatrix(original)));
    }

    public static long[][] solution1(long[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    public static long[][] generateMatrix(int dim) {
        long[][] image = new long[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                image[i][j] = new Random().nextInt(0, 5);
            }
        }
        return image;
    }

    public static long[][] cloneMatrix(long[][] matrix) {
        long[][] clone = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            clone[i] = matrix[i].clone();
        }
        return clone;
    }

    public static void print(long[][] originalImage, long[][] rotatedImage) {
        for (int i = 0; i < rotatedImage.length; i++) {
            System.out.print(Arrays.toString(originalImage[i]));
            System.out.print("   ");
            System.out.println(Arrays.toString(rotatedImage[i]));
        }
        System.out.println();
    }
}