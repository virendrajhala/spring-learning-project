package com.springframework.springexercise.realworldproblem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService {

    public int[] retrieveData() {
        return new int[]{11, 12, 13, 14, 15, 16};
    }
}
