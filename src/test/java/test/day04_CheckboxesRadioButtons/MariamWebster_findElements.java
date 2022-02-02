package test.day04_CheckboxesRadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MariamWebster_findElements {
      /*
    TC #14: FINDELEMENTS
1. Open Chrome browser
2. Go to https://www.merriam-webster.com/
3. Print out the texts of all links
4. Print out how many link is missing text
5. Print out how many link has text
6. Print out how many total link
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.merriam-webster.com/");

        List<WebElement> listOfAllLinks = driver.findElements(By.tagName("a"));

        System.out.println("total number of links = " + listOfAllLinks.size());

        int linksWithText = 0;
        int linksWithoutText = 0;

        for (WebElement each : listOfAllLinks){

            if (!each.getText().isEmpty()){

                linksWithText++;

            }else{

                linksWithoutText++;
            }
        }

        System.out.println("number of linksWithText = " + linksWithText);

        System.out.println("number of linksWithoutText = " + linksWithoutText);

        for (WebElement each : listOfAllLinks){

            String eachLinkText = each.getText();

            System.out.println("eachLinkText = " + eachLinkText);
        }

        driver.close();

    }
}
