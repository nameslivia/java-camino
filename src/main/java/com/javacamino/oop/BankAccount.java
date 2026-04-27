package com.javacamino.oop;

public class BankAccount {
    // 封裝讓外部不能直接改 balance
    private double balance;

    public BankAccount (double initialBalance) {
        this.balance = initialBalance;
    }

    // getter
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    // 業務邏輯保護在 class 內部 ➠ 封裝的價值所在
    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("警告：餘額不足！目前餘額： " + balance);
        } else  {
            balance -= amount;
        }
    }
}
