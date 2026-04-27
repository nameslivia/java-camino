package com.javacamino.oop;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = { new Dog("Justin"), new Cat("Amber"), new Dog("Milo") };

        for (Animal a : animals) {
            a.makeSound();
        }

        Shape[] shapes = { new Circle(5.0), new Rectangle(4.0, 6.0) };

        for (Shape s : shapes) {
            s.describe();
        }
    }
}
