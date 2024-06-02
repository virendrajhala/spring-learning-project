package com.springframework.springexercise.realworldproblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationSerivce {

    private DataService dataService;

    @Autowired  // it is also ok, if @Autowired not applied on constructor injection
    public BusinessCalculationSerivce(DataService dataService){
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(BusinessCalculationSerivce.class);

        System.out.println(context.getBean(BusinessCalculationSerivce.class).findMax());

    }
}
