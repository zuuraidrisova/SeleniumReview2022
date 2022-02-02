package test.day10_Actions_Upload_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class ScrollingDownTestUsingActions {


    @Test
    public void scrollDownTest() throws InterruptedException{

        //open the browser and get the page
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        //create Actions class instance to be able to use its methods
        Actions actions = new Actions(Driver.getDriver());

        //locate link to scroll until
        WebElement link = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        Thread.sleep(2000);

        //use moveToElement() and perform() method to do intended action
        actions.moveToElement(link).perform();

        Thread.sleep(2000);

        WebElement inputLink = Driver.getDriver().findElement(By.linkText("Inputs"));

        actions.moveToElement(inputLink).perform();

        Driver.closeDriver();

    }

}
