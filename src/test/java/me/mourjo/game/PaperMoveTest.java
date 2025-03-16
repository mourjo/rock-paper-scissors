package me.mourjo.game;

import static me.mourjo.game.MoveResult.DRAW;
import static me.mourjo.game.MoveResult.LOSE;
import static me.mourjo.game.MoveResult.WIN;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaperMoveTest extends BaseMoveTest{


    @Test
    void wins(){
        Assertions.assertEquals(WIN, paperMove.fight(rockMove));
        Assertions.assertEquals(WIN, scissorsMove.fight(paperMove));
    }

    @Test
    void losses(){
        Assertions.assertEquals(LOSE, rockMove.fight(paperMove));
        Assertions.assertEquals(LOSE, paperMove.fight(scissorsMove));
    }

    @Test
    void draws(){
        Assertions.assertEquals(DRAW, paperMove.fight(paperMove));
    }
}
