package test.day03_XPath_CSSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class ZeroBankLoginAuthentication {
    /*
    TC #5: Basic authentication Zero Bank
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Enter username: username
4. Enter password: password
5. Click sign in button
6. Verify username is displayed on the page
7. Verify the title Zero – Account Summary
8. Verify the link Account Summary’s href value contains: “account-summary”
Print out results in validation formats
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("firefox");

        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.id("user_login")).sendKeys("username");

        driver.findElement(By.id("user_password")).sendKeys("password");

        driver.findElement(By.name("submit")).click();

        if (driver.findElement(By.linkText("username")).isDisplayed()){

            System.out.println("username is displayed. passed");

        }else{

            System.out.println("username is not displayed. failed");
        }

        String actualTitle = driver.getTitle();

        String expectedInTitle = "Zero – Account Summary";

        if (actualTitle.contains(expectedInTitle)){

            System.out.println("passed");

        }else{

            System.out.println("failed");
        }

        String actualValue = driver.findElement(By.linkText("Account Summary")).getAttribute("href");

        String expectedInValue = "account-summary";

        if (actualValue.contains(expectedInValue)){

            System.out.println("passed");

        }else{

            System.out.println("failed");
        }

        driver.close();


    }

}
