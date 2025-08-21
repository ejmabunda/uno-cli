package tech.mabunda.game;

import java.util.ArrayList;

import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

public class Game {
    private GameState state;

    public Game() {
        
    }

    private ArrayList<Player> getPlayers(int numPlayers) {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new HumanPlayer("player 0"));
        for (int i = 1; i < numPlayers; i++) {
            players.add(new HumanPlayer("player " + i));
        }

        return players;
    }

    private void init() {
        ArrayList<Player> players = getPlayers(2);
        this.state = new GameState(players);
    }

    public void start() {
        // Setup game state, including players, the deck and penalties
        init();

        // Main game loop, continues until only 1 player left
        Player player;
        while (this.state.getPlayers().size() > 1) {
            player = this.state.getCurrentPlayer();

            // TODO: Process player's move

            // TODO: Update game state

            this.state.updatePlayer();
        }
    }
}
