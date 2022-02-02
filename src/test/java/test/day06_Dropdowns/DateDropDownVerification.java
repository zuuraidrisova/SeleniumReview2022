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

public class DateDropDownVerification {
    /*
TC #23: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select “December 1st, 1971” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number
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
    public void verifyDateSelection() throws InterruptedException{

       WebElement yearDropdown =  driver.findElement(By.xpath("//select[@id='year']"));

        Select select = new Select(yearDropdown);

        select.selectByValue("1971");

        String actualYear = select.getFirstSelectedOption().getText();

        Thread.sleep(2000);

        WebElement monthDropdown =  driver.findElement(By.xpath("//select[@id='month']"));

        Select select2 = new Select(monthDropdown);

        select2.selectByVisibleText("December");

        String actualMonth = select2.getFirstSelectedOption().getText();

        Thread.sleep(2000);

        WebElement dayDropdown =  driver.findElement(By.xpath("//select[@id='day']"));

        Select select3 = new Select(dayDropdown);

        select3.selectByIndex(0);

        String actualDay = select3.getFirstSelectedOption().getText();

        Thread.sleep(2000);

        //December 1st, 1971 verify

        Assert.assertEquals(actualYear, "1971");

        Assert.assertTrue(actualMonth.equals("December"));

        Assert.assertEquals(actualDay,"1");

        System.out.println("Passed");

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
