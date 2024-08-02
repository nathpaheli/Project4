package ProblemStatement2_SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProbStatement2_Page5_POM {
    WebDriver driver;
    //constructor
    public ProbStatement2_Page5_POM (WebDriver driver) {this.driver =driver;}

    //identification of web elements on page 5 (Checkout: Overview)
    By finish_button = By.xpath("//button[@id='finish']");
    By cancel_button = By.xpath("//button[@id='cancel']");

    //Operations on the web elements on page 5
    public void click_finishButton(){driver.findElement(finish_button).click();}

    public void click_cancelButton(){driver.findElement(cancel_button).click();}

}
