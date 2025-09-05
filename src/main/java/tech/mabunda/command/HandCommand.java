package tech.mabunda.command;

import com.google.gson.JsonObject;

import tech.mabunda.game.GameState;
import tech.mabunda.player.Player;

/**
 * Command to display the current player's hand in the Uno game.
 * <p>
 * Returns a string representation of the player's hand when executed.
 */
public class HandCommand extends Command {
    public HandCommand() {
        this.name = "hand";
    }

    @Override
    public JsonObject execute(GameState state) {
        JsonObject response = new JsonObject();

        Player currentPlayer = state.getCurrentPlayer();
        response.addProperty("result", "OK");
        response.addProperty("data", currentPlayer.toString());

        return response;
    }
    
}
