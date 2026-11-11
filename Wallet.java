package com.lasha.slots;

public class Wallet {

    private int balance;

    public Wallet(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public boolean canAfford(int amount) {
        return amount > 0 && amount <= balance;
    }

    public void debit(int amount) {
        if (!canAfford(amount)) {
            throw new IllegalArgumentException("Invalid or unaffordable amount: " + amount);
        }
        balance -= amount;
    }

    public void credit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot credit a negative amount");
        }
        balance += amount;
    }
}
