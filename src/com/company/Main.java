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

        if (length <= 1) {
            System.out.println("Невозможно создать матрицу такой длины!");
        } else {
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array.length; col++) {
                    array[row][col] = ran.nextInt(length + length) - length;
                }
            }

            for (int[] row : array) {
                for (int col : row) {
                    System.out.print(col + "\t");
                }
                System.out.print("\n");
            }

            int indexRow = 0;
            int indexCol = 0;

            for (int row = 0; row < length; row++) {
                for (int col = 0; col < length; col++) {
                    if (array[row][col] == 0) {
                        indexRow = row;
                        indexCol = col;
                    } else break;

                    for (int i = 0; i < indexRow; i++) {
                        for (int j = 0; j < indexCol; j++) {
                            array[i][j] = array[i][j + 1];
                        }
                        for (int j = indexCol; j < length - 1; j++) {
                            array[i][j] = array[i][j + 1];


                        }
                       // --length;
                    }
                    for (int i = indexRow; i < length - 1; i++) {
                        for (int j = 0; j < indexCol; j++) {
                            array[i][j] = array[i + 1][j];
                        }
                        for (int j = indexCol; j < array[i].length - 1; j++) {
                            array[i][j] = array[i + 1][j + 1];

                        }
                        //--length;
                    }
                }


            }
            System.out.println();
            for (int[] k : array) {
                for (int col : k) {
                    System.out.print(col + "\t");
                }
                System.out.print("\n");
            }

        }
    }
}

