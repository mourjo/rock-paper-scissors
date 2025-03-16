package me.mourjo.game.core.action;

public final class QuitMove extends Move {

    private static Move INSTANCE;

    private QuitMove() {}

    @Override
    public String getDescription() {
        return "Quit the game";
    }

    @Override
    public String getKeyboardShortcut() {
        return "q";
    }

    @Override
    public MoveResult fight(Move otherMove) {
        throw new IllegalArgumentException("This move is invalid");
    }

    public static Move getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuitMove();
        }
        return INSTANCE;
    }
}
