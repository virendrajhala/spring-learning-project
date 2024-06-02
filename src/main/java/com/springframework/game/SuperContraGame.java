package com.springframework.game;

public class SuperContraGame implements GamingConsole{

    public void up(){
        System.out.println(SuperContraGame.class.getName()+" Jump");
    }

    public void down(){
        System.out.println(SuperContraGame.class.getName()+" dodge");
    }
    public void left(){
        System.out.println(SuperContraGame.class.getName()+" go back");
    }
    public void right(){
        System.out.println(SuperContraGame.class.getName()+" accelerate");
    }
}
