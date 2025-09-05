package tech.mabunda.command;

import com.google.gson.JsonObject;

import tech.mabunda.game.GameState;

public class HelpCommand extends Command {
    public HelpCommand() {
        this.name = "help";
    }

    @Override
    public JsonObject execute(GameState state) {
        JsonObject response = new JsonObject();
        response.addProperty("result", "OK");

        String helpInfo = 
            "Available commands:\n" +
            "- draw: draw a card from the deck.\n" +
            "- <card>: play the specified card.\n" +
            "- <card> + <color>: play a wild card, color is required" +
            "- hand: show available cards.\n" +
            "- help: show available commands.\n" +
            "- quit: quit the game.\n";
        response.addProperty("data", helpInfo);

        return response;
    }
}
