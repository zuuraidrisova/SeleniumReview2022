package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SmartBearUtilities {

    /*
    Mini-Task:•Create a method called loginToSmartBear
    •This method simply logs in to SmartBear when you call it.
    •Accepts WebDriver type as parameter
     */

    public static void loginToSmartBear(WebDriver driver){

        WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));

        WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        username.sendKeys("Tester");

        password.sendKeys("test");

        loginButton.click();

    }

           /*
PRACTICE #4: Method: verifyOrder
• Create a method named verifyOrder in SmartBearUtils class.
• Method takes WebDriver object and String(name).
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.
     */

     public static void verifyOrder(WebDriver driver, String name){
                                                                    ////table[@class='SampleTable']/tbody/tr/td[2]
         List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

         String actualName = "";

         for (WebElement each : listOfNames){

             if (each.getText().equals(name)){

                 actualName = each.getText();
             }
         }

         Assert.assertTrue(actualName.equals(name));

     }

     /*
    Practice #5: Method: printNamesAndCities
• Create a method named printNamesAndCities in SmartBearUtils class.
• Method takes WebDriver object.
• This method should simply print all the names in the List of All Orders.
• Create a new TestNG test to test if the method is working as expected.
• Output should be like:
• Name1: name , City1: city
• Name2: name , City2: city
     */

     public static void printNamesAndCities(WebDriver driver){

         List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

         List<WebElement> listOfCities =  driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[7]"));

         for (int i = 0; i < listOfNames.size(); i++){

             System.out.println("Name"+(i+1)+": "+listOfNames.get(i).getText()+", City"+(i+1)+": "+listOfCities.get(i).getText());
         }

     }

      /*
    TC #38 : Create a method called removeName()
1. Accepts two parameters: WebDriver, String name
2. Method will remove the given name from the list of Smartbear
3. Create a new TestNG test, and call your method.
4. Assert that your method removed the given name
     */

      public static  void removeMarkSmith(WebDriver driver){

          WebElement markSmith = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));

          markSmith.click();

          WebElement deleteButton = driver.findElement(By.xpath("//input[@value='Delete Selected']"));

          deleteButton.click();

          List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']//tbody/tr/td[2]"));

          List<String> names = new ArrayList<>();

          String nameDeleted = "Mark Smith";

          for (WebElement each : listOfNames){

              names.add(each.getText());

          }

          Assert.assertTrue(! names.contains(nameDeleted));

          //using if conditions
          if (!names.contains(nameDeleted)){

              System.out.println("Mark Smith is not on the list.Passed");
          }else{

              System.out.println("Mark Smith is on the list.Failed");
          }
      }
}
