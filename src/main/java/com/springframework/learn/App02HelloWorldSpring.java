package com.springframework.learn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    // 1. Launch spring context
    // 2. Configure the things that we want the spring to manage - @Configuration

    public static void main(String[] args){
        var context =  new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
    }
}
