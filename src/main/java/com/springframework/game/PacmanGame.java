package com.springframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class PacmanGame implements GamingConsole {

    public void up(){
        System.out.println(PacmanGame.class.getName()+" Jump");
    }

    public void down(){
        System.out.println(PacmanGame.class.getName()+" dodge");
    }
    public void left(){
        System.out.println(PacmanGame.class.getName()+" go back");
    }
    public void right(){
        System.out.println(PacmanGame.class.getName()+" accelerate");
    }
}
