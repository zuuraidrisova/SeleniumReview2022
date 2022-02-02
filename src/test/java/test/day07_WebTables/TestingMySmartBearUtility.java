package test.day07_WebTables;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestingMySmartBearUtility {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }

    @Test
    public void testSmartBearUtility() throws InterruptedException{

        SmartBearUtilities.loginToSmartBear(driver);

        Thread.sleep(2000);

        SmartBearUtilities.verifyOrder(driver, "Steve Johns");

        SmartBearUtilities.printNamesAndCities(driver);

        SmartBearUtilities.removeMarkSmith(driver);
    }

    @AfterMethod
    public void teardown(){

        driver.close();

    }

}
