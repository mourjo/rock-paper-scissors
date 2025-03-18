package me.mourjo.game.core.action;

public sealed interface Move permits PlayableMove, QuitMove {

    String getDescription();

    String getKeyboardShortcut();
}
