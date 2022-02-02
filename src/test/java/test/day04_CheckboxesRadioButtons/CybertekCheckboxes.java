package test.day04_CheckboxesRadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class CybertekCheckboxes {
       /*
    TC17: Practice: Cybertek Checkboxes
1. Go to http://practice.cybertekschool.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));

        if (checkbox1.isSelected()){

            System.out.println("Checkbox 1 is selected.failed");

        }else{

            System.out.println("Checkbox 1 is not selected.passed");
        }

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));


        if (checkbox2.isSelected()){

            System.out.println("Checkbox 2 is selected. passed");

        }else{

            System.out.println("Checkbox 2 is not selected. failed");
        }


        checkbox1.click();

        checkbox2.click();

        System.out.println("*************************************");

        if (checkbox1.isSelected()){

            System.out.println("Checkbox 1 is selected.passed");

        }else{

            System.out.println("Checkbox 1 is not selected.failed");
        }

        if (checkbox2.isSelected()){

            System.out.println("Checkbox 2 is selected. failed");

        }else{

            System.out.println("Checkbox 2 is not selected. passed");
        }


        driver.close();
    }
}
