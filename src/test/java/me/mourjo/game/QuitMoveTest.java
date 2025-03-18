package me.mourjo.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuitMoveTest extends BaseTest {

    @Test
    void hasShortcut() {
        Assertions.assertEquals("q", quitMove.getKeyboardShortcut());
    }
}
