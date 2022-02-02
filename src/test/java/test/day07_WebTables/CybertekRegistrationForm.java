package test.day07_WebTables;

import com.github.javafaker.Faker;
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

public class CybertekRegistrationForm {

        /*
    TC#30: Cybertek registration form confirmation
Note: Use JavaFaker when possible.
1. Open browser
2. Go to website: http://practice.cybertekschool.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You've successfully completed registration!” is
displayed.
     */


    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/registration_form");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void registrationFormVerification() throws InterruptedException{

        Faker faker = new Faker();

       WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));

        firstName.sendKeys(faker.name().firstName());

        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));

        lastName.sendKeys(faker.name().lastName());

        Thread.sleep(1000);

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));

        userName.sendKeys(faker.name().firstName());

        Thread.sleep(1000);

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));

        email.sendKeys(faker.internet().emailAddress());

        Thread.sleep(1000);

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

        password.sendKeys(faker.internet().password());

        Thread.sleep(1000);

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));

       //phoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
        phoneNumber.sendKeys("112-121-2222");

        Thread.sleep(1000);

        WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));

        gender.click();

        Thread.sleep(1000);

        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@name='birthday']"));

        dateOfBirth.sendKeys("11/12/1993");

        Thread.sleep(1000);

        WebElement department = driver.findElement(By.xpath("//select[@name='department']"));

        Select select = new Select(department);

        select.selectByVisibleText("Tresurer's Office");

        Thread.sleep(1000);

        WebElement jobTitle = driver.findElement(By.xpath("//select[@name='job_title']"));

        select = new Select(jobTitle);

        select.selectByVisibleText("SDET");

        Thread.sleep(1000);

        WebElement progLang = driver.findElement(By.xpath("//input[@value='java']"));

        progLang.click();

        Thread.sleep(1000);

        WebElement signUpButton = driver.findElement(By.xpath("//button[@type='submit']"));

        signUpButton.click();

        Thread.sleep(1000);

        WebElement successMessage = driver.findElement(By.tagName("p"));

        String expectedMessage = "You've successfully completed registration!";

        String actualMessage = successMessage.getText();

        Assert.assertTrue(successMessage.isDisplayed());

        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println("Passed");

    }


    @AfterMethod
    public void teardown(){

        driver.close();
    }

}
