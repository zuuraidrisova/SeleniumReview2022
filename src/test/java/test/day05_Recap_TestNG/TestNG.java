package test.day05_Recap_TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {

    @BeforeMethod
    public void setUp(){

        System.out.println("runs before each test");
    }

    @Test
    public void test1(){

        System.out.println("First test using testNG");

    }

    @Test
    public void test2(){

        System.out.println("Second test using testNG");
    }

    @AfterMethod
    public void tearDown(){

        System.out.println("runs after each test");
    }
}
