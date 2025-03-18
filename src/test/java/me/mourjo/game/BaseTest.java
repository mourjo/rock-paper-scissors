package me.mourjo.game;

import me.mourjo.game.core.action.Move;
import me.mourjo.game.core.action.PaperMove;
import me.mourjo.game.core.action.PlayableMove;
import me.mourjo.game.core.action.QuitMove;
import me.mourjo.game.core.action.RockMove;
import me.mourjo.game.core.action.ScissorsMove;

public class BaseTest {

    public PlayableMove paperMove = PaperMove.getInstance();
    public PlayableMove scissorsMove = ScissorsMove.getInstance();
    public PlayableMove rockMove = RockMove.getInstance();
    public Move quitMove = QuitMove.getInstance();
}
