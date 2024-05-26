package com.springframework.learn;

import com.springframework.game.GameRunner;
import com.springframework.game.GamingConsole;
import com.springframework.game.PacmanGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {
//        var game = new MarioGame();
//        val game = new SuperContraGame();

        // object creation
        var game = new PacmanGame();

        // object creation + wiring of dependency, game is a dependency
        GameRunner gameRunner = new GameRunner(game);
        gameRunner.runGame();
    }
}
