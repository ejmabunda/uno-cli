package tech.mabunda.command;

import com.google.gson.JsonObject;

import tech.mabunda.game.GameState;

/**
 * Abstract base class for CLI commands in the Uno game.
 * <p>
 * Subclasses implement specific commands (help, hand, quit) that interact with the game state.
 * Provides a factory method to create commands by name.
 */
public abstract class Command {
    protected String name;

    public abstract JsonObject execute(GameState state);

    public static Command create(String command) {
        return switch (command.toLowerCase()) {
            case "help" -> new HelpCommand();
            case "hand" -> new HandCommand();
            case "quit" -> new QuitCommand();
            default -> null;
        };
    }
}
