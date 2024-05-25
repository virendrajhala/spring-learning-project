package com.springframework.demo;

public class BasicGamingApp {

    public static void main(String[] args) {
        MarioGame marioGame = new MarioGame();
        SuperContraGame contraGame = new SuperContraGame();
        PacmanGame pacmanGame = new PacmanGame();

        GameRunner marioGameRunner = new GameRunner(marioGame);
        GameRunner contraGameRunner = new GameRunner(contraGame);
        GameRunner pacmanGameRunner = new GameRunner(pacmanGame);

        marioGameRunner.runMarioGame();
        contraGameRunner.runSuperContraGame();
        pacmanGameRunner.runPacmanGame();
    }
}
