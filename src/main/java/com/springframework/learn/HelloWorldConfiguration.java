package com.springframework.learn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name,int age){};
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Jhala";
    }

    @Bean
    public int age(){
        return 26;
    }
}
