package com.lasha.slots;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int STARTING_BALANCE = 100;

    public static void main(String[] args) {
        SlotMachine machine = SlotMachine.createDefault(new Random());
        Wallet wallet = new Wallet(STARTING_BALANCE);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Java Slot Machine ===");

            while (wallet.getBalance() > 0) {
                System.out.println("\nBalance: " + wallet.getBalance());
                System.out.print("Enter your bet (or q to quit): ");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("q")) {
                    break;
                }

                int bet;
                try {
                    bet = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a whole number.");
                    continue;
                }

                if (!wallet.canAfford(bet)) {
                    System.out.println("Invalid bet. Enter a number between 1 and " + wallet.getBalance() + ".");
                    continue;
                }

                wallet.debit(bet);
                SpinResult result = machine.spin(bet);
                wallet.credit(result.payout());

                System.out.println("Result: " + result.symbols());
                if (result.isWin()) {
                    System.out.println("You won " + result.payout() + "!");
                } else {
                    System.out.println("No win this time.");
                }
            }

            System.out.println("\nGame over. Final balance: " + wallet.getBalance());
        }
    }
}
