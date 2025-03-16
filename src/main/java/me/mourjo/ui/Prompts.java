package me.mourjo.ui;

import me.mourjo.game.Move;
import me.mourjo.game.Engine;

public class Prompts {

    public static String movePrompt(Engine engine) {
        StringBuilder sb = new StringBuilder();
        for (Move move : engine.userMoves()) {
            sb.append(move.getKeyboardShortcut());
            sb.append(": ");
            sb.append(move.getDescription());
            sb.append("\n");
        }

        return sb.toString();
    }

}
