package me.mourjo.game;

import me.mourjo.game.core.action.Move;
import me.mourjo.game.core.action.PaperMove;
import me.mourjo.game.core.action.QuitMove;
import me.mourjo.game.core.action.RockMove;
import me.mourjo.game.core.action.ScissorsMove;

public class BaseMoveTest {
    public Move paperMove = PaperMove.getInstance();
    public Move scissorsMove = ScissorsMove.getInstance();
    public Move rockMove = RockMove.getInstance();
    public Move quitMove = QuitMove.getInstance();
}
