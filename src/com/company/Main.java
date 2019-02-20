package com.company;


public class Main {

    public static void main(String[] args) {
        int countRow;
        int countCol;
        int count = 0;
        int count1 = 0;
        int n = 5;
        int m = 5;
        int nrez, mrez, row, col, summ, flag;
        int[] flag_str = new int[n];
        int[] flag_stl = new int[m];
        nrez = n;
        mrez = m;
        int[][] array = {{1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 4, 5, 6, 7}};
        System.out.println("Исходная матрица: ");
        for (int[] i : array) {
            for ( int j : i) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }
        for ( row = 0; row < n; row++) {   //считаем количество строк, заполненных нулями
            countRow = 0;
            for ( col = 0; col < m; col++) {
                if (array[row][col] == 0) {
                    countRow++;
                }
            }
            if (countRow == n) {
                count++;
            }
        }

        for ( row = 0; row < n; row++) {   //считаем количество солбцов, заполненных нулями
            countCol = 0;
            for ( col = 0; col < m; col++) {
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
            for (row = 0; row < n; row++) { //вычисляем на сколько строк уплотнится матрица и ищем строки, заполненные нулями
                summ = 0;
                for (col = 0; col < m; col++) {
                    summ += array[row][col];

                }
                if (summ == 0) {
                    nrez--;
                    flag_str[row] = 1;
                } else flag_str[row] = 0;
            }
            int[][] temp = new int[nrez][m]; // создаем временную матрицу

            // удаляем из исходной матрицы строки, заполненные нулями
            flag = 0;
            for (row = 0; row < n; row++) {
                if (flag_str[row] == 0) { //если элемент массива равен нулю,
                    for (col = 0; col < m; col++) {
                        temp[row - flag][col] = array[row][col];//то из исходной матрицы переносим все элементы строки в новую матрицу
                    }
                } else flag++;
            }

            for (col = 0; col < m; col++) { //вычисляем на сколько столбцов уплотнится матрица и ищем столбцы, заполненные нулями
                summ = 0;
                for (row = 0; row < nrez; row++) {
                    summ += array[row][col];
                }
                if (summ == 0) {
                    mrez--;
                    flag_stl[col] = 1;
                } else flag_stl[col] = 0;
            }
            int[][] rez = new int[nrez][mrez]; // создаем конечную матрицу

            // удаляем из временной матрицы столбцы, заполненные нулями
            flag = 0;
            for (col = 0; col < m; col++) {
                if (flag_stl[col] == 0) { //если элемент массива равен нулю,
                    for (row = 0; row < nrez; row++) {
                        rez[row][col-flag] = temp[row][col];//то из исходной матрицы переносим все элементы столбца в новую матрицу
                    }
                } else flag++;
            }

            System.out.println("После уплотнения");
            for (row = 0; row < nrez; row++) {
                for (col = 0; col < mrez; col++) {
                    System.out.print(rez[row][col] + "\t");
                }
                System.out.print("\n");
            }
        }
    }
}

