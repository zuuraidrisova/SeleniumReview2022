package test.day10_Actions_Upload_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class HoverOverTest {
     /*
    TC #15: Hover Test
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
    public void hoverOverTest() throws InterruptedException{

         Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

         Actions actions = new Actions(Driver.getDriver());

         WebElement image1 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]"));

         //2. Hover over to first image
         actions.moveToElement(image1).perform();

         WebElement text1 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]/div/h5"));

         //assert “name: user1” is displayed
         Assert.assertTrue(text1.isDisplayed());

         Thread.sleep(2000);

         WebElement image2 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]"));

         //2. Hover over to second image
         actions.moveToElement(image2).perform();

         WebElement text2 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]/div/h5"));

         //assert “name: user2” is displayed
         Assert.assertTrue(text2.isDisplayed());

         Thread.sleep(2000);

         WebElement image3 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][3]"));

         WebElement text3 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][3]/div/h5"));

         //2. Hover over to third image
         actions.moveToElement(image3).perform();

         //assert “name: user3” is displayed
         Assert.assertTrue(text3.isDisplayed());

         Thread.sleep(2000);

         Driver.closeDriver();


     }

}
