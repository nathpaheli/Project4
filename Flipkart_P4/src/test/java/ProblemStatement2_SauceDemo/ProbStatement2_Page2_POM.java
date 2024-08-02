package ProblemStatement2_SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProbStatement2_Page2_POM {
    WebDriver driver;
    //constructor
    public ProbStatement2_Page2_POM(WebDriver driver)
    {
       this.driver = driver;
    }
    //Identification of Web Elements on page 2 (Products)
    //the products
    By addToCart_product1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    By addToCart_product2 = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    By addToCart_product3 = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
    By addToCart_product4 = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    By addToCart_product5 = By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']");
    By addToCart_product6 = By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
    //menu button
    By menu = By.xpath("//button[@id='react-burger-menu-btn']");
    //menu options
    By all_items = By.xpath("//a[@id='inventory_sidebar_link']");
    By about = By.xpath("//a[@id='about_sidebar_link']");
    By logout = By.xpath("//a[@id='logout_sidebar_link']");
    By reset_app_state = By.xpath("//a[@id='reset_sidebar_link']");
    By close_menu_options = By.xpath("//div[@class='bm-cross-button']/button[@id='react-burger-cross-btn']");
    //shopping cart icon
    By shopping_cart = By.xpath("//div[@id='shopping_cart_container']/a");

    //Operations on the web elements on page 2 (Creating methods for each element)
    public void add_itemsToCart ()
    {
        driver.findElement(addToCart_product1).click();
        driver.findElement(addToCart_product2).click();
    }

    public void click_menu (){driver.findElement(menu).click();}

    public void click_shoppingCartIcon(){driver.findElement(shopping_cart).click();}

    public void logOut(){driver.findElement(logout).click();}
}
