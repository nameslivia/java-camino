package com.javacamino.basics;

public class MultiplicationTable {

    public static void main(String[] args) {

        // 建立 3x3 的二維陣列
        int [][] table = new int[3][3];

        /*
          外層迴圈控制「列」（row），內層迴圈控制「行」（column）
          table[i][j] 的值 = 第幾列 × 第幾行
          i 和 j 從 0 開始，但乘法表從 1 開始，所以要 +1
         */

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
