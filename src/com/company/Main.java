package com.company;


public class Main {

    public static void main(String[] args) {
        int countRow = 0;
        int countCol = 0;
        int count = 0;
        int count1 = 0;
        int n = 5;
        int m = 5;
        int nrez, mrez, i, j, summ, flag;
        int[] flag_str = new int[n];
        int[] flag_stl = new int[m];
        nrez = n;
        mrez = m;
        int[][] array = {{1, 0, 2, 4, 0},
                {1, 0, 3, 4, 0},
                {0, 0, 0, 0, 0},
                {3, 0, 5, 6, 0},
                {0, 0, 0, 0, 0}};
        System.out.println("Исходная матрица: ");
        for (int[] row : array) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.print("\n");
        }
        for (int row = 0; row < n; row++) {   //считаем количество строк, заполненных нулями
            countRow = 0;
            for (int col = 0; col < m; col++) {
                if (array[row][col] == 0) {
                    countRow++;
                }
            }
            if (countRow == n) {
                count++;
            }
        }

        for (int row = 0; row < n; row++) {   //считаем количество солбцов, заполненных нулями
            countCol = 0;
            for (int col = 0; col < m; col++) {
                if (array[col][row] == 0) {
                    countCol++;
                }
            }
            if (countCol == m) {
                count1++;
            }
        }

        if (count == 0 & count1 == 0) {
            System.out.println("В матрице отсутвуют строки и столбцы, заполненные нулями!");

        } else if (count == n & count1 == m) {
            System.out.println("Уплотнить матрицу невозможно, так как она состоит лишь из нулей!");

        } else {
            for (i = 0; i < n; i++) { //вычисляем на сколько строк уплотнится матрица и ищем строки, заполненные нулями
                summ = 0;
                for (j = 0; j < m; j++) {
                    summ += array[i][j];

                }
                if (summ == 0) {
                    nrez--;
                    flag_str[i] = 1;
                } else flag_str[i] = 0;
            }
            int[][] temp = new int[nrez][nrez]; // создаем временную матрицу
            for (i = 0; i < nrez; i++) {
                temp[i] = new int[m]; // задаем количество элементов в каждой строке
            }
            // удаляем из исходной матрицы строки, заполненные нулями
            flag = 0;
            for (i = 0; i < n; i++) {
                if (flag_str[i] == 0) { //если элемент массива равен нулю,
                    for (j = 0; j < m; j++) {
                        temp[i - flag][j] = array[i][j];//то из исходной матрицы переносим все элементы строки в новую матрицу
                    }
                } else flag++;
            }

            System.out.println("После уплотнения");
            for (i = 0; i < nrez; i++) {
                for (j = 0; j < m; j++) {
                    System.out.print(temp[i][j] + "\t");
                }
                System.out.print("\n");
            }

            for (j = 0; j < m; j++) { //вычисляем на сколько столбцов уплотнится матрица и ищем столбцы, заполненные нулями
                summ = 0;
                for (i = 0; i < nrez; i++) {
                    summ += array[i][j];

                }
                if (summ == 0) {
                    mrez--;
                    flag_stl[j] = 1;
                } else flag_stl[j] = 0;
            }
            int[][] rez = new int[mrez][mrez]; // создаем конечную матрицу
            for (i = 0; i < nrez; i++) {
                rez[i] = new int[mrez]; //задаем количество элементов в каждой строке
            }
            // удаляем из временной матрицы столбцы, заполненные нулями
            flag = 0;
            for (j = 0; j < m; j++) {
                for (i = 0; i < nrez; i++) {
                    if (flag_stl[j] == 0) {
                        rez[i][j - flag] = temp[i][j];
                    }
                    if (flag_stl[j] == 1) {
                        flag++;
                    }
                }
            }
            System.out.println("После уплотнения");
            for (i = 0; i < nrez; i++) {
                for (j = 0; j < mrez; j++) {
                    System.out.print(rez[i][j] + "\t");
                }
                System.out.print("\n");
            }
        }
    }
}

