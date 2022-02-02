package test.day07_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MonthDropDownVerification {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

      driver = WebDriverFactory.getDriver("chrome");

      driver.manage().window().maximize();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("http://practice.cybertekschool.com/dropdown");

    }

    /*
    TC#31: Cybertek “month”dropdown default value
    1.Open browser
    2.Go to website: http://practice.cybertekschool.com/dropdown
    3.Verify default value is always showing the current month
    Expected: If currently in June, should show June selected
     */

    @Test
    public void verifyDefaultValueShowsJanuary(){

       WebElement monthDropdown =  driver.findElement(By.xpath("//select[@id='month']"));

        Select select = new Select(monthDropdown);

        String actualMonth = select.getFirstSelectedOption().getText();

        String expectedMonth = "January";

        Assert.assertEquals(actualMonth,expectedMonth);

        System.out.println("Passed");

    }

      /*
    TC#32: Cybertek “month”dropdown list of default values verification
    1.Do both verifications in the same test
    2.Verify list of months are correct as expected.
    Expected: Options should contain all 12 months of the year.
     */

      @Test
      public void verifyListOfMonthCorrect(){

          WebElement monthDropdown = driver.findElement(By.xpath("//select[@id='month']"));

          Select select = new Select(monthDropdown);

          List<WebElement> listOfOptions = select.getOptions();

          List<String> listOfOptionsTexts = new ArrayList<>();

          for (WebElement each : listOfOptions){

              String eachMonth = each.getText();

              listOfOptionsTexts.add(eachMonth);

          }

          //Create a list of Strings and write all the months in the year.
          // This will be our expected values.
          List<String> expectedListOfMonth = new ArrayList<>();

          expectedListOfMonth.addAll(Arrays.asList("January", "February", "March", "April", "May", "June", "July"
                  , "August", "September", "October", "November", "December"));

          Assert.assertEquals(listOfOptionsTexts, expectedListOfMonth);

          System.out.println("Passed");

      }

    @AfterMethod
    public void teardown(){

        driver.close();

    }


}
