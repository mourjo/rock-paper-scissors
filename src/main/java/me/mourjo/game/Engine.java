package me.mourjo.game;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Engine {
    private Random random = new Random();
    private final ComputerPlayer computerPlayer;

    public Engine(ComputerPlayer computerPlayer) {
        this.computerPlayer = computerPlayer;
    }

    public Engine() {
        this(new ComputerPlayer());
    }

    private static List<Move> buildAllMoves() {
        return List.of(
            RockMove.getInstance(),
            PaperMove.getInstance(),
            ScissorsMove.getInstance(),
            QuitMove.getInstance()
        );
    }

    private List<Move> allMoves = buildAllMoves();


    public Optional<Move> processInput(String input) {
        for (Move move : allMoves) {
            if (move.getKeyboardShortcut().equalsIgnoreCase(input)) {
                return Optional.of(move);
            }
        }
        return Optional.empty();
    }

    public EngineOutput play(EngineInput input) {
        var playerMove = input.playerMove();
        var computerMove = computerPlayer.makeMove();
        var result = playerMove.fight(computerMove);
        return new EngineOutput(
            playerMove,
            computerMove,
            result
        );
    }

    public List<Move> userMoves() {
        return allMoves;
    }
}
