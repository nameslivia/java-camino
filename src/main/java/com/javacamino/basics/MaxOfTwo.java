package com.javacamino.basics;

public class MaxOfTwo {

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

//    三元運算子（ternary operator）： a > b 成立的話回傳 a，否則回傳 b
//    public static int max(int a, int b) {
//        return a > b ? a : b;
//    }

    public static void main(String[] args) {
        System.out.println(max(1, 9));
        System.out.println(max(3, 7));
        System.out.println(max(6, 6));
    }
}
