package com.springframework.springexercise.springbeanscopes;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
// if scope not applied then also by default considered as singleton
class NormalClass{

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{

}

@Configuration   // @Configuration classes are also created as beans in the spring context
@ComponentScan
public class SpringBeanScopesLauncherApplication {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(SpringBeanScopesLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            // above all bean fetches will give the same bean instance, i.e.
            // will print instances with the same hexadecimal code
            // o/p
            //com.springframework.springexercise.springbeanscopes.NormalClass@49c7b90e
            //com.springframework.springexercise.springbeanscopes.NormalClass@49c7b90e
            //com.springframework.springexercise.springbeanscopes.NormalClass@49c7b90e

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

            // all the above fetched will give differnt/new bean instance at each fetch
            // o/p
            //com.springframework.springexercise.springbeanscopes.PrototypeClass@10d307f1
            //com.springframework.springexercise.springbeanscopes.PrototypeClass@4d5b6aac
            //com.springframework.springexercise.springbeanscopes.PrototypeClass@3e84448c
            //com.springframework.springexercise.springbeanscopes.PrototypeClass@4a7f959b
        }
    }
}
