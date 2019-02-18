package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] array;
        int length;
        System.out.print("Введите размерность матрицы: ");
        Scanner input = new Scanner(System.in);
        length = input.nextInt();
        array = new int[length][length];
        Random ran = new Random();
        String s = null, s1 = null;
        if (length <= 1) {
            System.out.println("Невозможно создать матрицу такой длины!");
        } else {
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array.length; col++) {
                    array[row][col] = ran.nextInt(length + length) - length;
                }
            }
        }
        for (int[] row : array) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.print("\n");
        }

        int n, countMax = 0, countMin = 0;
        int maxRow = 0, minRow = 0;
        int max = 0, min = 0;
        int indexRow = 0, index1Row = 0;
        int index, index1 = 0;
        //int[] c = new int[max + 1];

        for (int i = 0; i < length; i++) {
            for (n = 0; n < length - 1; n++) {
                if (array[i][n] < array[i][n + 1]) {
                    countMax++;
                    if (countMax > maxRow) {
                        maxRow = countMax;
                        indexRow = n + 1; //запоминаем индекс последнего возрастающего элемента

                    }

                } else {
                    countMax = 0;

                }
                if (array[i][n] > array[i][n + 1]) {
                    countMin++;
                    if (countMin > minRow) {
                        minRow = countMin;
                        index1Row = n + 1; //запоминаем индекс последнего убывающего элемента
                    }
                } else {
                    countMin = 0;
                }
            }
            if (maxRow > max) {
                max = maxRow;
                index = indexRow;
                int[] c = new int[max + 1];
                int l = 0;
                for (int col = index - max; col < index + 1; col++) {
                    c[l++] = array[i][col];
                }
                s = Arrays.toString(c);
            }
           /* if (minRow > min) {
                min = minRow;
                index1 = index1Row;

                int[] d = new int[min + 1];
                int l1 = 0;
                for (int col = index1 - min; col < index1 + 1; col++) {
                    d[l1++] = array[i][col];
                }
                s1 = Arrays.toString(d);
            }*/
        }

        System.out.print("Максимальная последовательность возрастающих чисел:");
        System.out.println(s + " " + (max + 1));
        /*System.out.print("Максимальная последовательность убывающих чисел:");
        System.out.println(s1 + " " + (min + 1));*/

    }
}
