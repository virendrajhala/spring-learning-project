package com.springframework.springexercise.postpreannotations;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

    private Dependency dependency;

    public ClassA(Dependency dependency) {
        this.dependency = dependency;
        System.out.println("All dependencies are wired");
    }

    @PostConstruct
    public void doSomeInitialization() {
        this.dependency.getReady();
    }

    @PreDestroy
    public void doCleanup() {
        System.out.println("Releasing resources before bean destruction");
    }
}


@Component
class Dependency {

    public void getReady() {
        System.out.println("ready for dependency initialization logic");
    }
}


@Configuration   // @Configuration classes are also created as beans in the spring context
@ComponentScan
public class PostPreAnnotationsLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(PostPreAnnotationsLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }

    // O/P

    //All dependencies are wired
    //ready for dependency initialization logic
    //postPreAnnotationsLauncherApplication
    //classA
    //dependency
    //Releasing resources before bean destruction
}
