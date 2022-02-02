package test.day09_TestBase_Properties_DriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.ConfigurationReader;

public class Singleton {

    /*
    SINGLETON DESIGN PATTERN:
-> Making the constructor private to limit the user access to the object of the class.
-> Then we create our own logic with our getter method, to allow user to use the instance we are creating.
     */

    private Singleton(){

    }


    private static WebDriver driver;


    public static WebDriver getDriver(){

        String browser = ConfigurationReader.getProperty("browser");

        if (driver == null){

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    System.out.println("Invalid browser type");
                    break;

            }

        }

        return driver;
    }


    public static void closeDriver(){

        if (driver != null){

            driver.close();

            driver = null;
        }
    }


}
