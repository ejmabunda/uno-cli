package tech.mabunda;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import tech.mabunda.game.Game;

/**
 * Entry point for the UNO CLI application.
 * <p>
 * This class contains the main method to launch the UNO game from the command line interface (CLI).
 * It is responsible for initializing the application and starting the game loop.
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
