package me.mourjo.game.core.actor;

import java.util.List;
import java.util.Random;
import me.mourjo.game.core.action.PaperMove;
import me.mourjo.game.core.action.PlayableMove;
import me.mourjo.game.core.action.RockMove;
import me.mourjo.game.core.action.ScissorsMove;

public class ComputerPlayer {

    Random random = new Random();
    List<PlayableMove> playableMoves = List.of(
        RockMove.getInstance(),
        PaperMove.getInstance(),
        ScissorsMove.getInstance()
    );

    public PlayableMove makeMove() {
        return playableMoves.get(random.nextInt(playableMoves.size()));
    }
}
