# Java Slot Machine

A small console slot machine game built with Java 17 and Maven.

## Features
- Three reels with weighted symbols
- Payout rules separated into their own class
- Balance tracking with input validation
- Unit tests with JUnit 5, using injected randomness so results are predictable

## Project structure
- `Symbol` - symbols and their payout multipliers
- `Reel` - picks a random symbol
- `PayoutCalculator` - decides what a spin pays
- `Wallet` - tracks the balance
- `SlotMachine` - ties reels and payouts together
- `Main` - console game loop


## Possible improvements
- Add a pair-of-two payout and tune the odds
- Add a paylines or 5-reel version
- Add a simple GUI with JavaFX
