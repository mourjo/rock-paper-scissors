package me.mourjo.game.core.action;

public sealed abstract class Move permits PaperMove, QuitMove, RockMove, ScissorsMove {

    abstract public String getDescription();
    abstract public String getKeyboardShortcut();
    abstract public MoveResult fight(Move otherMove);

    @Override
    public String toString() {
        return getDescription();
    }
}
