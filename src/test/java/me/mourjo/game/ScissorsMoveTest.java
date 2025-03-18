package me.mourjo.game;

import static me.mourjo.game.core.action.MoveResult.DRAW;
import static me.mourjo.game.core.action.MoveResult.LOSE;
import static me.mourjo.game.core.action.MoveResult.WIN;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScissorsMoveTest extends BaseTest {

    @Test
    void wins() {
        Assertions.assertEquals(WIN, scissorsMove.play(paperMove));
        Assertions.assertEquals(WIN, rockMove.play(scissorsMove));
    }

    @Test
    void losses() {
        Assertions.assertEquals(LOSE, scissorsMove.play(rockMove));
        Assertions.assertEquals(LOSE, paperMove.play(scissorsMove));

    }

    @Test
    void draws() {
        Assertions.assertEquals(DRAW, scissorsMove.play(scissorsMove));
    }
}
