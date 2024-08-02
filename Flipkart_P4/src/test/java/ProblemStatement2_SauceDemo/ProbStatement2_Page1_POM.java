package ProblemStatement2_SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ProbStatement2_Page1_POM {
    WebDriver driver;
    //constructor
    public ProbStatement2_Page1_POM (WebDriver driver)
    {
        this.driver = driver;
    }
   //Identification of Web Elements on page 1 of saucedemo labs
    By Username = By.id("user-name");
    By Password = By.id("password");
    By Login = By.id("login-button");

    //Operations on the web elements on page 1 (Creating methods for each element)
    public void enter_username(String name)
    {
       driver.findElement(Username).sendKeys(name);
    }

    public void enter_password(String pwd)
    {
        driver.findElement(Password).sendKeys(pwd);
    }

    public void click_login()
    {
        driver.findElement(Login).click();
    }

}
