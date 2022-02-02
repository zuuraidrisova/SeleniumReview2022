package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class AlertsPractice {
    /*
    TC #33: Information alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify You successfuly clicked an alert
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(priority = 1)
    public void verifyInformationAlert() throws InterruptedException{

       WebElement informationAlert =  driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

       informationAlert.click();

       Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();

        alert.accept();

        Thread.sleep(1000);

        WebElement successMessage = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(successMessage.isDisplayed());

        String actualMessage = successMessage.getText();

        String expectedMessage = "You successfuly clicked an alert";

        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println("passed");
    }

      /*
  TC #34: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.
   */

      @Test(priority = 2)
      public void verifyConfirmationAlert() throws InterruptedException{

          WebElement confirmationAlert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));

          confirmationAlert.click();

          Thread.sleep(1000);

          Alert alert = driver.switchTo().alert();

          alert.accept();

          Thread.sleep(1000);

          WebElement message = driver.findElement(By.xpath("//p[@id='result']"));

          String actual = message.getText();

          String expected = "You clicked: Ok";

          Assert.assertTrue(message.isDisplayed());

          Assert.assertEquals(actual, expected);

          System.out.println("passed");
      }

        /*
    TC #35: JS Prompt alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered: hello” text is displayed.
     */

    @Test(priority = 3)
    public void verifyPromptAlert() throws InterruptedException{

        WebElement promptAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));

        promptAlert.click();

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("hello");

        Thread.sleep(1000);

        alert.accept();

        Thread.sleep(1000);

        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));

        String expected = "You entered: hello";

        String actual = message.getText();

        Assert.assertTrue(message.isDisplayed());

        Assert.assertEquals(actual, expected);

        System.out.println("passed");
    }


    @AfterMethod
    public void teardown(){

        driver.close();
    }
}
