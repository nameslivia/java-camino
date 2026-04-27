package com.javacamino.oop;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = { new Dog("Justin"), new Cat("Amber"), new Bird("Milo") };

        for (Animal a : animals) {
            a.makeSound();
        }

        Shape[] shapes = { new Circle(5.0), new Rectangle(4.0, 6.0) };

        for (Shape s : shapes) {
            s.describe();
        }

        Duck d = new Duck("Donald");
        d.fly();
        d.swim();

        BankAccount acc = new BankAccount(1000);
        acc.deposit(500);
        System.out.println(acc.getBalance()); // 1500.0
        acc.withdraw(200);
        System.out.println(acc.getBalance()); // 1300.0
        acc.withdraw(2000);           // 警告：餘額不足！
        System.out.println(acc.getBalance()); // 1300.0
    }
}
