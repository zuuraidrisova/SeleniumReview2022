package test.day12_Synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ErrorMessageVerification {

     /*
    TC#52 : Vytrack forgot password page verification à ERROR MESSAGE
1. Go to https://qa2.vytrack.com/user/reset-request
2. Enter random username
3. Click to request button
4. Verify error message is displayed
5. Verify error message text is as expected.
Expected: There is no active user with username or email address “given text”.
Note: Follow Page Object Model design pattern
     */

     @Test
    public void errorMessageTest() throws InterruptedException{

         Driver.getDriver().get(ConfigurationReader.getProperty("forgotPassword_url"));

         ForgotPasswordPage page = new ForgotPasswordPage();

         Thread.sleep(2000);

         String usernameRandom = "hello212";

         page.usernameInput.sendKeys(usernameRandom);

         Thread.sleep(2000);

         page.requestButton.click();

         Thread.sleep(2000);

         Assert.assertTrue(page.errorMessage.isDisplayed());

         String expectedErrorMessage = "There is no active user with username or email address \"" + usernameRandom + "\".";

         String actualErrormessage = page.errorMessage.getText();

         Assert.assertTrue(actualErrormessage.equals(expectedErrorMessage));

         System.out.println("passed");

         Thread.sleep(2000);

         Driver.closeDriver();
     }

}
