package com.lasha.slots;

import java.util.List;

/** The outcome of one spin. */
public record SpinResult(List<Symbol> symbols, int bet, int payout) {

    public boolean isWin() {
        return payout > 0;
    }
}
