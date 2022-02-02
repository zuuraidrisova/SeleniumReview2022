package test.day03_XPath_CSSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class Delete50Times {
     /*
    TC #13: PracticeCybertek.com_AddRemoveElements WebElement verification
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/add_remove_elements/
    3. Click to “Add Element” button 50 times
    4. Verify 50 “Delete” button is displayed after clicking.
    5. Click to ALL “Delete” buttons to delete them.
    6. Verify “Delete” button is NOT displayed after clicking.

     USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
      Hint: Need to use findElements method.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        //    3. Click to “Add Element” button 50 times
        for (int i = 0; i < 50 ; i++){

            addButton.click();
        }

        //this xpath will return all web elements which equals text Delete
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));

        int numberOfDelete = deleteButtons.size();

        System.out.println("numberOfDelete = " + numberOfDelete);

        //    4. Verify 50 “Delete” button is displayed after clicking.
        for (WebElement each : deleteButtons ){

            if (each.isDisplayed()){

                System.out.println("Delete button is displayed.passed");

            }else{

                System.out.println("delete button is not displayed.failed");
            }

        }

        //    5. Click to ALL “Delete” buttons to delete them.
        for (int i = 0; i < 50; i++){

            deleteButtons.get(i).click();
        }

        // Verify “Delete” button is NOT displayed after clicking.
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
