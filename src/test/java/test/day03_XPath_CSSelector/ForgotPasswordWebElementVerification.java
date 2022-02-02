package test.day03_XPath_CSSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class ForgotPasswordWebElementVerification {

      /*
    TC #11: PracticeCybertek.com_ForgotPassword WebElement verification
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/forgot_password
    3. Locate all the WebElements on the page using XPATH locator only (total of 6)
             a. “Home” link
             b. “Forgot password” header
             c. “E-mail” text
             d. E-mail input box
             e. “Retrieve password” button
             f. “Powered byCybertek School” text
    4. Verify all WebElements are displayed.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homeLink =  driver.findElement(By.xpath("//li[@class='nav-item']/a"));

        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//div[@class='example']/h2"));

        WebElement email = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/label"));

        WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']"));

        WebElement retrieveButton = driver.findElement(By.xpath("//button[@class='radius']"));

        WebElement poweredByCybertekSchoolText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        if (homeLink.isDisplayed() && forgotPasswordHeader.isDisplayed()
        && email.isDisplayed() && emailInput.isDisplayed() && retrieveButton.isDisplayed()
        && poweredByCybertekSchoolText.isDisplayed()){

            System.out.println("All web elements are displayed!Verification passed");

        }else{

            System.out.println("Not all web elements are displayed.Failed");
        }

        driver.close();
    }
}
