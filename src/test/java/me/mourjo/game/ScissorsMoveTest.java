package me.mourjo.game;

import static me.mourjo.game.MoveResult.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScissorsMoveTest extends BaseMoveTest {
    @Test
    void wins(){
        Assertions.assertEquals(WIN, scissorsMove.fight(paperMove));
        Assertions.assertEquals(WIN, rockMove.fight(scissorsMove));
    }

    @Test
    void losses(){
        Assertions.assertEquals(LOSE, scissorsMove.fight(rockMove));
        Assertions.assertEquals(LOSE, paperMove.fight(scissorsMove));

    }

    @Test
    void draws(){
        Assertions.assertEquals(DRAW, scissorsMove.fight(scissorsMove));
    }
}
