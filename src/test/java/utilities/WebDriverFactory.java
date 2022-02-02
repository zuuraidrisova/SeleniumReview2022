package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    // we create and add repeated actions/methods inside this package
    // good for repeated actions, write once and use as needed, easy to maintain

    /*
    Task :
	- Write a static method in WebDriverFactory class
	- Return type is WebDriver
	- method name getDriver
	- it accepts one String argument, and returns the browser according to what string is passed
	- if "chrome" --> returns chrome browser
	- if "firefox" --> returns firefox browser
     */

    public static WebDriver getDriver(String browserType){

        WebDriver driver = null;

        if (browserType.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

        }else if (browserType.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

        }else if (browserType.equalsIgnoreCase("safari")){

            driver = new SafariDriver();

        }else{

            System.out.println("It is not valid browser type");
        }

        return driver;
    }

}
