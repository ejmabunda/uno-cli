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
 * This class is responsible for initializing the game, creating players
 * (currently only human players), and running the main game loop.
 * It interacts with the {@link GameState} to manage the current state of the
 * game, including player turns, card play, and win/penalty checks.
 * <p>
 * <b>Note:</b> Only human players are currently supported. AI and networked
 * players
 * are planned for future development.
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
     * Constructs a new Game instance with the specified number of players.
     * <p>
     * Initializes the game object and sets up the game state with the given number
     * of players.
     * If the number is outside the allowed range, it is clamped to the minimum or
     * maximum.
     *
     * @param numPlayers the number of players to create (clamped between 2 and 10)
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
     * Currently, only human players are supported. The first player is named
     * "player 0"
     * and the rest are named incrementally ("player 1", "player 2", etc).
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
     * Displays the current player's turn prompt, including the top card, color to
     * match, and the player's hand.
     */
    public String getPrompt() {
        Player player = state.getCurrentPlayer();
        StringBuilder sb = new StringBuilder();

        sb.append("It's " + player.getName() + "'s turn!");
        sb.append("\nThe top card is " + state.topDiscardPile());
        if (state.getColor() != null) {
            sb.append("\nThe color to match is " + state.getColor().toString().toLowerCase());
        }

        ArrayList<Card> cards = player.getHand().getCards();
        
        if (cards.isEmpty()) {
            sb.append("\nYou currently have no cards.");
        } else {
            sb.append("\nYour hand:\n\t-> ");
            sb.append(cards.get(0));
            for (int i = 1; i < cards.size(); i++) {
                sb.append(", " + cards.get(i));
            }
        }
        sb.append("\nWhat's your move? ");

        return sb.toString();
    }

    /**
     * Handles user input for the current player's move, including drawing a card or
     * playing a card.
     * Validates the move and updates the game state accordingly.
     *
     * @return true if a valid move was made, false otherwise
     */
    private boolean handleCommand() {
        Player player = state.getCurrentPlayer();
        String command;
        boolean cardPlayed = false;

        do {
            System.out.print(getPrompt());
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
            } else {
                System.out
                        .println(">>> [ERROR] You cannot play " + cardToPlay + " on " + state.topDiscardPile() + "\n");
            }
        } while (!cardPlayed);

        return true;
    }

    /**
     * Starts the main UNO game loop.
     * <p>
     * Sets up the game state and repeatedly processes player turns until only one
     * player remains. Handles win and penalty checks, player move input, and turn
     * updates.
     */
    public void start() {
        sc = new Scanner(System.in);
        Player player;

        while (state.getPlayers().size() > 1) {
            player = state.getCurrentPlayer();

            // Check win status or penalty, skip player if either is true
            if (state.isWinner() || state.handlePenalty()) {
                System.out.println(">>> Skipping " + player.getName() + "\n");
                continue;
            } else if (state.handlePenalty()) {
                System.out.println(">>> Skipping " + player.getName() + "\n");
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
