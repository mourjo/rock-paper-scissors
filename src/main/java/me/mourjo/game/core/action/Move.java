package me.mourjo.game.core.action;

public sealed abstract class Move permits PlayableMove, QuitMove {

    abstract public String getDescription();

    abstract public String getKeyboardShortcut();

    @Override
    public String toString() {
        return getDescription();
    }
}
