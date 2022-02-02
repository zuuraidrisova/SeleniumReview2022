package test.day11_PageObjectModel;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class PositiveVyTruckTest {
    /*
    TC#49 : Vytrack positive login test às Store Manager
1. Go to https://qa2.vytrack.com
2. Enter correct username
3. Enter correct password
4. Verify title changed
Expected: “Dashboard”
Note: Follow Page Object Model design pattern
     */

    LoginPage loginPage;

    @Test
    public void positiveVyTruckTest() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

        Driver.getDriver().manage().window().maximize();

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("storeManager_username"));

        Thread.sleep(2000);

        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("storeManager_password"));

        Thread.sleep(2000);

        loginPage.loginInButton.click();

        Thread.sleep(2000);

        String expected = "Dashboard";

        String actual = Driver.getDriver().getTitle();

        Assert.assertTrue(actual.equals(expected));

        System.out.println("passed");

        Thread.sleep(2000);

        Driver.closeDriver();
    }
}
