package tech.mabunda;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import tech.mabunda.game.Game;

/**
 * Entry point for the UnoCLI application.
 * <p>
 * Launches the Uno game from the command line, initializes the game, and starts the game loop.
 * Only human players are supported.
 */
@Command(
    name = "UnoCLI",
    mixinStandardHelpOptions = true,
    version = "UnoCLI 1.0",
    description = "A simple console-based implementation of Uno."
)
public class App implements Runnable {
    @Option(
        names = {"-p", "--players"},
        description = "The numbers of players to add."
    )
    private String players;

    /**
     * Main method to start the UNO CLI application.
     * <p>
     * Initializes the application and starts the UNO game loop.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        int numPlayers = (players != null && !players.isEmpty()) ? Integer.parseInt(players) : 2;
        Game game = new Game(numPlayers);
        game.start();
    }
}
