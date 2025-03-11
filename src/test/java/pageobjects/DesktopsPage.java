package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DesktopsPage {
    private WebDriver driver;

    public DesktopsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstDesktop = By.xpath("(//div[@class='product-item'])[1]");
    private By addToCartButton = By.xpath("//input[@value='Add to cart']");
    private By cartLink = By.xpath("//span[@class='cart-label']");

    public void selectFirstDesktop() {
        driver.findElement(firstDesktop).click();
               driver.findElement(addToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}