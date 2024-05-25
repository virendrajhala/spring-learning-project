package com.springframework.demo;

public class GameRunner {

    private MarioGame game;   // tight coupled with MarioGame class
    private SuperContraGame contraGame;
    private PacmanGame pacmanGame;

    public GameRunner(MarioGame game){
        this.game = game;
    }

    public GameRunner(SuperContraGame contraGame){
        this.contraGame = contraGame;
    }

    public GameRunner(PacmanGame pacmanGame){
        this.pacmanGame = pacmanGame;
    }

    public void runMarioGame(){
        System.out.println("Running the game"+game);
        this.game.up();
        this.game.down();
        this.game.left();
        this.game.right();
    }

    public void runSuperContraGame(){
        System.out.println("Running the game"+contraGame);
        this.contraGame.up();
        this.contraGame.down();
        this.contraGame.left();
        this.contraGame.right();
    }

    public void runPacmanGame(){
        System.out.println("Running the game"+pacmanGame);
        this.pacmanGame.up();
        this.pacmanGame.down();
        this.pacmanGame.left();
        this.pacmanGame.right();
    }
}
