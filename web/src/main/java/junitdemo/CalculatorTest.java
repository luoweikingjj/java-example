package junitdemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    @Before
    public void init(){
        System.out.println("init...");
    }

    @After
    public void close(){
        System.out.println("close...");
    }

    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 1);
        Assert.assertEquals(2, result);
    }

    @Test
    public void testSub(){
        Calculator calculator = new Calculator();
        int result = calculator.sub(2, 1);
        Assert.assertEquals(1, result);
    }
}
