package com.lasha.slots;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class WalletTest {

    @Test
    void debitReducesBalance() {
        Wallet wallet = new Wallet(100);
        wallet.debit(30);
        assertEquals(70, wallet.getBalance());
    }

    @Test
    void creditIncreasesBalance() {
        Wallet wallet = new Wallet(100);
        wallet.credit(25);
        assertEquals(125, wallet.getBalance());
    }

    @Test
    void cannotDebitMoreThanBalance() {
        Wallet wallet = new Wallet(10);
        assertThrows(IllegalArgumentException.class, () -> wallet.debit(20));
    }
}
