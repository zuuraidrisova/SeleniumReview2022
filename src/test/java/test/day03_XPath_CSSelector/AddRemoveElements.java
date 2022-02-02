package test.day03_XPath_CSSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class AddRemoveElements {
     /*
    TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
     1. Open Chrome browser
     2. Go to http://practice.cybertekschool.com/add_remove_elements/
     3. Click to “Add Element” button
     4. Verify “Delete” button is displayed after clicking.
     5. Click to “Delete” button.
     6. Verify “Delete” button is NOT displayed after clicking.
      USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        Thread.sleep(2000);

        addButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if (deleteButton.isDisplayed()){

            System.out.println("delete is ON.passed");

        }else{

            System.out.println("delete is OFF.failed");

        }

        deleteButton.click();

        Thread.sleep(2000);

        // Verify “Delete” button is NOT displayed after clicking.
        //we know that it is gonna throw Stale Element Reference Exception
        //so we use  try catch to handle it
        try{

            if (!deleteButton.isDisplayed()){

                System.out.println("delete is OFF.passed");

            }else{

                System.out.println("delete is ON.failed");
            }

        }catch (StaleElementReferenceException e){

            System.out.println("Stale Element Reference Exception has been thrown");
            System.out.println("It means the element has been completely deleted from html");
            System.out.println("Delete Button is not Displayed.Verification Passed!");
        }

        driver.close();

    }
}
