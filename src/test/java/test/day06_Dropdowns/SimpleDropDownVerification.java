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

public class SimpleDropDownVerification {
    /*
TC#21: Verifying “Simple dropdown” and “State selection” dropdown default values
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
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
    public void verifySimpleDropdownDefaultValue(){

       WebElement dropdown =  driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(dropdown);

       String dropdownText = select.getFirstSelectedOption().getText();

       String expected = "Please select an option";

        System.out.println("dropdownText = " + dropdownText);

        Assert.assertEquals(dropdownText, expected);

        System.out.println("Passed");
    }

    @Test
    public void stateSelectionDefault(){

        WebElement stateDropdown = driver.findElement(By.xpath("//select[@id='state']"));

        Select select = new Select(stateDropdown);

        String actual = select.getFirstSelectedOption().getText();

        System.out.println(actual);

        String expected = "Select a State";

        Assert.assertTrue(actual.equals(expected));

        System.out.println("Passed");

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }

}
