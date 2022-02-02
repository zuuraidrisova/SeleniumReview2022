package test.day06_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleDropDownVerification {
    /*
    TC #24: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void multipleSelectVerification() throws InterruptedException{

        WebElement languagesDropdown = driver.findElement(By.xpath("//select[@name='Languages']"));

        Select select = new Select(languagesDropdown);

        select.selectByVisibleText("Java");

        Thread.sleep(1000);

        select.selectByValue("js");

        Thread.sleep(1000);

        select.selectByIndex(3);

        Thread.sleep(1000);

        select.selectByVisibleText("C#");

        Thread.sleep(1000);

        select.selectByVisibleText("Ruby");

        Thread.sleep(1000);

        select.selectByValue("c");

        Thread.sleep(1000);

        List<WebElement> progLang = select.getAllSelectedOptions();

        for (WebElement each : progLang){

            String eachProgrammingLanguage = each.getText();

            System.out.println("eachProgrammingLanguage = " + eachProgrammingLanguage);

        }

        Thread.sleep(2000);

        for (int i = 0; i < progLang.size(); i++){

            progLang.get(i).click();
        }


    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }

}
