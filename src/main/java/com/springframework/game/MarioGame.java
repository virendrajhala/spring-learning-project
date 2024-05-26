package com.springframework.game;

public class MarioGame implements GamingConsole{

    public void up(){
        System.out.println(MarioGame.class.getName()+" Jump");
    }

    public void down(){
        System.out.println(MarioGame.class.getName()+" dodge");
    }
    public void left(){
        System.out.println(MarioGame.class.getName()+" go back");
    }
    public void right(){
        System.out.println(MarioGame.class.getName()+" accelerate");
    }
}
