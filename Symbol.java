package com.lasha.slots;
public enum Symbol {
    CHERRY(2),
    LEMON(3),
    BELL(5),
    STAR(10),
    SEVEN(25);

    private final int multiplier;

    Symbol(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
