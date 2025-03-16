package me.mourjo.game.core.action;

public final class RockMove extends Move{
    private static Move INSTANCE;
    private RockMove() {

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
    public MoveResult fight(Move otherMove) {
        return switch (otherMove) {
            case ScissorsMove s -> MoveResult.WIN;
            case PaperMove s -> MoveResult.LOSE;
            default ->  MoveResult.DRAW;
        };
    }

    public static Move getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RockMove();
        }
        return INSTANCE;
    }
}
