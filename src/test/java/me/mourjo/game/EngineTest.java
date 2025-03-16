package me.mourjo.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EngineTest extends BaseMoveTest{

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

    void play(Move playerMove, Move computerMove, MoveResult expectedResult) {
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
        private Move alwaysMove;

        public InsistentPlayer(Move move) {
            alwaysMove = move;
        }

        @Override
        public Move makeMove() {
            return alwaysMove;
        }
    }
}
