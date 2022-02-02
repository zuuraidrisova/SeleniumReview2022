package test.day04_CheckboxesRadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppleHeader_findElements {
      /*
    TC #16: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to all of the headers one by one
a. Mac, iPad, iPhone, Watch, TV, Music, Support
4. Print out how many links on each page with the titles of the pages
5. Loop through all
6. Print out how many link is missing text TOTAL
7. Print out how many link has text TOTAL
8. Print out how many total link TOTAL
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.apple.com");

        Thread.sleep(1000);

        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li//a"));

        int numberOfLinksWithText = 0;
        int numberOfLinksWithoutText = 0;

        for (int i = 0; i < headerLinks.size(); i++){

            headerLinks.get(i).click();

            Thread.sleep(1000);

            List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

            System.out.println("Number of links on web page: "+driver.getTitle()+" "+listOfLinks.size());


            for (WebElement each : listOfLinks){

                if (!each.getText().isEmpty()){

                    numberOfLinksWithText++;
                }else{

                    numberOfLinksWithoutText++;
                }
            }

            driver.navigate().back();

            headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li//a"));
        }

        System.out.println("numberOfLinksWithText = " + numberOfLinksWithText);
        System.out.println("numberOfLinksWithoutText = " + numberOfLinksWithoutText);


        driver.close();
    }
}
