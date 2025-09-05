package tech.mabunda.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonObject;

import tech.mabunda.game.GameState;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

public class CommandTest {
    @Test
    void testCardInit() {
        Command invalidCommand = Command.create("start");
        assertNull(invalidCommand);
        
        Command helpCommand = Command.create("help");
        assertEquals(HelpCommand.class, command.getClass());
    }

    @Test
    void testHelpCommandExecute() {
        Command helpCommand = Command.create("help");

        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 0"));
        players.add(new HumanPlayer("player 1"));
        players.add(new HumanPlayer("player 2"));
        GameState state = new GameState(players);

        JsonObject response = helpCommand.execute(state);
        String expected =
            "Available commands:\n" +
            "- draw: draw a card from the deck.\n" +
            "- <card>: play the specified card.\n" +
            "- <card> + <color>: play a wild card, color is required" +
            "- hand: show available cards.\n" +
            "- help: show available commands.\n" +
            "- quit: quit the game.\n";
        
        assertEquals("OK", response.get("result").getAsString());
        assertEquals(expected, response.get("data").getAsString());
    }
}
