package com.springframework.helloworldspring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name,int age, Address address){};

record Address(String firstLine, String city) {};

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

    @Bean
    public Person person(){
        return new Person("Viru",27, new Address("Baker street","London"));
    }

//    ----------------- above all beans names = method names

    @Bean(name = "address2")
    public Address secondAddress(){
        return new Address("plot no. 1546, sector 17C","Gurgaon");
    }

    @Bean(name = "address3")
    @Primary
    public Address thirdAddress(){
        return new Address("plot no. 55P, sector 44","Gurgaon");
    }

    @Bean(name = "address4")
    @Qualifier("address4qualifier")
    public Address fourthAddress(){
        return new Address("cyber-hub","Gurgaon");
    }


//  -------------------- above bean name = address2, address3, address4  -----------------------------
    @Bean
    public Person person2MethodCall(){
        return new Person(name(),age(),secondAddress());   // dependent/ related beans using method name calls
    }

    @Bean
    public Person person3Parameters(String name,int age, Address address3){
        // dependent/ related beans, using method bean names as parameters and returning the same
        return new Person(name,age,address3);
    }

    @Bean
    public Person person4Parameters(String name,int age,@Qualifier("address4qualifier") Address address){
        // dependent/ related beans, using method bean names as parameters and returning the same
        return new Person(name,age,address);
    }
}
