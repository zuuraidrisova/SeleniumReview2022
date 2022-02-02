package test.day06_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class NonSelectDropDown {
    /*
    TC #25: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void nonSelectDropDownVerification() throws InterruptedException{

        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));

        nonSelectDropdown.click();

        Thread.sleep(1000);

        WebElement facebook = driver.findElement(By.linkText("Facebook"));

        facebook.click();

        String expected = "Facebook - Log In or Sign Up";

        Assert.assertEquals(driver.getTitle(),expected);

        System.out.println("Passed");
    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }

}
