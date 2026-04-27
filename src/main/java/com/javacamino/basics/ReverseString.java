package com.javacamino.basics;

public class ReverseString {
    public static String reverse(String s) {
        String result = "";

        // 字串可以用 s.charAt(i) 拿到第i個字元
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }

        return  result;
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello"));
        System.out.println(reverse("Charles"));
    }
}
