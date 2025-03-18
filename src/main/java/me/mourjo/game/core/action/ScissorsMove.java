package me.mourjo.game.core.action;

public final class ScissorsMove implements PlayableMove {

    private static ScissorsMove INSTANCE;

    private ScissorsMove() {

    }

    public static ScissorsMove getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScissorsMove();
        }
        return INSTANCE;
    }

    @Override
    public String getDescription() {
        return "Scissors";
    }

    @Override
    public String getKeyboardShortcut() {
        return "s";
    }

    @Override
    public MoveResult play(PlayableMove otherMove) {
        return switch (otherMove) {
            case PaperMove p -> MoveResult.WIN;
            case RockMove r -> MoveResult.LOSE;
            case ScissorsMove s -> MoveResult.DRAW;
        };
    }
}
