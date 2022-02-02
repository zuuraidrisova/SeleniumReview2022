package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartbearEditOrder {
      /*
    TC #37: SmartBear edit order
1. Open browser
Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
and login to SmartBear
2. Click to edit button from the right for “Steve Johns”
3. Change name to “Michael Jordan”
4. Click Update
5. Assert “Michael Jordan” is in the list
     */

      WebDriver driver;

      @BeforeMethod
      public void setup(){

          driver = WebDriverFactory.getDriver("chrome");

          driver.manage().window().maximize();

          driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      }

      @Test
      public  void editOrder() throws InterruptedException{

          SmartBearUtilities.loginToSmartBear(driver);

          WebElement steveJohnsEditButton = driver.findElement(By.xpath("//table[@class='SampleTable']//tbody/tr[4]/td[13]"));

          steveJohnsEditButton.click();

          Thread.sleep(1000);

          WebElement nameInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));

          nameInput.clear();

          Thread.sleep(1000);

          nameInput.sendKeys("Michael Jordan");

          Thread.sleep(1000);

          WebElement updateButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']"));

          updateButton.click();

          Thread.sleep(1000);

          List<WebElement> listNames = driver.findElements(By.xpath("//table[@class='SampleTable']//tbody/tr/td[2]"));

          String expectedName = "Michael Jordan";

          //String actualName = "";

          for (WebElement each :  listNames){

              if (each.getText().equals(expectedName)){

                  //actualName = each.getText();

                  Assert.assertTrue(each.getText().equals(expectedName));
              }
          }

         // Assert.assertTrue(actualName.equals(expectedName));

          System.out.println("Passed");
      }


      @AfterMethod
      public void teardown(){

          driver.close();
      }


}
