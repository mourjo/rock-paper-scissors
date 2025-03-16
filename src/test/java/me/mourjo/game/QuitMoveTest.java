package me.mourjo.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuitMoveTest extends BaseMoveTest {

    @Test
    void notPlayable() {
        Assertions.assertThrows(
            Exception.class,
            () -> quitMove.fight(rockMove)
        );

        Assertions.assertThrows(
            Exception.class,
            () -> quitMove.fight(scissorsMove)
        );

        Assertions.assertThrows(
            Exception.class,
            () -> quitMove.fight(paperMove)
        );

        Assertions.assertThrows(
            Exception.class,
            () -> quitMove.fight(quitMove)
        );
    }
}
