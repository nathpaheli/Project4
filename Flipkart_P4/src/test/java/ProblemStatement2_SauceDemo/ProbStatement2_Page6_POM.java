package ProblemStatement2_SauceDemo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ProbStatement2_Page6_POM {
    WebDriver driver;
    //constructor
    public ProbStatement2_Page6_POM(WebDriver driver){this.driver = driver;}

    //identification of web elements on page 6 (Checkout: Complete!)
    By order_confirmationMsg = By.xpath("//div[@class='complete-text']");
    By image_tickMark = By.xpath("//img[@class='pony_express']");
    By backHome_button = By.xpath("//button[@id='back-to-products']");

    //Operations on the web elements on page 6
    public void get_orderConfirmation ()
    {
        String conf_msg =driver.findElement(order_confirmationMsg).getText();
        System.out.println(conf_msg);
    }

    public void take_screenshot()
    {
        File image =driver.findElement(image_tickMark).getScreenshotAs(OutputType.FILE);
        File target = new File("src/test/resources/" +"project4Image.jpeg");
        try {
            FileUtils.copyFile(image,target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click_backHomeButton(){driver.findElement(backHome_button).click();}

}
