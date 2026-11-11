package com.lasha.slots;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class PayoutCalculatorTest {

    private final PayoutCalculator calculator = new PayoutCalculator();

    @Test
    void threeMatchingSymbolsPayBetTimesMultiplier() {
        List<Symbol> symbols = List.of(Symbol.BELL, Symbol.BELL, Symbol.BELL);
        assertEquals(50, calculator.calculate(symbols, 10));
    }

    @Test
    void mixedSymbolsPayNothing() {
        List<Symbol> symbols = List.of(Symbol.BELL, Symbol.CHERRY, Symbol.BELL);
        assertEquals(0, calculator.calculate(symbols, 10));
    }
}
