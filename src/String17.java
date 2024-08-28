/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.Arrays;

public class String17 {

    // есть матрица NxN. Это пиксели. Повернуть изображение на 90 градусов

    /*

        [0, 0, 0, 0, 0]         [4, 3, 2, 1, 0]
        [1, 1, 1, 1, 1]         [4, 3, 2, 1, 0]
        [2, 2, 2, 2, 2]  -- >   [4, 3, 2, 1, 0]
        [3, 3, 3, 3, 3]         [4, 3, 2, 1, 0]
        [4, 4, 4, 4, 4]         [4, 3, 2, 1, 0]

     */
    public static void main(String[] args) {
//        print(createImage(3), solution1(createImage(3)));
//        print(createImage(4), solution1(createImage(4)));
        print(createImage(5), solution1(createImage(5)));
    }

    public static long[][] solution1(long[][] image) {
        long thirdGlass;
        int dim = image.length;
        for (int i = 0; i < dim / 2; i++) {
            for (int j = 0; j < dim / 2; j++) {
                thirdGlass = image[i][j];
                image[i][j] = image[dim - i - 1][j];
                image[dim - i - 1][j] = image[dim - i - 1][dim - j - 1];
                image[dim - i - 1][dim - j - 1] = image[i][dim - j - 1];
                image[i][dim - j - 1] = thirdGlass;
            }
        }


        return image;
    }

    /*
    [0, 1, 2, 3, 4]
    [5, 6, 7, 8, 9]
    [0, 1, 2, 3, 4]
    [5, 6, 7, 8, 9]
    [0, 1, 2, 3, 4]
     */

    public static long[][] createImage(int dim) {
        long[][] image = new long[dim][dim];
        int counter = 0;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                image[i][j] = counter;
                counter++;
                counter %= 10;
            }
        }
        return image;
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