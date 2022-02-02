package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    //we make our constructor private so no one can create an object of the class
    private Driver(){

    }


    private static WebDriver driver;
    // private ==> we dont want any access to the driver from outside
    // static ==> because  we are gonna use driver in static method


    //static method because we want to call the method thru class name
    // without creating an object of the class
    public static WebDriver getDriver(){

        //we need to get our browser
        String browserType = ConfigurationReader.getProperty("browser");

        if(driver == null){//we will create an instance of driver if only it is null


            switch (browserType){

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
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                default:
                    System.out.println("Invalid browserType");
                    break;

            }

        }

        return driver;

    }


    public static void closeDriver(){

        if (driver != null){//close the driver if only it is not closed

            driver.close();

            driver = null;//and assign the driver to null
        }
    }


}
