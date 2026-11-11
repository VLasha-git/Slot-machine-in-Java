package com.lasha.slots;

import java.util.List;

public record SpinResult(List<Symbol> symbols, int bet, int payout) {

    public boolean isWin() {
        return payout > 0;
    }
}
