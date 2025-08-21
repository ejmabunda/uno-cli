# UnoCLI

A console-based implementation of the classic Uno card game with multiplayer support, built in Java.

## 📋 Overview

UnoCLI brings the beloved Uno card game experience to your terminal. Play against AI opponents or with friends in this fully-featured command-line implementation that captures all the excitement of the original game.

## ✨ Features

- **Full Uno Gameplay**: All standard Uno rules and card types
- **Multiplayer Support**: Play with 2-10 players (mix of human and AI players)
- **Interactive CLI**: Clean, intuitive command-line interface
- **Smart AI Players**: Multiple difficulty levels for AI opponents
- **Game Statistics**: Track wins, losses, and gameplay statistics
- **Custom Rules**: Optional house rules and game variations

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/ejmabunda/UnoCLI.git
   cd UnoCLI
   ```

2. Build the project:

   ```bash
   mvn clean compile
   ```

3. Run the game:

   ```bash
   mvn exec:java -Dexec.mainClass="tech.mabunda.App"
   ```

## 🎮 How to Play

1. Start the game and select number of players
2. Choose player names and AI difficulty levels
3. Follow the on-screen prompts to play cards
4. Use special commands:
   - `help` - Show available commands
   - `hand` - View your current hand
   - `quit` - Exit the game

### Game Rules

Standard Uno rules apply:

- Match cards by color or number
- Special action cards: Skip, Reverse, Draw Two
- Wild cards: Wild, Wild Draw Four
- Call "Uno" when you have one card left
- First player to empty their hand wins

#### Card Play Logic

Each card type implements a `play(GameState state)` method that defines its effect when played. This method is called by the player logic and updates the game state accordingly. See `src/main/java/tech/mabunda/card/README.md` for details.

## 🛠 Development

### Project Structure

```text
src/
├── main/java/tech/mabunda/
│   ├── App.java              # Main application entry point
│   ├── game/                 # Core game logic
│   ├── player/              # Player and AI implementations
│   ├── card/                # Card definitions and deck management
│   └── ui/                  # Console UI components
└── test/                    # Unit tests
```

### Building

```bash
# Compile the project
mvn compile

# Run tests
mvn test

# Create JAR
mvn package
```

## 🎯 Roadmap

- [ ] Basic game mechanics and card system
- [ ] Player management and turn system
- [ ] AI player implementation
- [ ] Game state persistence
- [ ] Network multiplayer support
- [ ] Tournament mode
- [ ] Custom card themes

## 🤝 Contributing

This is a portfolio project, but suggestions and feedback are welcome! Feel free to open an issue or submit a pull request.

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 📧 Contact

**Junior Mabunda** - [GitHub](https://github.com/ejmabunda)

---

Built with ❤️ as a portfolio project showcasing Java development skills
