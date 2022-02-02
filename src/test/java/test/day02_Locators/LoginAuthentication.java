package test.day02_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAuthentication {
    /*
    TC #5: Basic login authentication
    1- Open a chrome browser
    2- Go to:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3- Verify title equals:
Expected: Web Orders Login
    4- Enter username: Tester
    5- Enter password: test
    6- Click “Sign In” button
    7- Verify title equals:
Expected: Web Orders
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String actualTitle = driver.getTitle();

        String expectedTitle = "Web Orders Login";

        if (actualTitle.equals(expectedTitle)){

            System.out.println("Passed");
        }else{

            System.out.println("Failed");
        }

        Thread.sleep(2000);

        WebElement usernameInput = driver.findElement(By.name("ctl00$MainContent$username"));

        WebElement passwordInput = driver.findElement(By.name("ctl00$MainContent$password"));

        WebElement loginButton = driver.findElement(By.name("ctl00$MainContent$login_button"));

        usernameInput.sendKeys("Tester");

        Thread.sleep(2000);

        passwordInput.sendKeys("test");

        Thread.sleep(2000);

        loginButton.click();

        Thread.sleep(2000);

        String actual = driver.getTitle();

        String expected = "Web Orders";

        if (actual.equals(expected)){

            System.out.println("Passed");

        }else{

            System.out.println("Failed");
        }

        Thread.sleep(2000);

        driver.close();

    }
}
