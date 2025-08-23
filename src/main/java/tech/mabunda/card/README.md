# Card Types and the `play` Method in UnoCLI

This document describes the different card types in UnoCLI and the behavior of their `play` methods, which are central to the game's logic.

## Card Hierarchy

- **Card (abstract)**: The base class for all UNO cards. Defines common properties (`type`, `value`, `color`) and the abstract method `play(GameState state)`.
- **NumberCard**: Represents number cards (0-9). Implements `play` to define how a number card is played.
- **ActionCard**: Represents action cards (Skip, Reverse, Draw Two). Implements `play` to apply special effects.
- **WildCard**: Represents wild cards (Wild, Wild Draw Four). Implements `play` to allow color change or force draws.

**Note:** Only human players are currently implemented. AI players and full wild card logic are planned for future updates.

## The `play(GameState state)` Method

Each card type implements the `play(GameState state)` method to define its effect when played. The method signature is:

```java
public boolean play(GameState state)
```
- **Parameters:**
  - `state`: The current game state, including players, deck, and discard pile.
- **Returns:**
  - `true` if the play is valid and successful, `false` otherwise.

### Card Type Behaviors

#### Card (abstract)
- Declares the abstract `play(GameState state)` method.
- All subclasses must implement this method.

#### NumberCard
- Checks if the card can be played (matches color or value).
- Updates the game state if the play is valid.

#### ActionCard
- Checks if the card can be played (matches color or value).
- Applies the action effect (Skip, Reverse, Draw Two) to the game state.
- Example: `state.setPenalty(value)` for Draw Two.

#### WildCard

- Can be played at any time.
- Currently, the `play` method only sets a penalty in the game state. It does **not** yet prompt the player to choose a new color or enforce the draw logic for Wild Draw Four.
- Color selection and full Wild Draw Four logic are planned for future updates.

## Example Usage

```java
Card card = ...;
boolean success = card.play(gameState);
if (success) {
    // Card was played successfully
} else {
    // Invalid play
}
```

## Notes
- The `play` method is central to card logic and should be kept up to date with any rule changes.
- See the source code for each card type for implementation details.
