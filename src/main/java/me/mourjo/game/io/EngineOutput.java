package me.mourjo.game.io;

import me.mourjo.game.core.action.Move;
import me.mourjo.game.core.action.MoveResult;

public record EngineOutput(
    Move playerMove,
    Move computerMove,
    MoveResult moveResultForPlayer) {

}
