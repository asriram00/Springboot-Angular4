package com.example.SpringBootAngular4.demo.test;

import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAngular2ApplicationTests {

	@Test
    public void testDummy() {
		assertSame("true", true, true);
    }

}