package com.javacamino.oop;

public abstract class Shape {

    public abstract double area();
    public abstract double perimeter();

    public void describe() {
        System.out.println("Area: " + area() + ", Perimeter: " + perimeter());
    }
}
