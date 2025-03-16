package me.mourjo.game;

public final class PaperMove extends Move {
    private static Move INSTANCE;
    private PaperMove() {

    }

    @Override
    public String getDescription() {
        return "Paper";
    }

    @Override
    public String getKeyboardShortcut() {
        return "p";
    }

    @Override
    public MoveResult fight(Move otherMove) {
        return switch (otherMove) {
            case RockMove r -> MoveResult.WIN;
            case ScissorsMove s -> MoveResult.LOSE;
            default ->  MoveResult.DRAW;
        };
    }

    public static Move getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PaperMove();
        }
        return INSTANCE;
    }
}
