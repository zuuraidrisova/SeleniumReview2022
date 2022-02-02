package test.day07_WebTables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class SmartBearOrderPlacing {
       /*
    TC#2: Smartbear software order placing
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on “visa” radio button
11. Generate card number using JavaFaker
12. Click on “Process”
13. Verify success message “New order has been successfully added.”
     */

       WebDriver driver;

       @BeforeMethod
       public void setup(){

           driver = WebDriverFactory.getDriver("chrome");

           driver.manage().window().maximize();

           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

           driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

       }

       @Test
       public void orderPlacingTest() throws InterruptedException{

           WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));

           WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));

           WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

           username.sendKeys("Tester");

           Thread.sleep(1000);

           password.sendKeys("test");

           Thread.sleep(1000);

           loginButton.click();

           Thread.sleep(1000);

           WebElement orderLink = driver.findElement(By.linkText("Order"));

           orderLink.click();

           Thread.sleep(1000);

           WebElement product = driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']"));

           Select select = new Select(product);

           select.selectByVisibleText("FamilyAlbum");

           Thread.sleep(1000);

           WebElement quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));

           //quantity.clear();
           //we have to clear the default value in order to enter actual quantity
           quantity.sendKeys(Keys.BACK_SPACE);

           quantity.sendKeys("2");

           Thread.sleep(1000);

           WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));

           calculateButton.click();

           Faker faker = new Faker();

           WebElement nameInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));

           WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));

           WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));

           WebElement state = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));

           WebElement zip = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));

           WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));

           WebElement expDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));

           WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));

           WebElement cardType = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));

           Thread.sleep(1000);

           nameInput.sendKeys(faker.name().fullName());

           Thread.sleep(1000);

           street.sendKeys(faker.address().streetName());

           Thread.sleep(1000);

           city.sendKeys(faker.address().cityName());

           Thread.sleep(1000);

           state.sendKeys(faker.address().state());

           Thread.sleep(1000);

           zip.sendKeys(faker.address().zipCode().replaceAll("-",""));

           Thread.sleep(1000);

           cardType.click();

           Thread.sleep(1000);

           cardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));

           Thread.sleep(1000);

           expDate.sendKeys("10/28");

           Thread.sleep(1000);

           processButton.click();

           Thread.sleep(1000);

           WebElement successMessage = driver.findElement(By.tagName("strong"));

           Assert.assertTrue(successMessage.isDisplayed());

           String actualSuccessMessage = successMessage.getText();

           String expectedSuccessMessage = "New order has been successfully added.";

           Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

           System.out.println("Passed");
       }

       @AfterMethod
       public void teardown(){

           driver.close();
       }

}
