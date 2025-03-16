package me.mourjo.game.core.action;

public final class ScissorsMove extends Move {

    private static Move INSTANCE;

    private ScissorsMove() {

    }

    public static Move getInstance() {
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
    public MoveResult fight(Move otherMove) {
        return switch (otherMove) {
            case PaperMove p -> MoveResult.WIN;
            case RockMove r -> MoveResult.LOSE;
            default -> MoveResult.DRAW;
        };
    }
}
