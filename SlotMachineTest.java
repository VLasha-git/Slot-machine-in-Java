package com.lasha.slots;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class SlotMachineTest {

    /** Reels with only one symbol always land on it, which makes the result predictable. */
    private SlotMachine machineAlways(Symbol a, Symbol b, Symbol c) {
        List<Reel> reels = List.of(
                new Reel(List.of(a)),
                new Reel(List.of(b)),
                new Reel(List.of(c)));
        return new SlotMachine(reels, new PayoutCalculator(), new Random(1));
    }

    @Test
    void jackpotPaysTwentyFiveTimesTheBet() {
        SpinResult result = machineAlways(Symbol.SEVEN, Symbol.SEVEN, Symbol.SEVEN).spin(10);
        assertTrue(result.isWin());
        assertEquals(250, result.payout());
    }

    @Test
    void mismatchedReelsLose() {
        SpinResult result = machineAlways(Symbol.SEVEN, Symbol.CHERRY, Symbol.LEMON).spin(10);
        assertFalse(result.isWin());
        assertEquals(0, result.payout());
    }

    @Test
    void nonPositiveBetIsRejected() {
        SlotMachine machine = SlotMachine.createDefault(new Random());
        assertThrows(IllegalArgumentException.class, () -> machine.spin(0));
    }
}
