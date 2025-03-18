package me.mourjo.game;

import static me.mourjo.game.core.action.MoveResult.DRAW;
import static me.mourjo.game.core.action.MoveResult.LOSE;
import static me.mourjo.game.core.action.MoveResult.WIN;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaperMoveTest extends BaseTest {

    @Test
    void wins() {
        Assertions.assertEquals(WIN, paperMove.play(rockMove));
        Assertions.assertEquals(WIN, scissorsMove.play(paperMove));
    }

    @Test
    void losses() {
        Assertions.assertEquals(LOSE, rockMove.play(paperMove));
        Assertions.assertEquals(LOSE, paperMove.play(scissorsMove));
    }

    @Test
    void draws() {
        Assertions.assertEquals(DRAW, paperMove.play(paperMove));
    }
}
