package tech.mabunda.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.JsonObject;

import tech.mabunda.game.GameState;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

public class CommandTest {
    private ArrayList<Player> players;
    private GameState state;

    @BeforeEach
    void setUp() {
        players  = new ArrayList<>();
        players.add(new HumanPlayer("player 0"));
        players.add(new HumanPlayer("player 1"));
        players.add(new HumanPlayer("player 2"));
        state  = new GameState(players);
    }

    @Test
    void testCardInit() {
        Command invalidCommand = Command.create("start");
        assertNull(invalidCommand);
        
        Command helpCommand = Command.create("help");
        assertEquals(HelpCommand.class, helpCommand.getClass());

        Command handCommand = Command.create("hand");
        assertEquals(HandCommand.class, handCommand.getClass());
    }

    @Test
    void testHelpCommandExecute() {
        Command helpCommand = Command.create("help");        

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

    @Test
    void testHandCommandExecutedSuccessfully() {
        Command handCommand = Command.create("hand");
        JsonObject response = handCommand.execute(state);
        assertEquals("OK", response.get("result").getAsString());
        assertNotNull(response.get("data").getAsString());
    }
}
