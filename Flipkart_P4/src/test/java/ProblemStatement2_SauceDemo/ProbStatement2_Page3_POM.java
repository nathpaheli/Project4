package ProblemStatement2_SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProbStatement2_Page3_POM {
    WebDriver driver;
    //constructor
    public ProbStatement2_Page3_POM(WebDriver driver){this.driver = driver;}
    //identification of web elements on page 3 (Your Cart)
    By remove_item = By.xpath("//div//button[@class='btn btn_secondary btn_small cart_button']");
    By continue_shopping = By.xpath("//button[@id='continue-shopping']");
    By checkout = By.xpath("//button[@id='checkout']");

    //Operations on the web elements on page 3 (Creating methods for each element)
    public void click_remove(){driver.findElement(remove_item).click();}

    public void  click_continueShopping(){driver.findElement(continue_shopping).click();}

    public void click_checkout(){driver.findElement(checkout).click();}


}
