package tech.mabunda.game;

import java.util.ArrayList;
import java.util.Scanner;

import tech.mabunda.card.Card;
import tech.mabunda.card.enums.Type;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

/**
 * Manages the main UNO game loop and setup.
 * <p>
 * This class is responsible for initializing the game, creating players, and running the main game loop.
 * It interacts with the {@link GameState} to manage the current state of the game.
 */
public class Game {
    /**
     * The current state of the game, including players, deck, and turn order.
     */
    private GameState state;

    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a new Game instance.
     * <p>
     * Initializes the game object. The actual game state is set up in {@link #init()}.
     */
    public Game() {
        // No initialization here; see init().
    }

    /**
     * Creates and returns a list of players for the game.
     * <p>
     * By default, creates one human player named "player 0" and the rest as human players with incremented names.
     *
     * @param numPlayers the number of players to create
     * @return a list of Player objects
     */
    private ArrayList<Player> getPlayers(int numPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 0"));
        for (int i = 1; i < numPlayers; i++) {
            players.add(new HumanPlayer("player " + i));
        }
        return players;
    }

    /**
     * Initializes the game state, including creating players and setting up the deck.
     * <p>
     * This method should be called before starting the game loop.
     */
    private void init() {
        ArrayList<Player> players = getPlayers(2);
        this.state = new GameState(players);
    }

    /**
     * Starts the main UNO game loop.
     * <p>
     * Sets up the game state and repeatedly processes player turns until only one player remains.
     * The actual move processing and state updates are marked as TODO for future implementation.
     */
    public void start() {
        // Setup game state, including players, the deck and penalties
        init();

        // Main game loop, continues until only 1 player left
        Player player;
        String move;
        Card card;
        while (this.state.getPlayers().size() > 1) {
            player = this.state.getCurrentPlayer();
            
            // TODO: Process player's move
            System.out.print(player.getName() + ", what's your move? ");
            move = scanner.nextLine();

            // TODO: Setup a protocol

            // TODO: Update game state

            this.state.updatePlayer();
        }
    }
}
