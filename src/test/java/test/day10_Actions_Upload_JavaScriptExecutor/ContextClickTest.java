package test.day10_Actions_Upload_JavaScriptExecutor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class ContextClickTest {
    /*
    TC #17: Context Click – HOMEWORK
1. Go to https://the-internet.herokuapp.com/context_menu
2. Right click to the box.
3. Alert will open.
4. Accept alert
No assertion needed for this practice.
     */

    @Test
    public void contextClickTest() throws InterruptedException{

        //open the browser and get the page
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        //create instance of Actions class and pass Driver into constructor
        //so we can do actions using its methods
        Actions actions = new Actions(Driver.getDriver());

        Thread.sleep(2000);

        //locate box to be clicked
        WebElement boxToBeClicked = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));

        //use contextClick() method to right click onto box
        actions.contextClick(boxToBeClicked).perform();

        Thread.sleep(2000);

        //create Alert class instance and switch our driver's attention to alert
        Alert alert = Driver.getDriver().switchTo().alert();

        //accept alert
        alert.accept();

        Thread.sleep(2000);

        Driver.closeDriver();
    }

}
