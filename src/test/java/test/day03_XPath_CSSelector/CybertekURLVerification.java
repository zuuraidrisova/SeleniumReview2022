package test.day03_XPath_CSSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekURLVerification {
/*
TC #3: PracticeCybertek/ForgotPassword URL verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Enter any email into input box
4. Click on Retrieve password
5. Verify URL contains:
Expected: “email_sent”
6. Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”
 */
    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");

       WebElement emailInput =  driver.findElement(By.xpath("//input[@type='text']"));

       emailInput.sendKeys("zuuraidrisova@gmail.com");

        driver.findElement(By.id("form_submit")).click();

        Thread.sleep(2000);

        String url = driver.getCurrentUrl();

        if (url.contains("email_sent")){

            System.out.println("Passed");

        }else{

            System.out.println("Failed");
        }

        String actual = driver.findElement(By.name("confirmation_message")).getText();

        System.out.println(actual);

        String expected = "Your e-mail's been sent!";

        if (actual.equals(expected)){

            System.out.println("Passed");

        }else{

            System.out.println("Failed");
        }

        WebElement confirmationMessageWebElement = driver.findElement(By.name("confirmation_message"));

        if (confirmationMessageWebElement.isDisplayed()){

            System.out.println("Passed");
        }else{

            System.out.println("Failed");
        }

        driver.close();
    }
}
