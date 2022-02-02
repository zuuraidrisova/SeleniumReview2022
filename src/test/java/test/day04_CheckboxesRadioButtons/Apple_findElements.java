package test.day04_CheckboxesRadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Apple_findElements {
      /*
    TC #15: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to iPhone
4. Print out the texts of all links
5. Print out how many link is missing text
6. Print out how many link has text
7. Print out how many total link
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.apple.com");

        driver.findElement(By.linkText("iPhone")).click();

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println("Total number of links "+allLinks.size());

        int linksWithText = 0;
        int linksWithoutText = 0;

        for (int i = 0; i < allLinks.size(); i++){

            if (!allLinks.get(i).getText().isEmpty()){

                linksWithText++;

            }else{

                linksWithoutText++;
            }
        }

        System.out.println("linksWithText = " + linksWithText);

        System.out.println("linksWithoutText = " + linksWithoutText);

        for (WebElement each : allLinks){

            System.out.println("links with text: "+each.getText());
        }

        driver.close();

    }

}
