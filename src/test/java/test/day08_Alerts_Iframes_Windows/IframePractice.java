package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class IframePractice {
       /*
    TC #39 : Iframe practice
1. Create a new class called: IframePractice
2. Create new test and make set ups
3. Go to: http://practice.cybertekschool.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
     */

       WebDriver driver;

       @BeforeMethod
        public void setup(){

           driver = WebDriverFactory.getDriver("chrome");

           driver.manage().window().maximize();

           driver.get("http://practice.cybertekschool.com/iframe");

           driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

       }

       @Test
       public void iframeTest(){

          WebElement iframe =  driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

          driver.switchTo().frame(iframe);

         // driver.switchTo().frame(0);
          //driver.switchTo().frame("");

          WebElement contentMessage  = driver.findElement(By.xpath("//body/p"));

          String actual = contentMessage.getText();

          String expected = "Your content goes here.";

           Assert.assertTrue(contentMessage.isDisplayed());

           Assert.assertEquals(actual, expected);

           System.out.println("passed");

           driver.switchTo().parentFrame();//to go back to parent frame
           //driver.switchTo().defaultContent();

           WebElement message = driver.findElement(By.xpath("//h3"));

           String actualText = message.getText();

           String expectedText = "An iFrame containing the TinyMCE WYSIWYG Editor";

           Assert.assertTrue(message.isDisplayed());

           Assert.assertEquals(actualText, expectedText);

           System.out.println("passed");

       }

       @AfterMethod
        public void teardown(){

           driver.close();
       }
}
