package com.lasha.slots;

import java.util.List;

public class PayoutCalculator {

    public int calculate(List<Symbol> symbols, int bet) {
        if (symbols.isEmpty()) {
            return 0;
        }
        Symbol first = symbols.get(0);
        boolean allSame = symbols.stream().allMatch(symbol -> symbol == first);
        return allSame ? bet * first.getMultiplier() : 0;
    }
}
