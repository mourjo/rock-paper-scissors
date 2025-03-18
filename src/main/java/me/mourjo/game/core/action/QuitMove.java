package me.mourjo.game.core.action;

public final class QuitMove implements Move {

    private static Move INSTANCE;

    private QuitMove() {
    }

    public static Move getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuitMove();
        }
        return INSTANCE;
    }

    @Override
    public String getDescription() {
        return "Quit the game";
    }

    @Override
    public String getKeyboardShortcut() {
        return "q";
    }
}
