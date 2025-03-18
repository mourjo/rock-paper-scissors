package me.mourjo.game.core.action;

public abstract sealed class PlayableMove extends Move permits RockMove, ScissorsMove, PaperMove {

    abstract public MoveResult play(PlayableMove otherMove);
}
