package me.mourjo;

import java.util.Scanner;
import me.mourjo.game.EngineInput;
import me.mourjo.game.Move;
import me.mourjo.game.QuitMove;
import me.mourjo.ui.Prompts;
import me.mourjo.game.Engine;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Engine engine = new Engine();
        String prompt = Prompts.movePrompt(engine);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(prompt);
            System.out.print("Input: ");

            String input = scanner.nextLine();
            var move = engine.processInput(input);

            if(move.isEmpty()) {
                System.out.println("Invalid input, try again");
                System.out.println();
            } else {
                Move playerMove = move.get();
                if (playerMove.equals(QuitMove.getInstance())) {
                    System.out.println("Exiting, bye!");
                    break;
                } else {
                    var engineInput = new EngineInput(playerMove);
                    var engineOutput = engine.play(engineInput);
                    System.out.println("Player played: " + engineOutput.playerMove());
                    System.out.println("Computer played: " + engineOutput.computerMove());

                    switch (engineOutput.moveResultForPlayer()){
                        case WIN -> System.out.println("Player Wins");
                        case LOSE -> System.out.println("Player Loses");
                        case DRAW -> System.out.println("It's a draw");
                    }
                    System.out.println();
                }
            }
        }
    }
}
