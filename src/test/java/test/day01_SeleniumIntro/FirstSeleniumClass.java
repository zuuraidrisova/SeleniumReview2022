package test.day01_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {

    /*
    TC #1: Google Title Verification
    1. Open Chrome browser
    2. Go to https://www.google.com 3. Verify title:
        Expected: Google
     */

    public static void main(String[] args) throws InterruptedException {

        //this line creates connection between driver and selenium
        //and sets up the driver
        WebDriverManager.chromedriver().setup();

        //creates an instance of chrome driver to be able to do action on chrome browser
        WebDriver driver = new ChromeDriver();

        //opens google on chrome browser
        driver.get("https://www.google.com");

        String actual = driver.getTitle();
        String expected = "Google";

        if (actual.equals(expected)){

            System.out.println("Passed");
        }else{

            System.out.println("Failed");
        }

        Thread.sleep(2000);

        driver.navigate().refresh();

        String url = driver.getCurrentUrl();

        System.out.println("url = " + url);

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(2000);

        driver.navigate().to("https://www.google.com");

        Thread.sleep(2000);

        driver.close();

    }
}
