package tech.mabunda.command;

import com.google.gson.JsonObject;

import tech.mabunda.card.Card;
import tech.mabunda.game.GameState;
import tech.mabunda.player.Player;

public class QuitCommand extends Command {
    public QuitCommand() {
        this.name = "quit";
    }

    @Override
    public JsonObject execute(GameState state) {
        JsonObject response = new JsonObject();

        Player currentPlayer = state.getCurrentPlayer();

        // Place player's cards back to draw pile
        for (Card card: currentPlayer.getHand().getCards()) {
            state.getDeck().getDrawPile().add(card);
        }

        // Remove player from game
        state.getPlayers().remove(currentPlayer);

        response.addProperty("result", "OK");
        response.addProperty("data", currentPlayer.getName() + " left the game.");

        return response;
    }
}
