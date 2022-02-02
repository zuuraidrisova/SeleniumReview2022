package test.day02_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleTitleVerification {

    /*
    TC #4: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Click google search button
5- Verify title:
Expected: Title should start with “apple” word
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com");

        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);

        String actual = driver.getTitle();

        String expectedInTitle = "apple";

        if (actual.contains(expectedInTitle)){

            System.out.println("Passed");

        }else{

            System.out.println("Failed");
        }

        Thread.sleep(2000);

        driver.close();
    }
}
