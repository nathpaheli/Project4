package ProblemStatement2_SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProbStatement2_Page4_POM {
    WebDriver driver;
    //constructor
    public ProbStatement2_Page4_POM (WebDriver driver){this.driver = driver;}
    //identification of web elements on page 4 (Checkout: Your Information)
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zip = By.id("postal-code");
    By cancel_button = By.id("cancel");
    By continue_button = By.id("continue");
    //error msg that appears when one tries to click continue without providing first name, last name, zip code info
    By error_msg = By.xpath("//div[@class='error-message-container error']/h3[contains (text(), 'Error: First Name is required')]");
    By closeButton_errorMsg = By.xpath("//div[@class='error-message-container error']//button[@class='error-button']");

    //Operations on the web elements on page 4 (Creating methods for each element)
    public void enter_firstName(String fname){driver.findElement(firstName).sendKeys(fname);}
    public void enter_lastName(String lname){driver.findElement(lastName).sendKeys(lname);}
    public void enter_zip(String pincode){driver.findElement(zip).sendKeys(pincode);}

    public void click_continueButton(){driver.findElement(continue_button).click();}

    public void click_cancelButton(){driver.findElement(cancel_button).click();}

    public void click_closeErrorMsg(){driver.findElement(closeButton_errorMsg).click();}

}
