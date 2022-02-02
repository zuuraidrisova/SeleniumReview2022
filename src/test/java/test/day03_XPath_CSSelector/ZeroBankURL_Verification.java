package test.day03_XPath_CSSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankURL_Verification {
    /*
    TC #4: Zero Bank URL verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Get attribute value of href from the “forgot your password” link
4. Verify attribute value contains
Expected: “/forgot-password.html”
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        String actual = driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");

        System.out.println("actual = " + actual);

        String expected = "/forgot-password.html";

        if (actual.contains(expected)){

            System.out.println("passed");

        }else{

            System.out.println("failed");
        }

        driver.close();
    }
}
