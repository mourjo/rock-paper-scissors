package me.mourjo.game;

import static me.mourjo.game.MoveResult.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RockMoveTest extends BaseMoveTest {
    @Test
    void wins(){
        Assertions.assertEquals(WIN, rockMove.fight(scissorsMove));
        Assertions.assertEquals(WIN, paperMove.fight(rockMove));
    }

    @Test
    void losses(){
        Assertions.assertEquals(LOSE, rockMove.fight(paperMove));
        Assertions.assertEquals(LOSE, scissorsMove.fight(rockMove));
    }

    @Test
    void draws(){
        Assertions.assertEquals(DRAW, rockMove.fight(rockMove));
    }
}
