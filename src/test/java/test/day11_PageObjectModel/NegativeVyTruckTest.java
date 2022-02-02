package test.day11_PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeVyTruckTest {

     /*
   TC#47 : Vytrack negative login test à Wrong Password Test
1. Go to https://qa2.vytrack.com
2. Enter correct username
3. Enter incorrect password
4. Verify error message text is as expected
Expected: “Invalid user name or password.”
Note: Do this practice once before Page Object Model design pattern
    */

     @Test    //this is before introducing Page Object Model
     public void negativeLoginTest() throws InterruptedException{

         Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

         WebElement username = Driver.getDriver().findElement(By.id("prependedInput"));

         WebElement password = Driver.getDriver().findElement(By.id("prependedInput2"));

         WebElement loginIn = Driver.getDriver().findElement(By.id("_submit"));

         String user = ConfigurationReader.getProperty("storeManager_username");

         Thread.sleep(2000);

         username.sendKeys(user);

         Thread.sleep(2000);

         password.sendKeys("heheee");

         Thread.sleep(2000);

         loginIn.click();

         Thread.sleep(2000);

         WebElement message = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

         String expected = "Invalid user name or password.";

         String actual = message.getText();

         Assert.assertTrue(message.isDisplayed());

         Assert.assertTrue(actual.equals(expected));

         System.out.println("passed");

         Thread.sleep(2000);

         Driver.closeDriver();

     }

       /*
   TC#47 : Vytrack negative login test à Wrong Password Test
1. Go to https://qa2.vytrack.com
2. Enter correct username
3. Enter incorrect password
4. Verify error message text is as expected
Expected: “Invalid user name or password.”
Note: Do this practice USING Page Object Model design pattern
    */

    //this is after introducing Page Object Model


    LoginPage loginPage;

    LandingPage landingPage;


    @Test    //this is before introducing Page Object Model
    public void negativeLoginTestUsingPageObjectModel() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

        loginPage = new LoginPage();

        landingPage = new LandingPage();

        String user = ConfigurationReader.getProperty("storeManager_username");

        Thread.sleep(2000);

        loginPage.usernameInput.sendKeys(user);

        Thread.sleep(2000);

        loginPage.passwordInput.sendKeys("heheee");

        Thread.sleep(2000);

        loginPage.loginInButton.click();

        Thread.sleep(2000);

        String expected = "Invalid user name or password.";

        String actual = landingPage.errorMessage.getText();

        Assert.assertTrue(landingPage.errorMessage.isDisplayed());

        Assert.assertTrue(actual.equals(expected));

        System.out.println("passed");

        Thread.sleep(2000);

        Driver.closeDriver();

    }


    /*
    TC#48 : Vytrack negative login test à Wrong Username Test
1. Go to https://qa2.vytrack.com
2. Enter incorrect username
3. Enter correct password
4. Verify error message text is as expected
Expected: “Invalid user name or password.”
Note: Follow Page Object Model design pattern
     */


    @Test
    public void wrongUsernameTest() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

        loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("jdgae387");

        Thread.sleep(1000);

        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("storeManager_password"));

        Thread.sleep(1000);

        loginPage.loginInButton.click();

        Thread.sleep(1000);

        landingPage = new LandingPage();

        Assert.assertTrue(landingPage.errorMessage.isDisplayed());

        String expected = "Invalid user name or password.";

        Assert.assertEquals(landingPage.errorMessage.getText(), expected);

        System.out.println("passed");

        Thread.sleep(1000);

        Driver.closeDriver();

    }

      /*
    TC#48 : Vytrack negative login test à Wrong Username Test
1. Go to https://qa2.vytrack.com
2. Enter incorrect username
3. Enter correct password
4. Verify error message text is as expected
Expected: “Invalid user name or password.”
Note: Follow Page Object Model design pattern and use login() method we created
     */


    @Test
    public void wrongUsernameTestUsingLoginMethod() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

        loginPage = new LoginPage();

        String username = "ajhgdis";

        String password = ConfigurationReader.getProperty("storeManager_password");

        loginPage.login(username, password);

        landingPage = new LandingPage();

        Assert.assertTrue(landingPage.errorMessage.isDisplayed());

        String expected = "Invalid user name or password.";

        Assert.assertEquals(landingPage.errorMessage.getText(), expected);

        System.out.println("passed");

        Thread.sleep(1000);

        Driver.closeDriver();

    }


}
