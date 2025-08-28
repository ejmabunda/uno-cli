package tech.mabunda.game;

import java.util.ArrayList;
import java.util.Scanner;

import tech.mabunda.card.Card;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

/**
 * Main class for managing the UNO game loop and setup.
 * <p>
 * Responsible for initializing the game, creating players (currently only human players), and running the main game loop.
 * Interacts with the {@link GameState} to manage the current state of the game, including player turns, move validation, and win/penalty handling.
 * <p>
 * <b>Note:</b> AI and networked players are planned but not yet implemented. The game currently supports only human players via the command line.
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
     * Constructs a new Game instance with the specified number of players.
     * <p>
     * If the number of players is outside the allowed range (2-10), it is clamped to the nearest valid value.
     * The game state and players are initialized accordingly.
     *
     * @param numPlayers the number of players to participate in the game
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
        this.state = new GameState(createPlayers());
    }

    public Game() {
        this(2);
    }

    /**
     * Creates and returns a list of players for the game.
     * <p>
     * Currently, only human players are supported. The first player is named "player 0",
     * and subsequent players are named "player 1", "player 2", etc.
     *
     * @return a list of Player objects (all human players)
     */
    public ArrayList<Player> createPlayers() {
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

    /**
     * Displays the current player's turn prompt, including the top card, color to match, and the player's hand.
     */
    public void displayPrompt() {
        Player player = state.getCurrentPlayer();
        System.out.println("It's " + player.getName() + "'s turn!");
        System.out.println("The top card is " + state.topDiscardPile());
        if (state.getColor() != null) {
            System.out.println("The color to match is " + state.getColor());
        }
        System.out.print("Your hand:\n\t-> ");

        for (Card card : player.getHand().getCards()) {
            System.out.print(card + ", ");
        }

        System.out.print("\nWhat's your move? ");
    }

    /**
     * Handles user input for the current player's move, including drawing a card or playing a card.
     * Validates the move and updates the game state accordingly.
     *
     * @return true if a valid move was made, false otherwise
     */
    private boolean handleCommand() {
        Player player = state.getCurrentPlayer();
        String command;
        boolean cardPlayed = false;

        do {
            displayPrompt();
            command = sc.nextLine().toLowerCase();


            if (command.equals("draw")) {
                player.getHand().addCard(state.getDeck().drawCard());
                System.out.println(">>> [OK] " + player.getName() + " drew a card.\n");
                return true;
            }

            Card cardToPlay;
            String colorToSet = "";

            if (command.contains("wild")) {
                String[] tokens = command.split(" ");
                StringBuilder sb = new StringBuilder();
                sb.append(tokens[0]);
                for (int i = 1; i < tokens.length - 1; i++) {
                    sb.append("_" + tokens[i]);
                }
                cardToPlay = Card.create(sb.toString());
                colorToSet = tokens[tokens.length - 1].toUpperCase();

            } else {
                cardToPlay = Card.create(command);
            }

            // Check if card is valid
            if (cardToPlay == null) {
                System.out.println(">>> [ERROR] Invalid card, please enter a valid format (e.g blue skip)!\n");
                continue;
            }

            // Check if player has the card
            if (!player.hasCard(cardToPlay)) {
                System.out.println(">>> [ERROR] You do not have that card, try again!\n");
                continue;
            }

            // Check if card is playable based on the current state
            cardPlayed = cardToPlay.play(state);
            if (cardPlayed) {
                System.out.println(">>> [OK] " + player.getName() + " played " + cardToPlay + "\n");
                
                if (cardToPlay.getType() == Type.WILD) {
                    state.setColor(Color.valueOf(colorToSet));
                }
            }
            else {
                System.out.println(">>> [ERROR] You cannot play " + cardToPlay + " on " + state.topDiscardPile() + "\n");
            }
        } while (!cardPlayed);

        return true;
    }

    /**
     * Starts the main UNO game loop.
     * <p>
     * Sets up the game state and repeatedly processes player turns until only one player remains.
     * Handles win and penalty conditions, processes each player's move, and advances turns.
     *
     * <b>Note:</b> Only human players are currently supported. AI and network play are planned for future development.
     */
    public void start() {
        sc = new Scanner(System.in);
        Player player;

        while (state.getPlayers().size() > 1) {
            player = state.getCurrentPlayer();

            // Check win status or penalty, skip player if either is true
            if (state.isWinner()) {
                System.out.println(">>> " + player.getName() + " won.\n");
                state.getPlayers().remove(player);
                state.updatePlayer();
                continue;
            } else if (state.handlePenalty()) {
                System.out.println(">>> Skipping " + player.getName() + "\n");
                state.updatePlayer();
                continue;
            }

            // Process player's move
            handleCommand();

            // Go to next player
            state.updatePlayer();
        }

        System.out.println(">>> Game over!");
    }
}
