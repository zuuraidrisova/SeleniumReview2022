package test.day01_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekTitleVerification {

    /*
TC #2: Cybertek verifications
1. Open Chrome browser
2. Go to https://cybertekschool.okta.com/
3. Verify URL contains
Expected: cybertekschool
4. Verify title:
Expected: CYDEO - Sign In
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://cybertekschool.okta.com/");

        String url = driver.getCurrentUrl();

        String expected = "cybertekschool";

        if (url.contains(expected)){

            System.out.println("Url contains cybertekschool.Passed!");

        }else{

            System.out.println("Url does not contain cybertekschool.Failed!");
        }

        String title = driver.getTitle();

        System.out.println("title = " + title);

        String expectedTitle = "CYDEO - Sign In";

        if (title.equals(expectedTitle)){

            System.out.println("Passed");
        }else{

            System.out.println("Failed");
        }

        driver.close();
    }
}
