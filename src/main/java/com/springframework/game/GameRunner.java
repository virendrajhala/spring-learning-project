package com.springframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private GamingConsole game;   // loosely coupled with all the game classes

    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game){
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
