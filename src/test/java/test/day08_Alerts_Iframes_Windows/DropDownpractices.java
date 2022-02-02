package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownpractices {
     /*
    TC#31: Cybertek “month”dropdown default value
    1.Open browser
    2.Go to website: http://practice.cybertekschool.com/dropdown
    3.Verify default value is always showing the current month
    Expected: If currently in June, should show June selected

   TC#32: Cybertek “month”dropdown list of default values verification
   1.Do both verifications in the same test
   2.Verify list of months are correct as expected.
   Expected: Options should contain all 12 months of the year.
    */

     WebDriver driver;

     @BeforeMethod
     public void setup(){

         driver = WebDriverFactory.getDriver("chrome");

         driver.manage().window().maximize();

         driver.get("http://practice.cybertekschool.com/dropdown");

         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     }

     @Test
     public void monthDropdownTest(){

        WebElement month =  driver.findElement(By.xpath("//select[@id='month']"));

         Select select = new Select(month);

         String actual = select.getFirstSelectedOption().getText();

         String expected = LocalDate.now().getMonth().toString();

         Assert.assertEquals(actual.toLowerCase(),expected.toLowerCase());

         System.out.println("passed");

         List<WebElement> listOfMonths = driver.findElements(By.xpath("//select[@id='month']/option"));

         List<String> expectedOptions = new ArrayList<>();

         expectedOptions.addAll(Arrays.asList("January", "February", "March", "April", "May", "June", "July"
                 , "August", "September", "October", "November", "December"));


         List<String> actualOptions = new ArrayList<>();

         for (WebElement each : listOfMonths) {

             actualOptions.add(each.getText());
         }

         Assert.assertTrue(actualOptions.equals(expectedOptions));

         System.out.println("passed");

     }

     @AfterMethod
    public void teardown(){

         driver.close();
    }

}
