package test.day02_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLinkVerification {

    /*
TC #3: Back and forth navigation
Open a chrome browser
Go to: https://google.com
Click to Gmail from top right.
Verify title contains:
	Expected: Gmail
Go back to Google by using the .back();
Verify title equals:
	Expected: Google
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement gmail = driver.findElement(By.linkText("Gmail"));

        gmail.click();

        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedInTitle)){

            System.out.println("Passed!");

        }else{

            System.out.println("Failed!");
        }

        Thread.sleep(2000);

        driver.navigate().back();

        String actual_title = driver.getTitle();
        String expected_title = "Google";

        if (actual_title.equals(expected_title)){

            System.out.println("Passed");
        }else{

            System.out.println("Failed");
        }


        driver.close();

    }
}
