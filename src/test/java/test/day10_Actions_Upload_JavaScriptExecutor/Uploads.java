package test.day10_Actions_Upload_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Uploads {

    @Test
    public void uploadTest() throws InterruptedException{

        //opens browser and gets the given url
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        //maximizes the page
        Driver.getDriver().manage().window().maximize();

        //waits until web elements are loaded
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //locate chooseFile web element using xpath
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));

        //wait to see
        Thread.sleep(1000);

        //we send file path as string argument
        chooseFile.sendKeys("/Users/zuura/Desktop/test.txt");

        //locate upload button using xpath
        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));

        Thread.sleep(1000);

        //click upload
        uploadButton.click();

        //locate success message using tagname
        WebElement message = Driver.getDriver().findElement(By.tagName("h3"));

        Thread.sleep(2000);

        //verify if message is displayed
        Assert.assertTrue(message.isDisplayed());

        //verify exact message
        Assert.assertEquals(message.getText(), "File Uploaded!");

        System.out.println("Passed");

        Thread.sleep(1000);

        //close the driver
        Driver.closeDriver();
    }
}
