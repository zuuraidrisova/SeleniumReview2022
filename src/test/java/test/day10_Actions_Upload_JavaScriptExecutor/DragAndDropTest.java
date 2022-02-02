package test.day10_Actions_Upload_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DragAndDropTest {
    /*
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
     */

    @Test
    public void dragAndDropTest() throws InterruptedException{

        //open the browser and get the page
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //locate small circle using xpath
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));

        //locate big circle using xpath
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        //create Actions class instance to be able to use its methods
        Actions actions = new Actions(Driver.getDriver());

        Thread.sleep(2000);

        //dragAndDrop() method will do intended action
        actions.dragAndDrop(smallCircle, bigCircle).perform();

        //below line also works as such
        // actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();
        //actions.release().perform();

        Thread.sleep(2000);

        WebElement text = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Assert.assertTrue(text.isDisplayed());

        System.out.println("passed");

        Thread.sleep(2000);

        Driver.closeDriver();
    }

}
