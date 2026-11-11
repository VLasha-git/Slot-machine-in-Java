package com.lasha.slots;

import java.util.List;
import java.util.Random;

/** A single reel. Symbols that appear more often in the list are more likely to land. */
public class Reel {

    private final List<Symbol> symbols;

    public Reel(List<Symbol> symbols) {
        if (symbols == null || symbols.isEmpty()) {
            throw new IllegalArgumentException("A reel needs at least one symbol");
        }
        this.symbols = List.copyOf(symbols);
    }

    public Symbol spin(Random random) {
        return symbols.get(random.nextInt(symbols.size()));
    }
}
