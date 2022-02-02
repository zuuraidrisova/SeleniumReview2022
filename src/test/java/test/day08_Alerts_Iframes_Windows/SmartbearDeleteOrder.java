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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartbearDeleteOrder {
      /*
   TC #36: SmartBear delete order
1. Open browser and
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3.login to SmartBear
4. Delete “Mark Smith” from the list
5. Assert it is deleted from the list
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
      public void verifyDeleteOrder() throws InterruptedException{

          SmartBearUtilities.loginToSmartBear(driver);

          WebElement markSmith = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));

          markSmith.click();

          Thread.sleep(1000);

          WebElement deleteButton = driver.findElement(By.xpath("//input[@value='Delete Selected']"));

          deleteButton.click();

          Thread.sleep(1000);

          List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']//tbody/tr/td[2]"));

          List<String> names = new ArrayList<>();

          String nameDeleted = "Mark Smith";

          for (WebElement each : listOfNames){

              names.add(each.getText());

          }

          Assert.assertTrue(! names.contains(nameDeleted));

          //using if conditions
          if (!names.contains(nameDeleted)){

              System.out.println("Mark Smith is not on the list.Passed");
          }else{

              System.out.println("Mark Smith is on the list.Failed");
          }
      }

      @AfterMethod
      public void teardown(){

          driver.close();
      }

}
