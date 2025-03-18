package me.mourjo.game.core.action;

public final class RockMove implements PlayableMove {

    private static RockMove INSTANCE;

    private RockMove() {

    }

    public static RockMove getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RockMove();
        }
        return INSTANCE;
    }

    @Override
    public String getDescription() {
        return "Rock";
    }

    @Override
    public String getKeyboardShortcut() {
        return "r";
    }

    @Override
    public MoveResult play(PlayableMove otherMove) {
        return switch (otherMove) {
            case ScissorsMove s -> MoveResult.WIN;
            case PaperMove s -> MoveResult.LOSE;
            case RockMove r -> MoveResult.DRAW;
        };
    }
}
