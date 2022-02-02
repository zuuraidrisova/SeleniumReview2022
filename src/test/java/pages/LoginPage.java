package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    //Page Object Model is creating java classes for each page of the web application
    //we will store all Login Page related web elements and methods into this class

    /*  to achieve Page Object Model:
           1. Create public constructor and pass this code below:
                   PageFactory.initElements(Driver.getDriver(), this);

         PageFactory is a class comes from Selenium, has initElements() method
         initElements() method is to create connection between our driver
                  and the object of current class
     */
    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@name='_submit']")
    public WebElement loginInButton;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;


    public void login(String username, String password){

        usernameInput.sendKeys(username);

        passwordInput.sendKeys(password);

        loginInButton.click();

    }

}
