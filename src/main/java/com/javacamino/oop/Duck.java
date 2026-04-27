package com.javacamino.oop;

public class Duck extends Animal implements Flyable, Swimmable {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming!");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying!");
    }
}
