package test.day12_Synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ForgotPasswordVerification {

    /*
    TC#51 : Vytrack forgot password page verifications à TITLE and URL
1. Go to https://qa2.vytrack.com
2. Click to “Forgot your password?” link
3. Verify title changed to expected
Expected: “Forgot Password”
4. Verify url is as expected:
Expected: “https://qa2.vytrack.com/user/reset-request”
Note: Follow Page Object Model design pattern
     */

    @Test
    public void forgotPasswordTest() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

        LoginPage loginPage = new LoginPage();

        Thread.sleep(2000);

        loginPage.forgotPasswordLink.click();

        String expected = "Forgot Password";

        String actual = Driver.getDriver().getTitle();

        Thread.sleep(2000);

        Assert.assertTrue(actual.equals(expected));

        String expectedURL = ConfigurationReader.getProperty("forgotPassword_url");

        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.equals(expectedURL));

        System.out.println("passed");

        Thread.sleep(2000);

        Driver.closeDriver();

    }
}
