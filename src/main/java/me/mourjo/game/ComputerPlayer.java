package me.mourjo.game;

import java.util.List;
import java.util.Random;

public class ComputerPlayer {
    Random random = new Random();
    List<Move> playableMoves = List.of(RockMove.getInstance(), PaperMove.getInstance(), ScissorsMove.getInstance());
    public Move makeMove(){
        return playableMoves.get(random.nextInt(playableMoves.size()));
    }
}
