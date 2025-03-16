package me.mourjo.game.core;

import java.util.List;
import java.util.Optional;
import me.mourjo.game.core.action.Move;
import me.mourjo.game.core.action.PaperMove;
import me.mourjo.game.core.action.QuitMove;
import me.mourjo.game.core.action.RockMove;
import me.mourjo.game.core.action.ScissorsMove;
import me.mourjo.game.core.actor.ComputerPlayer;

public class Engine {

    private final ComputerPlayer computerPlayer;
    private List<Move> allMoves = buildAllMoves();

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
