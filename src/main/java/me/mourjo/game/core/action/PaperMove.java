package me.mourjo.game.core.action;

public final class PaperMove extends PlayableMove {

    private static PaperMove INSTANCE;

    private PaperMove() {

    }

    public static PaperMove getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PaperMove();
        }
        return INSTANCE;
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
    public MoveResult play(PlayableMove otherMove) {
        return switch (otherMove) {
            case RockMove r -> MoveResult.WIN;
            case ScissorsMove s -> MoveResult.LOSE;
            case PaperMove p -> MoveResult.DRAW;
        };
    }
}
