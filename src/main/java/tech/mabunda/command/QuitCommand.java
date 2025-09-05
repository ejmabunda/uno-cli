package tech.mabunda.command;

import com.google.gson.JsonObject;

import tech.mabunda.card.Card;
import tech.mabunda.game.GameState;
import tech.mabunda.player.Player;

/**
 * Command to remove the current player from the game and return their cards to the draw pile.
 * <p>
 * When executed, the player leaves the game and their cards are returned to the deck.
 */
public class QuitCommand extends Command {
    public QuitCommand() {
        this.name = "quit";
    }

    @Override
    public JsonObject execute(GameState state) {
        JsonObject response = new JsonObject();

        Player currentPlayer = state.getCurrentPlayer();
        String currentPlayerName = currentPlayer.getName();

        // Place player's cards back to draw pile
        for (Card card: currentPlayer.getHand().getCards()) {
            state.getDeck().getDrawPile().add(card);
        }
        state.getDeck().shuffle();

        // Remove player from game
        int removedIndex = state.getPlayers().indexOf(currentPlayer);
        state.getPlayers().remove(currentPlayer);

        // Update current player index to avoid out of bounds errors
        if (state.getPlayers().isEmpty()) {
            state.setCurrentPlayerIndex(-1);
        } else {
            // If the removed player was last, move to first player
            if (removedIndex >= state.getPlayers().size()) {
                state.setCurrentPlayerIndex(0);
            } else {
                state.setCurrentPlayerIndex(removedIndex);
            }
        }
        response.addProperty("result", "OK");
        response.addProperty("data", currentPlayerName + " left the game.");

        return response;
    }
}
