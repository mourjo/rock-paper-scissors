package me.mourjo.game.core.action;

public sealed interface PlayableMove extends Move permits RockMove, ScissorsMove, PaperMove {

    MoveResult play(PlayableMove otherMove);
}
