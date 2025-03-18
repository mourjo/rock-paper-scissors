package me.mourjo.game;

import java.util.HashSet;
import me.mourjo.game.core.Engine;
import me.mourjo.game.core.action.MoveResult;
import me.mourjo.game.core.action.PlayableMove;
import me.mourjo.game.core.actor.ComputerPlayer;
import me.mourjo.game.io.EngineInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EngineTest extends BaseTest {

    Engine engine = new Engine();

    @Test
    void invalidInput() {
        Assertions.assertTrue(engine.processInput("a").isEmpty());
        Assertions.assertTrue(engine.processInput("8").isEmpty());
    }

    @Test
    void validInput() {
        Assertions.assertTrue(engine.processInput("q").isPresent());
        Assertions.assertTrue(engine.processInput("r").isPresent());
        Assertions.assertTrue(engine.processInput("p").isPresent());
        Assertions.assertTrue(engine.processInput("s").isPresent());
    }

    @Test
    void playerMovesIncludeQuitting() {
        var userMoves = new HashSet<>(engine.userMoves());
        userMoves.remove(paperMove);
        userMoves.remove(quitMove);
        userMoves.remove(rockMove);
        userMoves.remove(scissorsMove);
        Assertions.assertTrue(userMoves.isEmpty());
    }

    void play(PlayableMove playerMove, PlayableMove computerMove, MoveResult expectedResult) {
        Engine deterministicEngine = new Engine(new InsistentPlayer(computerMove));

        var input = new EngineInput(playerMove);
        var output = deterministicEngine.play(input);

        Assertions.assertEquals(computerMove, output.computerMove());
        Assertions.assertEquals(playerMove, output.playerMove());
        Assertions.assertEquals(expectedResult, output.moveResultForPlayer());
    }


    @Test
    void gameResults() {
        play(rockMove, paperMove, MoveResult.LOSE);
        play(rockMove, scissorsMove, MoveResult.WIN);
        play(rockMove, rockMove, MoveResult.DRAW);

        play(paperMove, paperMove, MoveResult.DRAW);
        play(paperMove, scissorsMove, MoveResult.LOSE);
        play(paperMove, rockMove, MoveResult.WIN);

        play(scissorsMove, paperMove, MoveResult.WIN);
        play(scissorsMove, scissorsMove, MoveResult.DRAW);
        play(scissorsMove, rockMove, MoveResult.LOSE);
    }

    static class InsistentPlayer extends ComputerPlayer {

        private final PlayableMove alwaysMove;

        public InsistentPlayer(PlayableMove move) {
            alwaysMove = move;
        }

        @Override
        public PlayableMove makeMove() {
            return alwaysMove;
        }
    }
}
