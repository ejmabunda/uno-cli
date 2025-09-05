package tech.mabunda.command;

import com.google.gson.JsonObject;

import tech.mabunda.game.GameState;

public abstract class Command {
    protected String name;

    public abstract JsonObject execute(GameState state);

    public static Command create(String command) {
        return switch (command.toLowerCase()) {
            case "help" -> new HelpCommand();
            default -> null;
        };
    }
}
