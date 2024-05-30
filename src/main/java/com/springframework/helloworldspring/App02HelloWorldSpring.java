package com.springframework.helloworldspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {

    // 1. Launch spring context
    // 2. Configure the things that we want the spring to manage - @Configuration

    public static void main(String[] args){
        // try with resources to close the context after code completion
        try(var context =  new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            // retrieving beans out of spring context
            //1. by bean method name
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
//        System.out.println(context.getBean("address")); // will give error "No bean named 'address' available"
            System.out.println(context.getBean("address2"));

            // 2. by class type
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("person4Parameters"));

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
