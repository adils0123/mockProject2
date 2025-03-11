package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

 
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

   
    private By cartButton = By.xpath("//span[@class='cart-label']");

    
    private By checkoutButton = By.id("checkout");

    
    public void openCart() {
        driver.findElement(cartButton).click();
    }

    
    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
