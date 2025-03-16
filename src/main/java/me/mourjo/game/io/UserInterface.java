package me.mourjo.game.io;

import java.util.Scanner;
import me.mourjo.game.core.Engine;
import me.mourjo.game.core.action.Move;
import me.mourjo.game.core.action.QuitMove;

public class UserInterface {

    static final String DELIM = "--------------------------------------";

    private static String movePrompt(Engine engine) {
        StringBuilder sb = new StringBuilder();
        for (Move move : engine.userMoves()) {
            sb.append(move.getKeyboardShortcut());
            sb.append(": ");
            sb.append(move.getDescription());
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void startRepl(Engine engine) {
        String prompt = movePrompt(engine);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(prompt);
            System.out.print("Input: ");

            boolean shouldLoop = readEvalPrint(scanner, engine);
            if (!shouldLoop) {
                break;
            }

        }
    }

    private static boolean readEvalPrint(Scanner scanner, Engine engine) {
        String input = scanner.nextLine();

        var move = engine.processInput(input);

        if (move.isEmpty()) {
            System.out.println("Invalid input, try again");
            System.out.println();
            return true;
        }

        Move playerMove = move.get();
        if (playerMove.equals(QuitMove.getInstance())) {
            System.out.println("Exiting, bye!");
            return false;
        }

        eval(engine, playerMove);
        return true;
    }

    private static void eval(Engine engine, Move playerMove) {
        var engineInput = new EngineInput(playerMove);
        var engineOutput = engine.play(engineInput);
        System.out.println();
        System.out.println(DELIM);
        System.out.println("Player played: " + engineOutput.playerMove());
        System.out.println("Computer played: " + engineOutput.computerMove());
        System.out.print("Result: ");
        switch (engineOutput.moveResultForPlayer()) {
            case WIN -> System.out.println("Player Wins");
            case LOSE -> System.out.println("Player Loses");
            case DRAW -> System.out.println("It's a draw");
        }
        System.out.println(DELIM);
        System.out.println();
        System.out.println();
    }

}
