package com.czz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilterApplicationTests {

    @Test
    void contextLoads() {
        int i;
        for (i=1;i <=100 ; i++) {
            i+=1;
        }
        System.out.println (i);
    }

}
