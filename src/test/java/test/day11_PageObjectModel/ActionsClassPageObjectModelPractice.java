package test.day11_PageObjectModel;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;
import utilities.Driver;

public class ActionsClassPageObjectModelPractice {
  /*
    TC #50: Hover Test using Page Object Model
1. Go to http://practice.cybertekschool.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
4. Hover over to second image
5. Assert:
a. “name: user2” is displayed
6. Hover over to third image
7. Confirm:
a. “name: user3” is displayed
     */

  @Test
  public void hoversTestUsingPageObjectModel() throws InterruptedException{

      Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

      Actions actions = new Actions(Driver.getDriver());

      //2. Hover over to first image
      //3. Assert:
      //a. “name: user1” is displayed

      HoversPage hoversPage = new HoversPage();

      actions.moveToElement(hoversPage.image1).perform();

      Assert.assertTrue(hoversPage.user1.isDisplayed());

      Thread.sleep(2000);

      //2. Hover over to second image
      //3. Assert:
      //a. “name: user2” is displayed

      actions.moveToElement(hoversPage.image2).perform();

      Assert.assertTrue(hoversPage.user2.isDisplayed());

      Thread.sleep(2000);

      //2. Hover over to third image
      //3. Assert:
      //a. “name: user3” is displayed

      actions.moveToElement(hoversPage.image3).perform();

      Assert.assertTrue(hoversPage.user3.isDisplayed());

      Thread.sleep(2000);


      Driver.closeDriver();

  }



}
