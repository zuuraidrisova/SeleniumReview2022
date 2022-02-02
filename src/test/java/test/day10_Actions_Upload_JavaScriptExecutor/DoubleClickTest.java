package test.day10_Actions_Upload_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DoubleClickTest {
     /*
    TC #43: Double Click Test
1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
2. Switch to iframe.
3. Double click on the text “Double-click me to change my text color.”
4. Assert: Text’s “style” attribute value contains “red”.
     */

     @Test
     public void doubleClickTest() throws InterruptedException{

         //open the chrome and get the page
         Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

         //locate the iframe so we can do action on it
         WebElement iframe = Driver.getDriver().findElement(By.xpath("//iframe[@id='iframeResult']"));

         Thread.sleep(1000);

         //switch to iframe using locator to be able to do action on it
         Driver.getDriver().switchTo().frame(iframe);

         //locate text to be double clicked using xpath
         WebElement textToBeClicked = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));

         //create an instance of Actions class so we can use its methods
         Actions actions = new Actions(Driver.getDriver());

         //using doubleClick() method and perform() to do actions
         actions.doubleClick(textToBeClicked).perform();

         Thread.sleep(1000);

         //locating text web element again so we can get style attribute value to use in our assertion
         textToBeClicked = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));

         Assert.assertTrue(textToBeClicked.getAttribute("style").contains("red"));

         System.out.println("passed");

         Driver.getDriver().switchTo().parentFrame();

         Driver.closeDriver();

     }
}
