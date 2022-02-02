package test.day07_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class SmartBearOrderVerification {
    /*
    TC#29: Smartbear software order verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
 and login to Smartbear software using ur utility method from SmartBearUtilities
3. Verify Susan McLaren has order on date “01/05/2010”
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }

    @Test
    public void verifyOrder(){

        SmartBearUtilities.loginToSmartBear(driver);

       // WebElement susanOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[6]/td[5]"));

        WebElement susanOrderDate = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr[6]/td[5]"));

        String actualDate =  susanOrderDate.getText();

        String expectedOrderDate = "01/05/2010";

        Assert.assertEquals(actualDate,expectedOrderDate);

        System.out.println("Passed");

    }

    @AfterMethod
    public  void teardown(){

        driver.close();
    }

}
