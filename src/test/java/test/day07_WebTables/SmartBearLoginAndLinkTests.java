package test.day07_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearLoginAndLinkTests {
          /*
TC #27: Smartbear software link verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page
     */

      WebDriver driver;

      @BeforeMethod
      public void setup(){

          driver = WebDriverFactory.getDriver("chrome");

          driver.manage().window().maximize();

          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

      }

      @Test
      public void linkVerification(){

          WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));

          WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));

          WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

          username.sendKeys("Tester");

          password.sendKeys("test");

          loginButton.click();

          List<WebElement> links = driver.findElements(By.tagName("a"));

          System.out.println("number of links on the landing page:  = " + links.size());

          Assert.assertTrue(links.size() ==  6);

          for (WebElement each : links){

              System.out.println(each.getText());
          }

      }

      @AfterMethod
      public void teardown(){

          driver.close();
      }

}
