package com.javacamino.oop;

public class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // 長方形面積
    @Override
    public double area() {
        return width * height;
    }

    // 長方形周長
    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}
