package com.thoughtworks.pos;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PosTests {

    private Pos pos;

    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        pos = (Pos)context.getBean("pos");
    }

    @Test
    public void test() {

    }
}
