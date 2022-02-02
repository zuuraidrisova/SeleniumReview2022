package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlePractice {
    /*
    TC # 40: Window Handle practice
1. Create a new class called: WindowHandlePractice
2. Create new test and make set ups
3. Go to : http://practice.cybertekschool.com/windows
4. Assert: Title is “Practice”
5. Click to: “Click Here” text
6. Switch to new Window.
7. Assert: Title is “New Window”
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/windows");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void windowHandleTest() throws InterruptedException{

        String currentWindowHandle = driver.getWindowHandle();

        System.out.println("currentWindowHandle = " + currentWindowHandle);

        String actualTitle = driver.getTitle();

        String expectedTitle = "Practice";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("passed");

        WebElement clickButton = driver.findElement(By.xpath("//a[.='Click Here']"));

        clickButton.click();

        Thread.sleep(1000);

        // driver.switchTo().window(currentWindowHandle);

        Set<String> windows = driver.getWindowHandles();

        for (String each : windows){

            driver.switchTo().window(each);

            System.out.println(each);

            String expectedNewWindow = "New Window";

            if (driver.getTitle().equals(expectedNewWindow)){

                Assert.assertTrue(driver.getTitle().equals(expectedNewWindow));

                break;
            }
        }

        driver.switchTo().window(currentWindowHandle);

        System.out.println(driver.getTitle());

        System.out.println("Verifications passed!");

    }

    @AfterMethod
    public void teardown(){

        driver.close();

    }

}
