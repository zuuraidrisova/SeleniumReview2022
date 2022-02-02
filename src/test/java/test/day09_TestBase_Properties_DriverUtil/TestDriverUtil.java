package test.day09_TestBase_Properties_DriverUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestDriverUtil {

    @Test
    public void testDriverUtility() throws InterruptedException{

        //now below line will set up driver, open chrome and go to given url altogether
        Driver.getDriver().get("https://www.google.com");

        WebElement search = Driver.getDriver().findElement(By.name("q"));

        String data = ConfigurationReader.getProperty("testData");

        search.sendKeys(data+ Keys.ENTER);

        String actual = Driver.getDriver().getTitle();

        String expected = data;

        Assert.assertTrue(actual.contains(expected));

        System.out.println("Passed");

        Thread.sleep(2000);

        Driver.closeDriver();
    }
}
