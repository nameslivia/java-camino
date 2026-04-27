package com.javacamino.oop;

public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    // 圓面積
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    // 圓周長
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
