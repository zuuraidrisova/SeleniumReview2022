package test.day10_Actions_Upload_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class JavaScriptExecutor_interface {

    /*
    --> JavaScriptExecutor :
-> is just an interface with 2 methods.
-> This interface allows us to execute JavaScript code in our Selenium code.
-> We pass the javascript scripts as strings into the methods we call from JavaScriptExecutor.
-> If we are using WebDriver interface reference, we must cast our driver type
to JavaScriptExecutor.
     */

    @Test
    public void javaScriptExecutorTest() throws InterruptedException{

        //we set up driver, open browser and get the given link
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        //locate the element we want to scroll until
        WebElement scrollElement = Driver.getDriver().findElement(By.partialLinkText("Cybertek"));

        //we cast our Driver to JavaScriptExecutor to be able to use its JS methods
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

        Thread.sleep(2000);

        //we use executeScript() method and pass two arguments
        // 1. arguments[0].scrollIntoView(true); ==> is js code
        // 2. web element we located to scroll
        js.executeScript("arguments[0].scrollIntoView(true);", scrollElement);

        Thread.sleep(2000);

        Driver.closeDriver();

    }
}
