package test.day06_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Testng_Selenium {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com");

    }

    @Test(priority = 1)
    public void googleTitleTest(){

       String actual =  driver.getTitle();

       String expected = "Google";

       Assert.assertEquals(actual, expected);

        System.out.println("Passed");
    }

    @Test(priority = 2)
    public void googleSearchTest(){

        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);

        String actual = driver.getTitle();

        String expected = "apple - Google Search";

        Assert.assertEquals(actual,expected);

        System.out.println("Passed");
    }

    @AfterMethod
    public void teardown(){

        driver.close();

    }

}
