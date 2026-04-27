package com.javacamino.oop;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = { new Dog("Justin"), new Cat("Amber"), new Dog("Milo") };

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
