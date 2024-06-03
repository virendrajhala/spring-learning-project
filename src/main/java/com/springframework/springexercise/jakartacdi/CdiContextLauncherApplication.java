package com.springframework.springexercise.jakartacdi;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

interface DataService {

    int[] retrieveData();
}

@Named
class BusinessCalculationSerivce {
    private DataService dataService;

    @Inject  // it is also ok, if @Autowired not applied on constructor injection
    public BusinessCalculationSerivce(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}

@Named
@Primary
class MongoDbDataService implements DataService {

    public int[] retrieveData() {
        return new int[]{11, 12, 13, 14, 15, 16};
    }
}

@Named
@Qualifier("SqlDataServiceQualifier")
class SqlDataService implements DataService {

    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }
}


@Configuration   // @Configuration classes are also created as beans in the spring context
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessCalculationSerivce.class).findMax());
        }
    }
}
