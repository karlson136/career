package string;/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.Arrays;

public class String17 {

    /*
        есть матрица NxN. Это пиксели. Повернуть изображение на 90 градусов

        [0, 0, 0, 0, 0]         [4, 3, 2, 1, 0]
        [1, 1, 1, 1, 1]         [4, 3, 2, 1, 0]
        [2, 2, 2, 2, 2]  -- >   [4, 3, 2, 1, 0]
        [3, 3, 3, 3, 3]         [4, 3, 2, 1, 0]
        [4, 4, 4, 4, 4]         [4, 3, 2, 1, 0]

     */
    public static void main(String[] args) {
        print(createImage(3), solution1(createImage(3)));
        print(createImage(4), solution1(createImage(4)));
        print(createImage(5), solution1(createImage(5)));
    }

    public static long[][] solution1(long[][] image) {
        long thirdGlass;
        int dim = image.length;
        int border = dim % 2 == 0 ? dim / 2 : dim / 2 + 1;

        for (int i = 0; i < dim / 2; i++) {
            for (int j = 0; j < border; j++) {
                thirdGlass = image[i][j]; // save top
                image[i][j] = image[dim - j - 1][i]; // left -> top
                image[dim - j - 1][i] = image[dim - i - 1][dim - j - 1]; // bottom -> left
                image[dim - i - 1][dim - j - 1] = image[j][dim - i - 1]; // right -> bottom
                image[j][dim - i - 1] = thirdGlass; // top -> right
            }
        }
        return image;
    }

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