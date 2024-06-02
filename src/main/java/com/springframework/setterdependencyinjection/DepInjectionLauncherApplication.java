package com.springframework.setterdependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class BusinessClass{
    Dependency1 dependency1;
    Dependency2 dependency2;

    // dependency injection acieved via separate-separate setter methods

    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        this.dependency1 = dependency1;
    }

    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using field injection for : " + dependency1 + " and " + dependency2;
    }

}

@Component  // default bean name - dependency1 (camel case of class name)
class Dependency1{

    public String toString(){
        return "Dependency 1";
    }
}

@Component("Dependency2")  // can give component - bean name like this
class Dependency2{

    public String toString(){
        return "Dependency 2";
    }
}


@Configuration   // @Configuration classes are also created as beans in the spring context
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            // o/p -> Using field injection for : Dependency 1 and Dependency 2
            System.out.println(context.getBean(BusinessClass.class));

        }
    }
}
