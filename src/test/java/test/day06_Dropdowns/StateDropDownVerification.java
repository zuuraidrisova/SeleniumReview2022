package test.day06_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class StateDropDownVerification {
     /*
  TC #22: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
these lines above have already been handled in beforeMethod
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
         */

     WebDriver driver;

     @BeforeMethod
     public void setUp(){

         driver = WebDriverFactory.getDriver("chrome");

         driver.manage().window().maximize();

         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         driver.get("http://practice.cybertekschool.com/dropdown");

     }

     @Test
     public void verifyDropDownSelection() throws InterruptedException{

         WebElement dropdown = driver.findElement(By.xpath("//select[@id='state']"));

         Select select = new Select(dropdown);

         Thread.sleep(2000);

         select.selectByValue("VA");

         Thread.sleep(2000);

         select.selectByVisibleText("Illinois");

         Thread.sleep(2000);

         select.selectByIndex(5);

         String finalSelectionValue = select.getFirstSelectedOption().getText();

         String expected = "California";

         Assert.assertTrue(finalSelectionValue.equals(expected));

         System.out.println("Passed");
     }

     @AfterMethod
    public void tearDown(){

         driver.close();
     }

}
