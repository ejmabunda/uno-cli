package tech.mabunda;

import tech.mabunda.game.Game;

/**
 * Entry point for the UNO CLI application.
 * <p>
 * This class contains the main method to launch the UNO game from the command line interface (CLI).
 * It is responsible for initializing the application and starting the game loop.
 */
public class App {
    /**
     * Main method to start the UNO CLI application.
     * <p>
     * Initializes the application and starts the UNO game loop.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
