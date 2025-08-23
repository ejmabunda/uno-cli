package tech.mabunda.game;

import java.util.ArrayList;
import java.util.Scanner;

import tech.mabunda.card.Card;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

/**
 * Manages the main UNO game loop and setup.
 * <p>
 * This class is responsible for initializing the game, creating players
 * (currently only human players), and running the main game loop.
 * It interacts with the {@link GameState} to manage the current state of the
 * game.
 * <p>
 * <b>Note:</b> The main game logic and move processing are under development.
 * AI and networked players are planned but not yet implemented.
 */
public class Game {
    /**
     * The current state of the game, including players, deck, and turn order.
     */
    private GameState state;

    private int minPlayers = 2;

    private int maxPlayers = 10;

    private int numPlayers;

    private Scanner sc;

    /**
     * Constructs a new Game instance.
     * <p>
     * Initializes the game object. The actual game state is set up in
     * {@link #init()}.
     */
    public Game(int numPlayers) {
        if (numPlayers < minPlayers) {
            System.out.println("Uno can host only 2-10 players.");
            this.numPlayers = minPlayers;
        } else if (numPlayers > maxPlayers) {
            System.out.println("Uno can host only 2-10 players");
            this.numPlayers = maxPlayers;
        } else {
            this.numPlayers = numPlayers;
        }
        System.out.println("Creating game with " + this.numPlayers + " players.");
        this.state = new GameState(getPlayers());
    }

    public Game() {
        this(2);
    }

    /**
     * Creates and returns a list of players for the game.
     * <p>
     * Currently, only human players are supported. By default, creates one human
     * player named "player 0" and the rest as human players with incremented names.
     *
     * @param numPlayers the number of players to create
     * @return a list of Player objects (all human players)
     */
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 0"));
        for (int i = 1; i < numPlayers; i++) {
            players.add(new HumanPlayer("player " + i));
        }
        return players;
    }

    public GameState getState() {
        return state;
    }

    public Card validateCommand(String command) {
        command = command.toLowerCase();
        if (command.equals("draw")) {
            return state.getDeck().drawCard();
        }

        return Card.create(command);
    }

    /**
     * Starts the main UNO game loop.
     * <p>
     * Sets up the game state and repeatedly processes player turns until only one
     * player remains.
     * <b>Note:</b> The actual move processing and state updates are not yet
     * implemented and are marked as TODO for future development.
     */
    public void start() {
        sc = new Scanner(System.in);

        // Main game loop, continues until only 1 player left.. the loser
        Player player;
        Card card;
        String penalty;
        String command;

        while (this.state.getPlayers().size() > 1) {
            player = this.state.getCurrentPlayer();
            // Player has won, go to next
            if (player.getHand().getCards().isEmpty()) {
                this.state.updatePlayer();
                continue;
            }

            // Handle penalties
            penalty = state.getPenalty();
            if (!penalty.isEmpty()) {
                if (penalty.equals("skip")) {
                    System.out.println("Skipping " + player.getName());
                    state.removePenalty();
                    continue;
                }
                else if (penalty.equals("draw two")) {
                    state.getDeck().drawCard();
                    state.getDeck().drawCard();
                }
                else {
                    System.out.println("Unknown penalty " + penalty + " ignoring.");
                }
            }

            // Process player's move
            do {
                System.out.println(player.toString());
                System.out.print("What's your move? ");
                command = sc.nextLine();
                card = validateCommand(command);
            }
            while (card == null);

            // Play card and go to next player
            card.play(state);
            this.state.updatePlayer();
        }
    }
}
