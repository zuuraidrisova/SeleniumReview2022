package test.day12_Synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1Page;
import pages.Loading7Page;
import utilities.Driver;

public class ExplicitWaitPractice {
    /*
    TC#53 : Dynamically Loaded Page Elements 7
1. Go to http://practice.cybertekschool.com/dynamic_loading/7
2. Wait until title is “Dynamic title”
3. Assert : Message “Done” is displayed.
4. Assert : Image is displayed.
Note: Follow POM
     */

    @Test
    public void dynamicTitleVerificationUsingExplicitWait(){

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Loading7Page page = new Loading7Page();

        String expectedMessage = "Done!";

        String actualMessage = page.message.getText();

        System.out.println(actualMessage);

        Assert.assertTrue(expectedMessage.equals(actualMessage));

        Assert.assertTrue(page.image.isDisplayed());

        System.out.println("passed");

        Driver.closeDriver();


    }


     /*
    TC#54 : Dynamically Loaded Page Elements 1
1. Go to http://practice.cybertekschool.com/dynamic_loading/1
2. Click to start
3. Wait until loading bar disappears
4. Assert username inputbox is displayed
5. Enter username: tomsmith
6. Enter password: incorrectpassword
7. Click to Submit button
8. Assert “Your password is invalid!” text is displayed.
Note: Follow POM
     */

     @Test
     public void dynamicPageTest() throws InterruptedException{

         Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

         Loading1Page page = new Loading1Page();

         page.startButton.click();

         WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

         wait.until(ExpectedConditions.invisibilityOf(page.loadingBar));

         Assert.assertTrue(page.usernameInput.isDisplayed());

         page.usernameInput.sendKeys("tomsmith");

         Thread.sleep(2000);

         page.passwordInput.sendKeys("incorrectpassword");

         Thread.sleep(2000);

         page.submitButton.click();

         Thread.sleep(2000);

         Assert.assertTrue(page.errorMessage.isDisplayed());

         Assert.assertTrue(page.errorMessage.isDisplayed());

         System.out.println("passed");

         Thread.sleep(2000);

         Driver.closeDriver();

     }

    public static void main(String[] args) {

               /*
        2. write a program that can return the frequency of the characters
        ina string
        Ex: "AABCBCA" ==> "A3B2C2"
                 */

        String str = "AAABBCCCD";

        String r = frequencyOfCharacters(str);

        System.out.println("r = " + r);

    }

    public static String frequencyOfCharacters(String str){

        String result = "";

        String noDup ="";

        for (int i = 0; i < str.length(); i++){

            if (!noDup.contains(str.charAt(i)+"")){

                noDup += str.charAt(i);

            }
        }

        for (int i = 0; i < noDup.length(); i++){

            int count = 0;

            for (int j = 0; j < str.length(); j++){

                if (str.charAt(j) == noDup.charAt(i)){

                    count++;
                }
            }

            result += noDup.charAt(i)+""+count;

        }

        return result;

    }



}
