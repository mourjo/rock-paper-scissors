package me.mourjo.game;

import lombok.Getter;

public record EngineOutput (
    Move playerMove,
    Move computerMove,
    MoveResult moveResultForPlayer) {
}
