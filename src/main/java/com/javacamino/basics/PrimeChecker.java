package com.javacamino.basics;

public class PrimeChecker {

    // 質數的定義： 只能被 1 和自己整除的數（2, 3, 5, 7, 11...）
    /*
        如果 n 小於 2，直接 return false
        用迴圈從 2 開始，試著把 n 除以每個數字
        如果有任何一個數字能整除（n % i == 0），就不是質數
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        } return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2));   // true
        System.out.println(isPrime(7));   // true
        System.out.println(isPrime(10));  // false
        System.out.println(isPrime(1));   // false
    }
}
