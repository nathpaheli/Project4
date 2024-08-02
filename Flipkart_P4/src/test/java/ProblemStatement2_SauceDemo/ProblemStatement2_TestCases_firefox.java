package ProblemStatement2_SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProblemStatement2_TestCases_firefox {
    @Test
    public void VerifyBuyingAProduct(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //create object for each of the pages we created to identify the web elements
        ProbStatement2_Page1_POM loginToSauceDemo = new ProbStatement2_Page1_POM(driver);
        ProbStatement2_Page2_POM addToCart = new ProbStatement2_Page2_POM(driver);
        ProbStatement2_Page3_POM checkout = new ProbStatement2_Page3_POM(driver);
        ProbStatement2_Page4_POM address = new ProbStatement2_Page4_POM(driver);
        ProbStatement2_Page5_POM orderOverview = new ProbStatement2_Page5_POM(driver);
        ProbStatement2_Page6_POM orderConf = new ProbStatement2_Page6_POM(driver);

        //through these objects created above, we access the methods we created in those pages

        loginToSauceDemo.enter_username("standard_user");
        loginToSauceDemo.enter_password("secret_sauce");
        loginToSauceDemo.click_login();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        addToCart.add_itemsToCart();
        addToCart.click_shoppingCartIcon();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        checkout.click_checkout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        address.enter_firstName("aaa");
        address.enter_lastName("bbb");
        address.enter_zip("07306");
        address.click_continueButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        orderOverview.click_finishButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        orderConf.get_orderConfirmation();
        orderConf.take_screenshot();
        orderConf.click_backHomeButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.close();

    }
}
