package me.mourjo.game;

import static me.mourjo.game.core.action.MoveResult.DRAW;
import static me.mourjo.game.core.action.MoveResult.LOSE;
import static me.mourjo.game.core.action.MoveResult.WIN;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RockMoveTest extends BaseTest {

    @Test
    void wins() {
        Assertions.assertEquals(WIN, rockMove.play(scissorsMove));
        Assertions.assertEquals(WIN, paperMove.play(rockMove));
    }

    @Test
    void losses() {
        Assertions.assertEquals(LOSE, rockMove.play(paperMove));
        Assertions.assertEquals(LOSE, scissorsMove.play(rockMove));
    }

    @Test
    void draws() {
        Assertions.assertEquals(DRAW, rockMove.play(rockMove));
    }
}
