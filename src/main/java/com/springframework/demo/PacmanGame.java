package com.springframework.demo;

public class PacmanGame {

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
