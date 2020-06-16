package com.pengwei.demo;
import	java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = {"classpath:application.*"} )

class WebDemoApplicationTests {

    @Test
    void contextLoads() {
        HashMap<Integer, String> hashMap = new HashMap();

    }

}
