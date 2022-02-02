package test.day03_XPath_CSSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class AmazonSearchVerification {
 /*
    Search Amazon
1.Open browser
2. Go to https://amazon.com
3. Enter any search term (use cssSelector to locate search box)
4.Verify title contains the search term
 */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://amazon.com");

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("wooden spoon"+ Keys.ENTER);

        String actual = driver.getTitle();

        String expected = "wooden spoon";

        if (actual.contains(expected)){

            System.out.println("passed");
        }else{

            System.out.println("failed");
        }

        driver.close();
    }
}
