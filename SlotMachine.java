package com.lasha.slots;

import java.util.List;
import java.util.Random;

/** A three-reel slot machine. The Random is injected so tests can control the outcome. */
public class SlotMachine {

    private final List<Reel> reels;
    private final PayoutCalculator payoutCalculator;
    private final Random random;

    public SlotMachine(List<Reel> reels, PayoutCalculator payoutCalculator, Random random) {
        this.reels = List.copyOf(reels);
        this.payoutCalculator = payoutCalculator;
        this.random = random;
    }

    /** Builds a machine with three identical reels where low-value symbols are common. */
    public static SlotMachine createDefault(Random random) {
        List<Symbol> strip = List.of(
                Symbol.CHERRY, Symbol.CHERRY, Symbol.CHERRY, Symbol.CHERRY,
                Symbol.LEMON, Symbol.LEMON, Symbol.LEMON,
                Symbol.BELL, Symbol.BELL,
                Symbol.STAR,
                Symbol.SEVEN);
        List<Reel> reels = List.of(new Reel(strip), new Reel(strip), new Reel(strip));
        return new SlotMachine(reels, new PayoutCalculator(), random);
    }

    public SpinResult spin(int bet) {
        if (bet <= 0) {
            throw new IllegalArgumentException("Bet must be positive");
        }
        List<Symbol> landed = reels.stream()
                .map(reel -> reel.spin(random))
                .toList();
        int payout = payoutCalculator.calculate(landed, bet);
        return new SpinResult(landed, bet, payout);
    }
}
