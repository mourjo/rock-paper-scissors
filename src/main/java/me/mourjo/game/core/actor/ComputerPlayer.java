package me.mourjo.game.core.actor;

import java.util.List;
import java.util.Random;
import me.mourjo.game.core.action.Move;
import me.mourjo.game.core.action.PaperMove;
import me.mourjo.game.core.action.RockMove;
import me.mourjo.game.core.action.ScissorsMove;

public class ComputerPlayer {

    Random random = new Random();
    List<Move> playableMoves = List.of(
        RockMove.getInstance(),
        PaperMove.getInstance(),
        ScissorsMove.getInstance()
    );

    public Move makeMove() {
        return playableMoves.get(random.nextInt(playableMoves.size()));
    }
}
