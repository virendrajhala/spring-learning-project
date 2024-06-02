package com.springframework.springexercise.realworldproblem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SqlDataServiceQualifier")
public class SqlDataService implements DataService {

    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }
}
