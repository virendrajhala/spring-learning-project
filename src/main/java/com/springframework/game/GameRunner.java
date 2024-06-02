package com.springframework.game;

public class GameRunner {

    private GamingConsole game;   // loosely coupled with MarioGame class

    public GameRunner(GamingConsole game){
        this.game = game;
    }

    public void runGame(){
        System.out.println("Running the game " + game);
        this.game.up();
        this.game.down();
        this.game.left();
        this.game.right();
    }
}
