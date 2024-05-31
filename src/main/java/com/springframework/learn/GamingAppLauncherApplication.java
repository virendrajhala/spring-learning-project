package com.springframework.learn;

import com.springframework.game.GameRunner;
import com.springframework.game.GamingConsole;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springframework.game")
public class GamingAppLauncherApplication {

    // until the @ComponentScan("path to the component") is not defined,
    // it will give exception during context initialization saying no qualifying bean found for GaminConsole
    // even if the component present in the same package, you need to define its path in the
    // @ComponentScan("") to tell the spring container to find that component at that place

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {

// To explicitly get the bean by its name
            // explicitly written "marioGame" i.e. component name to get its implementation for GamingConsole interface
            GamingConsole gamingConsole = context.getBean("marioGame",GamingConsole.class);
            gamingConsole.up();

            // Print the class name to see which implementation is injected
            System.out.println("Injected GamingConsole class: " + gamingConsole.getClass().getName());

            context.getBean(GameRunner.class).runGame();
        }
    }
}
