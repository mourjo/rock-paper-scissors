package me.mourjo;

import me.mourjo.game.core.Engine;
import me.mourjo.game.io.UserInterface;

/**
 * Hello world!
 */
public class RPSApplication {

    public static void main(String[] args) {
        System.out.println("Starting the system...");
        System.out.println();

        Engine engine = new Engine();
        UserInterface.startRepl(engine);
    }
}
