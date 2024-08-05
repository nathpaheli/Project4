package LoginScenarios_SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests_SauceDemo {
    WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test(dataProvider = "dp")
    public void testLogin(String scenario, String uname, String pwd) throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys(uname);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(4000);

        if (scenario.equals("valid_credential")) {
            String productTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
            Assert.assertEquals(productTitle, "Products");
            driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
            driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();

        } else if (scenario.equals("invalid_credential")) {
            String errorMsgText = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]")).getText();
            Assert.assertEquals(errorMsgText, "Epic sadface: Sorry, this user has been locked out.");
            driver.navigate().refresh();

        } else if (scenario.equals("unknown_credential"))
        {
            String errorMsgText2 =driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText();
            Assert.assertEquals(errorMsgText2, "Epic sadface: Username and password do not match any user in this service");
            driver.navigate().refresh();
        }else
        {
            Assert.assertTrue(false, "This is some malfunction");
        }
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    @DataProvider(name="dp")
    Object[][] loginData()
    {
        Object data[][]={
                {"valid_credential","standard_user", "secret_sauce"},
                {"valid_credential","problem_user", "secret_sauce"},
                {"valid_credential","error_user", "secret_sauce"},
                {"valid_credential","visual_user", "secret_sauce"},
                {"invalid_credential","locked_out_user", "secret_sauce"},
                {"valid_credential","performance_glitch_user", "secret_sauce"},
                {"unknown_credential", "abcd_user", "test_abcd"}
        };
        return data;
    }


}

