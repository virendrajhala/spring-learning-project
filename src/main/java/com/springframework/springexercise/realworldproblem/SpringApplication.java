package com.springframework.springexercise.realworldproblem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringApplication {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(SpringApplication.class);
        System.out.println(context.getBean(BusinessCalculationSerivce.class).findMax());
    }
}
