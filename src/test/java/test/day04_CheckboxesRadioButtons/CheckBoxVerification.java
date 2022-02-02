package test.day04_CheckboxesRadioButtons;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class CheckBoxVerification {
       /*

       unfortunately we cant finish this task due to web page already deleted
    TC #18: SeleniumEasy Checkbox Verification – Section 1
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Success – Check box is checked” message is NOT displayed.
4. Click to checkbox under “Single Checkbox Demo” section
5. Verify “Success – Check box is checked” message is displayed.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");


    }
}
