package me.mourjo.game;

import static me.mourjo.game.core.action.MoveResult.DRAW;
import static me.mourjo.game.core.action.MoveResult.LOSE;
import static me.mourjo.game.core.action.MoveResult.WIN;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RockMoveTest extends BaseTest {
    @Test
    void wins() {
        Assertions.assertEquals(WIN, rockMove.fight(scissorsMove));
        Assertions.assertEquals(WIN, paperMove.fight(rockMove));
    }

    @Test
    void losses() {
        Assertions.assertEquals(LOSE, rockMove.fight(paperMove));
        Assertions.assertEquals(LOSE, scissorsMove.fight(rockMove));
    }

    @Test
    void draws() {
        Assertions.assertEquals(DRAW, rockMove.fight(rockMove));
    }
}
