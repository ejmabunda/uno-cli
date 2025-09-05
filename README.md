# UnoCLI

A simple console-based Uno card game for the terminal, written in Java.

## Features

- Play Uno with 2-10 human players
- Standard Uno rules and card types
- Interactive command-line interface

## Getting Started

**Requirements:**
- Java 17 or higher
- Maven 3.6+

**Install and Run:**
```bash
git clone https://github.com/ejmabunda/uno-cli.git
cd uno-cli
mvn clean compile
mvn exec:java -Dexec.mainClass="tech.mabunda.App"
```

## How to Play

1. Start the game and select the number of players (2-10)
2. Enter player names
3. Follow on-screen prompts to play cards
4. Use commands:
   - `help` — Show available commands
   - `hand` — View your hand
   - `quit` — Exit the game

## Game Rules

Standard Uno rules apply.

- Match cards by color or number
- Special action cards: Skip, Reverse, Draw Two
- Wild cards: Wild, Wild Draw Four
- Call "Uno" when you have one card left
- First player to empty their hand wins

## 🛠 Development

### Project Structure

```text
src/
├── main/java/tech/mabunda/
│   ├── App.java              # Main application entry point
│   ├── game/                 # Core game logic
│   ├── player/               # Player implementations
│   ├── card/                 # Card definitions and deck management
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

## Contributing

This is a portfolio project, but suggestions and feedback are welcome! Feel free to open an issue or submit a pull request.

## License

This project is open source and available under the [MIT License](LICENSE).

## Contact

**Junior Mabunda** - [GitHub](https://github.com/ejmabunda)

---

Built with ❤️ as a portfolio project showcasing Java development skills
